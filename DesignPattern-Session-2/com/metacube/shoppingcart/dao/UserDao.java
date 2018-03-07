package com.metacube.shoppingcart.dao;

import com.metacube.shoppingcart.entity.User;

public interface UserDao extends BaseDao<User>{
	public void updateItem(User item, String name, String email, String password);
}
