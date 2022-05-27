package in.hcl.jpafinalassignment.service;



import in.hcl.jpafinalassignment.domain.User;

public interface UserService {
void createUser(User user);
void updateUser(User user);
void removeUser(int id);
void showAllUser();
}