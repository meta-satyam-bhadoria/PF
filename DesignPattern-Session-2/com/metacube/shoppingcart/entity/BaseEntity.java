package com.metacube.shoppingcart.entity;

public class BaseEntity {
	private String id ;
	private String name;
	
	public BaseEntity(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}	
}
