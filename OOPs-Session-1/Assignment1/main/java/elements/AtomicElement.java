/*
 * This file contains class AtomicElement which is derived from Element
 */
package main.java.elements;
import main.java.Element;

/**
 * This class is responsible for initializing atomic element 
 * i.e. the elements which doesn't have any more tags inside it. 
 * @author Satyam Bhadoria
 * @version 1.0
 */
public class AtomicElement extends Element{
	
	/**
	 * Constructor to set id and class name
	 * @param id- id of an Atomic element
	 * @param className - class name of an Atomic element
	 */
	public AtomicElement(String id, String className) {
		super(id, className);
	}
}