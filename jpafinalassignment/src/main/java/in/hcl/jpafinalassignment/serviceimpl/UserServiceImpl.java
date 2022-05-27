package in.hcl.jpafinalassignment.serviceimpl;

import in.hcl.jpafinalassignment.dao.UserDAO;
import in.hcl.jpafinalassignment.daoimpl.UserDAOImpl;
import in.hcl.jpafinalassignment.domain.User;
import in.hcl.jpafinalassignment.exception.UserNotFoundException;
import in.hcl.jpafinalassignment.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDAO userDAO;

	public UserServiceImpl() {
		userDAO = new UserDAOImpl();
	}

	@Override
	public void createUser(User user) {
		userDAO.addUser(user);

	}

	@Override
	public void updateUser(User user) {
		userDAO.updateUser(user);
	}

	@Override
	public void removeUser(int id) throws UserNotFoundException {
		userDAO.deleteUser(id);
	}

	@Override
	public void showAllUser() {
		userDAO.showUser();
	}
}