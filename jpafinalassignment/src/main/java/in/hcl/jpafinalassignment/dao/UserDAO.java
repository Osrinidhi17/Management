package in.hcl.jpafinalassignment.dao;

import in.hcl.jpafinalassignment.domain.User;
import in.hcl.jpafinalassignment.exception.UserNotFoundException;

public interface UserDAO {
	void addUser(User user);

	void deleteUser(int id) throws UserNotFoundException;

	void updateUser(User user);

	void showUser();
}