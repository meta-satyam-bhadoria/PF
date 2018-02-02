/*
 * This file contains class CompositeElement which is derived from Element
 */
package main.java.elements;
import java.util.List;
import java.util.ArrayList;
import main.java.Element;

/**
 * This class is responsible for initializing Composite element 
 * i.e. the elements which have more tags inside it. 
 * @author Satyam Bhadoria
 * @version 1.0
 *
 */
public class CompositeElement extends Element{	
	private List<Element> element = new ArrayList<Element>(); 		//It stores all the elements which are added inside it
    
	/**
	 * Constructor to set the attributes of every Element
	 * @param id - id of Element
	 * @param className- class name of element
	 */
	public CompositeElement (String id, String className) {
		super (id, className);
	}
	
	/**
	 * Function to add new element
	 * @param a - nem element
	 */
	public void add (Element a) {
		element.add(a);
	}
	
	/**
	 * Function that returns the list of all elements that are in the current object
	 * @return list of all elements
	 */
	public List<Element> getCompositeElementsList(){
		return this.element;
	}
}