package service;

import java.util.List;

import bean.User;

public interface IUserService {

	User login(User u);
	
	void addThirdUser(User user);
	
	boolean ifExsitUser(User user);

	void addUser(User u);

	void updateUser(User user);

	List<User> getAllUser();


}
