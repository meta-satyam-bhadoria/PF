package com.metacube.shoppingcart.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
	
	
	public List<User> getList() {
		return new ArrayList<>(userMap.values());
	}
	
	public void addItem(User item){
		userMap.put(item.getId(), item);
	}
	
	public void removeItem(User item) {
		userMap.remove(item.getId());
	}
	
	public void updateItem(User item, String name, String email, String password) {
		item.setEmail(email);
		item.setName(name);
		item.setPassword(password);
	}
}
