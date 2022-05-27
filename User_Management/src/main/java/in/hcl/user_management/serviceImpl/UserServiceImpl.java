package in.hcl.user_management.serviceImpl;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import in.hcl.user_management.domain.User;
import in.hcl.user_management.exception.UserIdException;
import in.hcl.user_management.repository.UserRepository;
import in.hcl.user_management.service.UserService;
import in.hcl.user_management.util.Status;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate = new JdbcTemplate();
	private Connection conn = null;
	private Statement stmt = null;

	@Override
	public User registerUser(User u) {
		try {
			return userRepository.save(u);
		} catch (Exception e) {
			throw new UserIdException("User ID " + u.getId() + " already exist");
		}
	}

	@Override
	public boolean passwordVaild(User u) {
		final String PASSWORD_PATTERN =
	            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";

	    final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
			Matcher matcher = pattern.matcher(u.getPassword());
			return matcher.matches();
		}

	@Override
	public Status loginUser(User u) {
		List<User> users = userRepository.findAll();
		for (User user : users) {
			if ((user.getUsername()).equals(u.getUsername()) && (user.getPassword()).equals(u.getPassword())) {
				return Status.LOGIN_SUCCESS;
			} else if (((user.getUsername()) != (u.getUsername()) && (user.getPassword()).equals(u.getPassword()))) {
				return Status.USERNAME_NOT_CORRECT;
			} else if (((user.getUsername()).equals(u.getUsername()) && (user.getPassword()) != (u.getPassword()))) {
				return Status.PASSWORD_NOT_CORRECT;
			}
		}
		return Status.USERNAME_AND_PASSWORD_NOT_CORRECT;
	}

	@Override
	public Status logoutUser(User u) {
		List<User> users = userRepository.findAll();
		for (User user : users) {
			if ((user.getUsername()).equals(u.getUsername()) && (user.getPassword()).equals(u.getPassword())) {
				return Status.LOGOUT_SUCCESS;
			}
		}
		return Status.USERNAME_AND_PASSWORD_NOT_CORRECT;
	}

	@Override
	public Status changePassword(User u) {
		List<User> users = userRepository.findAll();
		for (User user : users) {
			if ((user.getUsername()).equals(u.getUsername())) {
				String sql = "update user set password = '" + u.getPassword() + "' where username = '" + u.getUsername()
						+ "'";
				jdbcTemplate.setDataSource(dataSource);
				System.out.println("Password updated successfully");
				jdbcTemplate.update(sql);
				return Status.PASSWORD_UPDATED_SUCCESSFULLY;
			}
		}
		return Status.USERNAME_NOT_FOUND;
	}

	@Override
	public Status updateProfile(User u) {
		String sql = "update user set username = '" + u.getUsername() + "', address = '" + u.getAddress()
				+ "', mobile_no = '" + u.getMobileNo() + "', password = '" + u.getPassword() + "', update_at = now() where id = '"
				+ u.getId() + "'";
		jdbcTemplate.setDataSource(dataSource);
		System.out.println("Profile updated successfully");
		jdbcTemplate.update(sql);
		return Status.PROFILE_UPDATED_SUCCESSFULLY;
	}

	@Override
	public Status deleteProfile(Long id) {
		Optional<User> user = userRepository.findById(id);
		if(user == null) {
			throw new UserIdException("User Id : "+ id + "Does not exist");
	}
		userRepository.deleteById(user.get().getId());
		return Status.USER_DELETED_SUCCESSFULLY;
	}

	@Override
	public Iterable<User> findAllUser() {
		return userRepository.findAll();
	}
}
