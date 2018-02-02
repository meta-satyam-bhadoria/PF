/*
 * This file contains Class Dom
 */
package main.java;

import main.java.elements.CompositeElement;
import java.util.ArrayList;
import java.util.List;
/**
 * The class DOM represents the Document object model 
 * just as it is in real world. It is here where the elements 
 * gets added and it also maintains the hierarchy of the element 
 * in which they are added.
 * @author Satyam Bhadoria
 * @version 1.0
 */
public class Dom {
	private CompositeElement element;			//creating element of composite type
	
	/**
	 * Constructor
	 * @param root - root element
	 */
	public Dom(Element root){
		element = (CompositeElement) root;
	}

	/**
	 * Function to find elements by their ID
	 * It uses a recursive approach to do the task
	 * @param id - id of the search element
	 * @return - returns the element if found
	 */
	public Element findElementByID (String id) {
		return getElementById(this.element, id);
	}
	
	/**
	 * Recursive function to search element by ID
	 * @param tagElement - object of composite element to be searched
	 * @param id -  ID of search element
	 * @return element if found
	 */
	private Element getElementById (Element tagElement, String id) {
		
		/*loop to check id of element in list of composite element*/
		for(Element element: ( (CompositeElement) tagElement).getCompositeElementsList() ) {
			
			/*return element if "id" match*/
			if ( id == ((Element) element).getId()) {
					return element;
			}
			
			/*check if element is a composite element or not*/
			if (element instanceof CompositeElement) {
				Element tag = getElementById(element, id);
				
				if (tag != null){
					return tag;
				}
			}
		}
		return  null;
	}
	
	/**
	 * Function to find elements by their Class Name
	 * It uses a recursive approach to do the task
	 * @param className - class name to be searced for
	 * @return - returns the the list of elements if found
	 */
	public List<Element> findElementsByClass(String className) {
		return getElementsByClass(this.element, className);
	}
	
	/**
	 * Recursive function to search element by Class name
	 * @param tagElement - object of composite element to be searched
	 * @param className -  class name to be searched for
	 * @return - returns the list of elements if found
	 */
	private List<Element> getElementsByClass(Element tagElement, String className) {
		List<Element> tagElementList = new ArrayList<Element>();
		
		/*loop to check class of element in list of composite element*/
		for (Element element: ((CompositeElement) tagElement).getCompositeElementsList() ) {	
			
			/*add element if "class" match*/
			if ( className == ( (Element) element).getClassName() ) {
				tagElementList.add (element);
			}
			
			/*add all tags inside element is a composite element or not*/
			if (element instanceof CompositeElement) {	
				tagElementList.addAll ( getElementsByClass(element, className) );
			}
		}
		return  tagElementList;
	}
	
	/**
	 * To get the list of elements of the DOM in hierarchical form
	 * @return the list of the hierarchy of elements
	 */
	public List<String> displayDOM(){
		return displayDomRecursive(this.element, 0);
	}
	
	/**
	 * Recursive function to find the hierarchy of elements
	 * @param tagElement - the composite element
	 * @param count - counts the hierarchy, upto what level the element is
	 * @return - the hierarchy in form of list
	 */
	private List<String> displayDomRecursive (Element tagElement, int count) {
		List<String> hierarchy = new ArrayList<String>();
		
		/*loop for adding string of composite elements into hierarchy*/
		for (Element tag : ((CompositeElement) tagElement).getCompositeElementsList()) {
			
			/*checks instance of composite element*/
			if (tag instanceof CompositeElement) {
				hierarchy.add ( displaySpaces(count) +"<" + tag.getClass().getSimpleName() + " id='" + tag.getId() + "'>");
				
				hierarchy.addAll ( displayDomRecursive (tag, count + 1) );
				
				hierarchy.add ( displaySpaces(count) +"</" + tag.getClass().getSimpleName() + ">");
			} else {
				hierarchy.add ( displaySpaces(count) +"<" + tag.getClass().getSimpleName() + " id='" + tag.getId() + "'>");
			}
		}
		return hierarchy;
	}
	
	/**
	 * Counts the spaces to be printed to maintain hierarchy
	 * @param count - counts spaces
	 * @return space - string of spaces
	 */
	protected String displaySpaces (int count) {
		String space="";
		
		/*loop for adding space*/
		while (count != 0) {
			space += "    ";
			count--;
		}
		return space;
	}
}