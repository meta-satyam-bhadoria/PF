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

/**
 * This class gets the data from controller and perform some operation and pass to the dao layer.
 * @author Satyam Bhadoria
 *
 */
public class UserFacade {
	private static UserFacade userFacade;
	private BaseDao<User> userDao = (InMemoryUserDao) UserDaoFactory.getInstance(DatabaseEnum.in_memory);
	
	/**
	 * private constructor to restrict creating new objects.
	 */
	private UserFacade() {}
	
	/**
	 * Method which returns already created object of this class
	 * @return - object of this class
	 */
	public static UserFacade getInstance() {
		
		if(userFacade == null){
			userFacade = new UserFacade();
		}
		return userFacade;
	}
	
	/**
	 * Method which send command to dao to add user after performing some operation
	 * @param user - user object
	 */
	public void addItem(User user) {
		
		if(!searchUser(user.getId())){
			userDao.addItem(user);
		}
	}
	
	/**
	 * Method which send command to dao to remove user after performing some operation
	 * @param userId - id of user
	 */
	public void removeItem(String userId) {
		
		if(searchUser(userId)){
			userDao.removeItem(getUser(userId));
		}
	}
	
	/**
	 * Method which search for user that it is available or not
	 * @param userId - id of user
	 * @return - true or false
	 */
	private boolean searchUser(String userId){
		return userDao.getList().containsKey(userId);
	}
	
	/**
	 * Method which send command to dao layer to return list of user
	 * @return - list of user
	 */
	public List<User> getList(){
		return new ArrayList<>(userDao.getList().values());
	}

	/**
	 * Method which update details of user with the help of dao
	 * @param userId - id of user
	 * @param name - name of user
	 * @param email - email of user
	 * @param password - password of user
	 */
	public void updateItem(String userId, String name, String email, String password) {
		
		if(searchUser(userId)){
			((UserDao) userDao).updateItem(getUser(userId), name, email, password);
		}
	}
	
	/**
	 * Method which check that user is available or not
	 * @param userId - id of user
	 * @return - true or false
	 */
	public boolean checkUser(String userId){
		List<User> list = getList();
		
		for (User u : list){

			if(u.getId().equalsIgnoreCase(userId)){
				return true;
			}
		}
		return false;
	}

	/**
	 * Method that create cart for new user
	 * @param user - user object
	 * @return - Shopping cart object
	 */
	public ShoppingCart createUserCart(User user) {
		return new ShoppingCart(user.getEmail());
	}
	
	/**
	 * Method which return user object came from dao
	 * @param userId - id of user
	 * @return - user object
	 */
	public User getUser(String userId){
		return ((InMemoryUserDao) userDao).getUser(userId);
	}
}
