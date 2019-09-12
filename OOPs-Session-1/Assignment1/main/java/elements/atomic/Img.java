package main.java.elements.atomic;
/*
 * This file contains class Img, which is derived from class AtomicElement
 */
import main.java.elements.AtomicElement;

/**
 * Image is a HTML tag, in this we denote Image as "img"
 * Image is type of Atomic Element
 * @author Satyam Bhadoria
 * @version 1.0
 */
public class Img extends AtomicElement {
	private String src;
	
	/**
	 * Constructor to initialize all Attributes of the img tag
	 * @param id - its Id
	 * @param src - source of Image
	 * @param className - className of Image
	 */
	public Img (String id, String src, String className) {
		super(id , className);
		this.src = src;
	}
}

