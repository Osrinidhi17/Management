package in.hcl.user_management.service;

import in.hcl.user_management.domain.User;
import in.hcl.user_management.util.Status;

public interface UserService {
	
	public User registerUser(User user);
	public boolean passwordVaild(User user);
	public Status loginUser(User user);
	public Status logoutUser(User user);
	public Status changePassword(User user);
	public Status updateProfile(User user);
	public Status deleteProfile(Long id);
	public Iterable<User> findAllUser();

}
