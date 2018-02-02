package main.java.elements.atomic;
/*
 * This file contains class A, which is derived from class AtomicElement
 */
import main.java.elements.AtomicElement;

/**
 * Anchor is a HTML tag, in this we denote Anchor as "A"
 * Anchor is type of Atomic Element
 * @author Satyam Bhadoria
 */
public class A extends AtomicElement {
	private String href;
	
	/**
	 * Constructor to set its attribute
	 * @param id - id of A
	 * @param href - hyper link it will contain
	 * @param className - ClassName of A
	 */
	public A (String id, String href, String className) {
		super(id , className);
		this.href = href;
	}
}
