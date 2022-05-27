package in.hcl.jpafinalassignment.dao;

import in.hcl.jpafinalassignment.domain.User;

public interface UserDAO {
	void addUser(User user);

	void deleteUser(int id);

	void updateUser(User user);

	void showUser();
}