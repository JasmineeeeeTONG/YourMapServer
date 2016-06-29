package service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import bean.User;
import dao.EntityDAO;
import exception.LoginFailException;
import exception.UserRepeatException;
import service.IUserService;

@SuppressWarnings({ "unchecked", "rawtypes" })
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

		hql = "from User where password=? and account=? and type=?";
		params.add(user.getPassword());
		params.add(user.getAccount());
		params.add(user.getType());
		
		User u = (User) entityDAO.findUniqueByHql(hql, params);
		if (u == null) {
			throw new LoginFailException();
		}
		return u;

	}
	
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		if (entityDAO.isPropertyExist(User.class, "username",
				user.getUsername())) {
			throw new UserRepeatException();
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("type", user.getType());
		map.put("account", user.getAccount());
	
		if (entityDAO.isAllPropertiesExist(User.class, map)) {
			throw new UserRepeatException();
		}
		
		entityDAO.save(user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		entityDAO.update(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		List<Criterion> criterions = new ArrayList<Criterion>();
		List<User> users = entityDAO.findAll(User.class, "userId", true, criterions);
		return users;
	}

	@Override
	public void addThirdUser(User user) {
		// TODO Auto-generated method stub
		entityDAO.save(user);
	}

	@Override
	public boolean ifExsitUser(User user) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("type", user.getType());
		map.put("account", user.getAccount());
	
		if (entityDAO.isAllPropertiesExist(User.class, map)) {
			return true;
		}
		return false;
	}

	
}
