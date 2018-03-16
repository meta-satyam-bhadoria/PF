package main.java.util;

import java.util.Arrays;

/**
 * This class implements the stack
 * @author satyam bhadoria
 *
 * @param <T> - generic parameter
 */
public class Stack<T> {
	private Node<T> top;
	
	/**
	 * constructor
	 */
	public Stack() {
		this.top = null;
	}
	
	/**
	 * method to push element on the top of stack
	 * @param item - element to push
	 */
	public void push(T item) {
		Node<T> newNode = new Node<>(item);
		newNode.setNextLink(this.top);
		this.top = newNode;
	}
	
	/**
	 * method to pop the top most element from the stack
	 * @return top element
	 */
	public T pop() {
		T removedElement ;
		
		if(this.top != null) {
			removedElement = this.top.getData();
			this.top = this.top.getNextLink();
			
		} else{
			throw new IndexOutOfBoundsException("no element to remove");
		}
		return removedElement;
	}
	
	/**
	 * method which return the top element of stack
	 * @return top element
	 */
	public T peek() {
		
		if(this.top == null) {
			throw new IndexOutOfBoundsException("stack is empty");
			
		} else{ 
			return this.top.getData();
		}
	}
	
	/**
	 * method which returns the size of stack
	 * @return
	 */
	private int size() {
		int size = 0;
		Node<T> currentNode = this.top;
		
		while(currentNode != null) {
			size++;
			currentNode = currentNode.getNextLink();
		}
		return size;
	}
	
	/**
	 * method which returns stack element as an array
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T[] toArray() {
		T[] array = (T[]) new Object[ this.size() ];
		Node<T> currentNode = this.top;
		int i = 0;
		
		while(currentNode != null) {
			array[i++] = currentNode.getData();
			currentNode = currentNode.getNextLink();
		}
		return array;
	}
	
	/**
	 * method to check whether stack is empty or not
	 * @return true or false
	 */
	public boolean isEmpty() {
		return this.top == null;
	}
	
	public void display() {
		Node<T> ptr = this.top;
		while(ptr != null) {
			System.out.println(ptr.getData());
			ptr = ptr.getNextLink();
		}
		
	}
}
