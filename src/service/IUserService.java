package service;

import bean.Demo;
import bean.User;

public interface IUserService {

	User login(User u);

	void addUser(User u);

	void addUser(User user, Demo demo);


}
