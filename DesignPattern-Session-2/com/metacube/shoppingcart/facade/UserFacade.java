package com.metacube.shoppingcart.facade;

import java.util.List;

import com.metacube.shoppingcart.dao.BaseDao;
import com.metacube.shoppingcart.dao.InMemoryUserDao;
import com.metacube.shoppingcart.dao.UserDao;
import com.metacube.shoppingcart.dao.UserDaoFactory;
import com.metacube.shoppingcart.entity.User;
import com.metacube.shoppingcart.enumm.DatabaseEnum;

public class UserFacade {
	private static UserFacade data;
	
	public static UserFacade getInstance() {
		
		if(data == null){
			data = new UserFacade();
		}
		return data;
	}
	
	private UserFacade() {}
	
	BaseDao<User> baseDao = (InMemoryUserDao) UserDaoFactory.getInstance(DatabaseEnum.in_memory);
	
	public void addItem(User item) {
		if(!searchUser(item)){
			baseDao.addItem(item);
		}
	}
	
	public void removeItem(User item) {
		if(searchUser(item)){
			baseDao.removeItem(item);
		}
	}
	
	private boolean searchUser(User item){
		List<User> list = baseDao.getList();
		return list.contains(item);
	}
	
	public List<User> getList(){
		return baseDao.getList();
	}

	public void updateItem(User item, String name, String email, String password) {
		if(searchUser(item)){
			((UserDao) baseDao).updateItem(item, name, email, password);
		}
	}
	
	public boolean checkUser(String userName){
		List<User> list = baseDao.getList();
		for(User u : list){
			if(u.getId().equalsIgnoreCase(userName)){
				return true;
			}
		}
		return false;
	}
}
