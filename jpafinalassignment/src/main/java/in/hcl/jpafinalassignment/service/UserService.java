package in.hcl.jpafinalassignment.service;

import in.hcl.jpafinalassignment.domain.User;
import in.hcl.jpafinalassignment.exception.UserNotFoundException;

public interface UserService {
	void createUser(User user);

	void updateUser(User user);

	void removeUser(int id) throws UserNotFoundException;

	void showAllUser();
}