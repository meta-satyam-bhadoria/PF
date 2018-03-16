package myjava.util;

import java.util.Arrays;

public class Doubly<T> {
	private Node<T> start;
	private Node<T> end;
	
	public Doubly () {
		this.start = null;
		this.end = null;
	}
	
	public void add (T item){
        Node<T> nptr = new Node<>(item);
        if(this.start == null) {
            this.start = nptr;
            this.end = this.start;
        }
        else {
        	nptr.setPreviousLink(end);
            this.end.setNextLink(nptr);
            this.end = nptr;
        }
    }
	
	public void add (int position, T item) {
		int i = 0;
		boolean added = false;
		Node<T> nptr = this.start;
		 
		if(position == 0){
			Node<T> ptr = new Node<>(item);
			ptr.setNextLink(nptr);
			
			if(nptr != null) {
				nptr.setPreviousLink(ptr);
			}
			this.start = ptr;
			added = true;
			
		} else if(position > 0){
			while(nptr != null){
				if(position == i + 1) {
					Node<T> ptr =new Node<>(item);
					ptr.setNextLink(nptr.getNextLink());
					ptr.setPreviousLink(nptr);
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
	
	public void remove (T item) {
		 Node<T> ptr = this.start;
		 int i = 0;
		 while (ptr != null) {
			 i++;
			 if (item == ptr.getData()){
				 remove (i);
				 break;
			 }
			 ptr = ptr.getNextLink();
		 }
		 System.out.println("Item Not Found");
	}
	
	public void remove (int position) {
		int i = 1;
		boolean removed = false;
		Node<T> nptr = this.start;
		
		if(nptr != null){
			if(position == 0){
				this.start = this.start.getNextLink();
				this.start.setPreviousLink(null);
				removed = true;
			} else if(position > 0){
				nptr = nptr.getNextLink();
				while(nptr != null) {
					if(position == i) {
						Node<T> ptr = nptr.getPreviousLink();
						ptr.setNextLink(nptr.getNextLink());
						nptr.getNextLink().setPreviousLink(ptr);
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
	
	public int indexOf (T item) {
		int index = -1;
		Node<T> nptr = this.start;
		while (nptr != null) {
			index++;
			if(nptr.getData() == item) {
				break;
			}
			nptr = nptr.getNextLink();
		}
		return index;
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
	
	public T[] toArray (T[] arr) {
		Node<T> ptr = this.start;
		int i = 0;
		while (ptr != null) {
			arr[i++] = ptr.getData();
			ptr = ptr.getNextLink();
		}
		return arr;
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
	
	public void display () {
		Node<T> ptr = this.start;
		while (ptr != null) {
			System.out.println(ptr.getData());
			ptr = ptr.getNextLink();
		}
	}
	
}

