/*
 * This file contains class named Div derived from class CompositeElement
 */
package main.java.elements.composite;

import main.java.elements.CompositeElement;

/**
 * Div is a HTML tag
 * Div is type of Composite Element
 * @author Satyam Bhadoria
 * @version 1.0
 */
public class Div extends CompositeElement {
	
	/**
	 * Constructor to initialize all attributes
	 * @param id - div id
	 * @param className - div class
	 */
	public Div (String id, String className) {
		super(id, className);
	}
}

