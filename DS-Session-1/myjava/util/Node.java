package myjava.util;

public class Node<T>{
	private Node<T> nextLink = null;
	private Node<T> previousLink = null;
	private T data;	
	
	
	public Node(T data) {
		this.data = data;
	}
	
	public Node<T> getNextLink() {
		return this.nextLink;
	}

	public void setNextLink(Node<T> link) {
		this.nextLink = link;
	}
	
	public Node<T> getPreviousLink() {
		return this.previousLink;
	}

	public void setPreviousLink(Node<T> link) {
		this.previousLink = link;
	}
	
	public T getData() {
		return this.data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
}
