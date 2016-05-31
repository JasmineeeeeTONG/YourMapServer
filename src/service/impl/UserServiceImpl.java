package service.impl;

import java.util.ArrayList;
import java.util.List;

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
		params.add(user.getUsername());

		User u = (User) entityDAO.findUniqueByHql(hql, params);
		if (u == null) {
			throw new LoginFailException();
		}
		return u;

	}
	
	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		String hql = "";
		List<Object> params = new ArrayList<Object>();

		hql = "from User where user_name=?";
		params.add(user.getUsername());

		User u = (User) entityDAO.findUniqueByHql(hql, params);
		if (u != null) {
			throw new RepeatException();
		}
		
		u = new User();
		u.setUsername(user.getUsername());
		u.setPassword(user.getPassword());
		u.setLoginType("yourmap");
		entityDAO.save(u);
		return u;
	}

	
}
