package myjava.util;

import java.util.Arrays;

public class LinkedList<T> {
	private Node<T> start;
	
	public LinkedList () {
		this.start = null;
	}
	
	public void add (T item){
        Node<T> nptr = new Node<>(item);  
        if(this.start == null) {
            this.start = nptr;
        }
        else {
        	Node<T> end = lastNode();
            end.setNextLink(nptr);
            end = nptr;
        }
    }
	
	public void add (int position, T item) {
		int i = 0;
		boolean added = false;
		Node<T> nptr = this.start;
		 
		if(position == 0){
			Node<T> ptr = new Node<>(item);
			ptr.setNextLink(nptr);
			this.start = ptr;
			added = true;
		} else if(position > 0){
			while(nptr != null){
				if(position == i + 1) {
					Node<T> ptr =new Node<>(item);
					ptr.setNextLink(nptr.getNextLink());
					nptr.setNextLink(ptr);
					added = true;
					break;
				}
				i++;
				nptr = nptr.getNextLink();
			}
		}
		
		if(!added){
			throw new IndexOutOfBoundsException();
		}
	}
	
	public void remove (int position) {
		int i = 0;
		boolean removed = false;
		Node<T> nptr = this.start;
		
		if(!isEmpty()){
			if(position == 0){
				this.start = this.start.getNextLink();
				removed = true;
			} else if(position > 0){
				while(nptr.getNextLink() != null) {
					if(position == i + 1) {
						nptr.setNextLink(nptr.getNextLink().getNextLink());
						removed = true;
						break;
					}
					i++;
					nptr = nptr.getNextLink();
				}
			}
		}
		
		if(!removed) {
			throw new IndexOutOfBoundsException();
		}
		
		
	}
	
	
	public boolean remove (T item) {
		
		boolean removed = false;
		Node<T> nptr = this.start;
		if(!isEmpty()){
			if(nptr.getData() == item){
				this.start = this.start.getNextLink();
				removed = true;
			} else {
				while(nptr.getNextLink() != null) {
					if(nptr.getNextLink().getData() == item) {
						nptr.setNextLink(nptr.getNextLink().getNextLink());
						removed = true;
						break;
					}
					nptr = nptr.getNextLink();
				}
			}
		} 
		
		return removed;
	}
	
	public int indexOf (T item) {
		Node<T> nptr = this.start;
		int i = -1;
		while(nptr != null) {
			if (nptr.getData() == item) {
				i++;
				break;
			}
			nptr = nptr.getNextLink();
		}
		return i;
	}
	
	public void reverse () {
		Node<T> ptr = this.start;
		if(ptr != null){
			while (ptr.getNextLink() != null) {
				Node<T> temp = ptr.getNextLink();
				ptr.setNextLink(temp.getNextLink());
				temp.setNextLink(this.start);
				this.start = temp;
			}
		}
	}
	
	public void sort (){
		@SuppressWarnings("unchecked")
		T[] arr = toArray((T[]) new Object[this.size()]);
		Arrays.sort(arr);
		
		Node<T> ptr = this.start;
		int i = 0;
		while (ptr != null) {
			ptr.setData(arr[i++]);
			ptr = ptr.getNextLink();
		}
	}
	
	private boolean isEmpty(){
		if( this.start == null) {
			return true;
		}
		return false;
	}
	
	private Node<T> lastNode() {
		Node<T> ptr = this.start;
		
		while(ptr.getNextLink() != null){
			ptr = ptr.getNextLink();
		}
		
		return ptr;
	}
	
	private int size(){
		int size = 0;
		Node<T> nptr = this.start;
		
		while(nptr != null) {
			size++;
			nptr = nptr.getNextLink();
		}
		return size;
	}
	
	public T[] toArray (T[] arr) {
		Node<T> ptr = this.start;
		int i = 0;
		while (ptr != null) {
			arr[i++] = ptr.getData();
			ptr = ptr.getNextLink();
		}
		return arr;
	}
	
	public void display () {
		Node<T> ptr = this.start;
		while (ptr != null) {
			System.out.println(ptr.getData());
			ptr = ptr.getNextLink();
		}
	}
	
}

