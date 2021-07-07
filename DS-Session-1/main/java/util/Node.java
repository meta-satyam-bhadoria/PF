package main.java.util;

/**
 * This class is used as a null node
 * @author satyam bhadoria
 *
 * @param <T> - generic parameter
 */
public class Node<T> {
	private Node<T> nextLink = null;
	private Node<T> previousLink = null;
	private T data;	
	
	/**
	 * constructor
	 * @param data - data to insert in a node
	 */
	public Node(T data) {
		this.data = data;
	}
	
	/**
	 * getter for getting next link of the node
	 * @return next link
	 */
	public Node<T> getNextLink() {
		return this.nextLink;
	}

	/**
	 * setter for setting the next link of the node
	 * @param link - new node
	 */
	public void setNextLink(Node<T> link) {
		this.nextLink = link;
	}
	
	/**
	 * getter for getting the previous link of the node
	 * @return - previous link
	 */
	public Node<T> getPreviousLink() {
		return this.previousLink;
	}

	/**
	 * setter for setting previous link of the node
	 * @param link - new node
	 */
	public void setPreviousLink(Node<T> link) {
		this.previousLink = link;
	}
	
	/**
	 * getter for getting the data of the node
	 * @return data of node
	 */
	public T getData() {
		return this.data;
	}
	
	/**
	 * setter for setting the data in node
	 * @param data - new data to set
	 */
	public void setData(T data) {
		this.data = data;
	}
}
