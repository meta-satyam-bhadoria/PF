package main.java.util;

import java.util.Arrays;

/**
 * This class implements the doubly linked list with some methods to add, remove elements
 * @author satyam bhadoria
 *
 * @param <T> - generic parameters
 */
public class DoublyLinkedList<T> {
	private Node<T> start;
	private Node<T> end;
	
	/**
	 * constructor
	 */
	public DoublyLinkedList () {
		this.start = null;
		this.end = null;
	}
	
	/**
	 * method to add element at last
	 * @param item - element to add
	 */
	public void add (T item){
        Node<T> newNode = new Node<>(item);
        
        if(this.start == null) {
            this.start = newNode;
            this.end = this.start;
            
        } else {
        	newNode.setPreviousLink(this.end);
            this.end.setNextLink(newNode);
            this.end = newNode;
        }
    }
	
	/**
	 * method to add element at particular position
	 * @param position - position at which to add
	 * @param item - element to add
	 */
	public void add (int position, T item) {
		int i = 0;
		boolean isAdded = false;
		Node<T> currentNode = this.start;
		 
		if(position == 0) {
			Node<T> newNode = new Node<>(item);
			newNode.setNextLink(currentNode);
			
			if(currentNode != null) {
				currentNode.setPreviousLink(newNode);
			}
			this.start = newNode;
			isAdded = true;
			
		} else if(position > 0) {
			
			while(currentNode != null) {
				
				if(position == i + 1) {
					Node<T> newNode =new Node<>(item);
					newNode.setNextLink(currentNode.getNextLink());
					newNode.setPreviousLink(currentNode);
					
					if(currentNode.getNextLink() != null) {
						currentNode.getNextLink().setPreviousLink(newNode);
						
					} else{
						this.end = newNode;
					}
					currentNode.setNextLink(newNode);
					isAdded = true;
					break;
				}
				i++;
				currentNode = currentNode.getNextLink();
			}
		}
		
		if(!isAdded){
			throw new IndexOutOfBoundsException();
		}
	}
	
	/**
	 * method to remove element at first occurrence
	 * @param item - element to remove
	 * @return removed element
	 */
	public boolean remove (T item) {
		 Node<T> currentNode = this.start;
		 boolean isRemoved = false;
		 int index = -1;
		 
		 while (currentNode != null) {
			 index++;
			 
			 if (item == currentNode.getData()){
				 remove (index);
				 isRemoved = true;
				 break;
			 }
			 currentNode = currentNode.getNextLink();
		 }
		 return isRemoved;
	}
	
	/**
	 * method to remove element at particular position
	 * @param position - position from which to remove element
	 */
	public T remove (int position) {
		int i = 0;
		boolean isRemoved = false;
		T removedElement = null;
		Node<T> currentNode = this.start;
		
		if(!isEmpty()) {
			
			if(position == 0) {
				removedElement = this.start.getData();
				this.start = this.start.getNextLink();
				this.start.setPreviousLink(null);
				isRemoved = true;
				
			} else if(position > 0) {
				
				while(currentNode.getNextLink() != null) {
					
					if(position == i + 1) {
						Node<T> removedNode = currentNode.getNextLink();
						removedElement = removedNode.getData();
						currentNode.setNextLink( removedNode.getNextLink() );
						removedNode.getNextLink().setPreviousLink(currentNode);
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
		Node<T> currentNodeFromStart = this.start;
		Node<T> currentNodeFromEnd = this.end;
		
		if( !isEmpty() ){
			
			while(currentNodeFromStart.getNextLink() != currentNodeFromEnd && currentNodeFromEnd != currentNodeFromStart) {
				T temporaryElement = currentNodeFromStart.getData();
				currentNodeFromStart.setData(currentNodeFromEnd.getData());
				currentNodeFromEnd.setData(temporaryElement);
				
				currentNodeFromStart = currentNodeFromStart.getNextLink();
				currentNodeFromEnd = currentNodeFromEnd.getPreviousLink();
			}
		}
	}
	
	/**
	 * method to sort the linked list
	 */
	public void sort (){
		T[] arr = toArray();
		Arrays.sort(arr);
		
		Node<T> ptr = this.start;
		int i = 0;
		while (ptr != null) {
			ptr.setData(arr[i++]);
			ptr = ptr.getNextLink();
		}
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
	
	/**
	 * method to check whether list is empty or not
	 * @return true or false
	 */
	private boolean isEmpty() {
		return this.start == null;
	}
	
	/**
	 * method to return the size of list
	 * @return - size of list
	 */
	private int size(){
		int size = 0;
		Node<T> currentNode = this.start;
		
		while(currentNode != null) {
			size++;
			currentNode = currentNode.getNextLink();
		}
		return size;
	}
}

