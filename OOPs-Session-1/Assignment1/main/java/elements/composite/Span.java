/*
 * This file contains class named Span derived from class CompositeElement
 */
package main.java.elements.composite;

import main.java.elements.CompositeElement;

/**
 * Span is a HTML tag
 * Span is type of Composite Element
 * @author Satyam Bhadoria
 * @version 1.0
 */
public class Span extends CompositeElement{
	
	/**
	 * Constructor to initialize all attributes
	 * @param id - Span id
	 * @param className - Span class
	 */
	public Span (String id, String className) {
		super(id, className);
	}
}

