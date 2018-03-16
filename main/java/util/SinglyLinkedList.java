package main.java.util;

import java.util.Arrays;

/**
 * This class implements the singly linked list with some methods to add, remove elements
 * @author satyam bhadoria
 *
 * @param <T> - generic parameters
 */
public class SinglyLinkedList<T> {
	private Node<T> start;
	
	/**
	 * constructor
	 */
	public SinglyLinkedList() {
		this.start = null;
	}
	
	/**
	 * method to add element at last
	 * @param item - element to add
	 */
	public void add(T item) {
        Node<T> nptr = new Node<>(item); 
        
        if(this.start == null) {
            this.start = nptr;
        } else {
        	Node<T> end = lastNode();
            end.setNextLink(nptr);
        }
    }
	
	/**
	 * method to add element at particular position
	 * @param position - position at which to add
	 * @param item - element to add
	 */
	public void add(int position, T item) {
		int i = 0;
		boolean isAdded = false;
		Node<T> currentNode = this.start;
		 
		if(position == 0) {
			Node<T> ptr = new Node<>(item);
			ptr.setNextLink( currentNode );
			this.start = ptr;
			isAdded = true;
			
		} else if(position > 0) {
			
			while(currentNode != null) {
				
				if(position == i + 1) {
					Node<T> ptr =new Node<>(item);
					ptr.setNextLink( currentNode.getNextLink() );
					currentNode.setNextLink(ptr);
					isAdded = true;
					break;
				}
				i++;
				currentNode = currentNode.getNextLink();
			}
		}
		
		if(!isAdded) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	/**
	 * method to remove element at particular position
	 * @param position - position from which to remove element
	 */
	public T remove(int position) {
		int i = 0;
		boolean isRemoved = false;
		T removedElement = null;
		Node<T> currentNode = this.start;
		
		if(!isEmpty()) {
			
			if(position == 0) {
				removedElement = this.start.getData();
				this.start = this.start.getNextLink();
				isRemoved = true;
				
			} else if(position > 0) {
				
				while(currentNode.getNextLink() != null) {
					
					if(position == i + 1) {
						removedElement = currentNode.getNextLink().getData();
						currentNode.setNextLink( currentNode.getNextLink().getNextLink() );
						isRemoved = true; 
						break;
					}
					i++;
					currentNode = currentNode.getNextLink();
				}
			}
		}
		
		if(!isRemoved) {
			throw new IndexOutOfBoundsException();
		}
		
		return removedElement;
	}
	
	/**
	 * method to remove element at fisrt occurence
	 * @param item - element to remove
	 * @return removed element
	 */
	public boolean remove(T item) {
		
		boolean removed = false;
		Node<T> currentNode = this.start;
		
		int index = -1;
		 
		 while (currentNode != null) {
			 index++;
			 
			 if (item == currentNode.getData()){
				 remove (index);
				 removed = true;
				 break;
			 }
			 currentNode = currentNode.getNextLink();
		 }
		
		return removed;
	}
	
	/**
	 * method to get the element at particular position
	 * @param position - position from which element to return 
	 * @return - element at position given
	 */
	public T getElement(int position) {
		T element = null;
		int i = 0;
		Node<T> currentNode = this.start;
		
		if(position < 0 || position >= size()) {
			throw new IndexOutOfBoundsException();
			
		} else {
			
			while(currentNode != null) {
						
				if(position == i) {
					element = currentNode.getData();
					break;
				}
				i++;
				currentNode = currentNode.getNextLink();
			}
		}
		return element;
	}
	
	/**
	 * method to reverse the element of linked list
	 */
	public void reverse() {
		Node<T> currentNode = this.start;
		
		if( !isEmpty() ){
			
			while(currentNode.getNextLink() != null) {
				Node<T> temporaryNode = currentNode.getNextLink();
				currentNode.setNextLink( temporaryNode.getNextLink() );
				temporaryNode.setNextLink(this.start);
				this.start = temporaryNode;
			}
		}
	}
	
	/**
	 * method to sort the linked list
	 */
	public void sort() {
		T[] arr = toArray();
		Arrays.sort(arr);
		
		Node<T> currentNode = this.start;
		int i = 0;
		
		while(currentNode != null) {
			currentNode.setData( arr[i++] );
			currentNode = currentNode.getNextLink();
		}
	}
	
	/**
	 * method to check whether list is empty or not
	 * @return true or false
	 */
	private boolean isEmpty() {
		return this.start == null;
	}
	
	/**
	 * method to return the last node of list
	 * @return - last noed of list
	 */
	private Node<T> lastNode() {
		Node<T> currentNode = this.start;
		
		while(currentNode.getNextLink() != null) {
			currentNode = currentNode.getNextLink();
		}
		
		return currentNode;
	}
	
	/**
	 * method to return the size of list
	 * @return - size of list
	 */
	public int size() {
		int size = 0;
		Node<T> currentNode = this.start;
		
		while(currentNode != null) {
			size++;
			currentNode = currentNode.getNextLink();
		}
		return size;
	}
	
	/**
	 * method to convert list into array
	 * @param array - empty array of list size
	 * @return - array of list
	 */
	@SuppressWarnings("unchecked")
	public T[] toArray() {
		T[] array = (T[]) new Object[ this.size() ];
		Node<T> currentNode = this.start;
		int i = 0;
		
		while(currentNode != null) {
			array[i++] = currentNode.getData();
			currentNode = currentNode.getNextLink();
		}
		return array;
	}
}

