package service;

import bean.User;

public interface IUserService {

	User login(User u);

	void addUser(User u);

	void updateUser(User user);


}
