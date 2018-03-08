package com.metacube.shoppingcart.dao;

import java.util.HashMap;
import java.util.Map;

import com.metacube.shoppingcart.entity.User;

public class InMemoryUserDao implements UserDao{
	Map<String, User> userMap = new HashMap<>();
	
	
	private static InMemoryUserDao data;
	private InMemoryUserDao() {}
	public static InMemoryUserDao getInstance() {
		
		if(data == null){
			data = new InMemoryUserDao();
		}
		return data;
	}
	
	
	public Map<String, User> getList() {
		return userMap;
	}
	
	public void addItem(User item){
		userMap.put(item.getId(), item);
	}
	
	public void removeItem(User user) {
		userMap.remove(user.getId());
	}
	
	public void updateItem(User item, String name, String email, String password) {
		item.setEmail(email);
		item.setName(name);
		item.setPassword(password);
	}
	
	public User getUser(String slNo) {
		return userMap.get(slNo);
	}
}
