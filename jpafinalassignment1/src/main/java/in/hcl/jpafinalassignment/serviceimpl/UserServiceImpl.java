package in.hcl.jpafinalassignment.serviceimpl;

import in.hcl.jpafinalassignment.dao.UserDAO;
import in.hcl.jpafinalassignment.daoimpl.UserDAOImpl;
import in.hcl.jpafinalassignment.domain.User;
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
// TODO Auto-generated method stub

	}

	@Override
	public void removeUser(int id) {
// TODO Auto-generated method stub

	}

	@Override
	public void showAllUser() {
// TODO Auto-generated method stub

	}
}