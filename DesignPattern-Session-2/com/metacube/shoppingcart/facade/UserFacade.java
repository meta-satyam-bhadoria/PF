package com.metacube.shoppingcart.facade;

import java.util.ArrayList;
import java.util.List;

import com.metacube.shoppingcart.dao.BaseDao;
import com.metacube.shoppingcart.dao.InMemoryUserDao;
import com.metacube.shoppingcart.dao.UserDao;
import com.metacube.shoppingcart.dao.UserDaoFactory;
import com.metacube.shoppingcart.entity.ShoppingCart;
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
		if(!searchUser(item.getId())){
			baseDao.addItem(item);
		}
	}
	
	public void removeItem(String slNo) {
		if(searchUser(slNo)){
			baseDao.removeItem(getUser(slNo));
		}
	}
	
	private boolean searchUser(String slNo){
		return baseDao.getList().containsKey(slNo);
	}
	
	public List<User> getList(){
		return new ArrayList<>(baseDao.getList().values());
	}

	public void updateItem(String userId, String name, String email, String password) {
		if(searchUser(userId)){
			((UserDao) baseDao).updateItem(getUser(userId), name, email, password);
		}
	}
	
	public boolean checkUser(String userName){
		List<User> list = getList();
		for(User u : list){
			if(u.getId().equalsIgnoreCase(userName)){
				return true;
			}
		}
		return false;
	}

	public ShoppingCart createUserCart(User user) {
		return new ShoppingCart(user.getEmail());
	}
	
	public User getUser(String userId){
		return ((InMemoryUserDao) baseDao).getUser(userId);
	}
}
