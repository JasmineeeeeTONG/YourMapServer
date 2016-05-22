package service.impl;

import java.util.ArrayList;
import java.util.List;

import bean.Demo;
import bean.User;
import dao.EntityDAO;
import exception.LoginFailException;
import exception.RepeatException;
import service.IUserService;

@SuppressWarnings("unchecked")
public class UserServiceImpl implements IUserService {
	private EntityDAO entityDAO;

	public void setEntityDAO(EntityDAO entityDAO) {
		this.entityDAO = entityDAO;
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		String hql = "";
		List<Object> params = new ArrayList<Object>();

		hql = "from User where password=? and user_name=?";
		params.add(user.getPassword());
		params.add(user.getUserName());

		User u = (User) entityDAO.findUniqueByHql(hql, params);
		if (u == null) {
			throw new LoginFailException();
		}
		return u;

	}
	
	@Override
	public void addUser(User user, Demo demo) {
		if (entityDAO.isPropertyExist(User.class, "userName",
				user.getUserName())) {
			throw new RepeatException();
		}
		entityDAO.save(user);

	}

	@Override
	public void addUser(User u) {
		// TODO Auto-generated method stub
		
	}

	
}
