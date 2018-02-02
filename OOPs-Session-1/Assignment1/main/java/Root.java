/*
 * This file contains class named Root derived from class CompositeElement
 */
package main.java;

import main.java.elements.CompositeElement;

/**
 * 
 * This class create the object which will be root element.
 * @author satyam bhadoria
 *
 */
public class Root extends CompositeElement {
	
	/**
	 * Constructor
	 * @param id - root id
	 * @param className - root class name
	 */
	public Root(String id, String className){
		super(id, className);
	}
}