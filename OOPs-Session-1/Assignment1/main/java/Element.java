/*
 * This file contains abstract Class named Element
 */
package main.java;
/**
 * This Class acts as the super class for all the 
 * elements of DOM. This contains all the attributes
 * which are common to all elements in DOM.
 * @author Satyam Bhadoria
 * @version 1.0
 */
public class Element {
	private String id;
	private String className;
	
	/**
	 * Constructor to set id and class name
	 * @param id- id of an element
	 * @param className - class name of an element
	 */
	public Element(String id, String className) {
		this.id = id;
		this.className = className;
	}
	
	/**
	 * Method to get ID
	 * @return id of element
	 */
	public String getId() {
		return this.id;
	}
	
	/**
	 * method to get classname
	 * @return class name of element
	 */
	public String getClassName() {
		return this.className;
	}
}

