package myjava.util;

import java.util.Arrays;

public class LinkedList<T> {
	private Node<T> start;
	private Node<T> end;
	private int size;
	
	public LinkedList () {
		this.start = null;
		this.end = null;
		this.size = 0;
	}
	
	public void addAtStart (T item) {
		Node<T> nptr = new Node<>(null, item);    
        this.size++ ;
        if(this.start == null) 
        {
            this.start = nptr;
            this.end = this.start;
        }
        else 
        {
            nptr.setLink(this.start);
            this.start = nptr;
        }
	}
	
	public void addAtEnd (T item){
        Node<T> nptr = new Node<>(null, item);    
        this.size++ ;    
        if(this.start == null) 
        {
            this.start = nptr;
            this.end = this.start;
        }
        else 
        {
            this.end.setLink(nptr);
            this.end = nptr;
        }
    }
	
	public void add (int position, T item) {
		if(position == 1){
			this.addAtStart(item);
			return;
		} else if(position == this.size + 1){
			this.addAtEnd(item);
			return;
		}
        Node<T> nptr = new Node<>(null, item);                
        Node<T> ptr = this.start;
        position = position - 1 ;
        for (int i = 0; i <= this.size; i++) 
        {
            if (i == position) 
            {
                Node<T> tmp = ptr.getLink() ;
                ptr.setLink(nptr);
                nptr.setLink(tmp);
                break;
            }
            ptr = ptr.getLink();
        }
        this.size++ ;
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
			 ptr = ptr.getLink();
		 }
	}
	
	public void remove (int position) {
		if (position == 1) {
            removeAtStart (); 
            
        } else if (position == this.size) {
            removeAtEnd ();
            
        } else {
	        Node<T> ptr = this.start;
	        position = position - 1;
	        for (int i = 1; i < this.size - 1; i++) {
	            if (i == position) {
	                Node<T> tmp = ptr.getLink();
	                tmp = tmp.getLink();
	                ptr.setLink(tmp);
	                break;
	            }
	            ptr = ptr.getLink();
	        }
		}
        this.size-- ;
	}
	
	private void removeAtStart () {
		this.start = this.start.getLink();
        this.size--;
	}
	
	private void removeAtEnd () {
		Node<T> s = this.start;
        Node<T> t = this.start;
        while (s != this.end) {
            t = s;
            s = s.getLink();
        }
        this.end = t;
        this.end.setLink(null);
        this.size--;
	}
	
	public int indexOf (T item) {
		Node<T> ptr = this.start;
		for (int i = 0; i < this.size; i++) {
			if (ptr.getData() == item) {
				return i;
			}
			ptr = ptr.getLink();
		}
		return -1;
	}
	
	public T itemAt (int position) {
		Node<T> ptr = this.start;
		int i = 1;
		while ( i != position) {
			ptr = ptr.getLink();
		}
		return ptr.getData();
	}
	
	public void reverse () {
		Node<T> ptr = this.start;
		if(ptr != null){
			for (int i = 0 ;i < this.size && ptr.getLink() != null; i++) {
				Node<T> temp = ptr.getLink();
				ptr.setLink(temp.getLink());
				temp.setLink(this.start);
				this.start = temp;
			}
		}
	}
	
	public void sort (){
		@SuppressWarnings("unchecked")
		T[] arr = toArray((T[]) new Object[this.size]);
		Arrays.sort(arr);
		
		Node<T> ptr = this.start;
		int i = 0;
		while (ptr != null) {
			ptr.setData(arr[i++]);
			ptr = ptr.getLink();
		}
	}
	
	public T[] toArray (T[] arr) {
		Node<T> ptr = this.start;
		int i = 0;
		while (ptr != null) {
			arr[i++] = ptr.getData();
			ptr = ptr.getLink();
		}
		return arr;
	}
	
	public void display () {
		Node<T> ptr = this.start;
		while (ptr != null) {
			System.out.println(ptr.getData());
			ptr = ptr.getLink();
		}
	}
	
}

class Node<T>{
	private Node<T> link;
	private T data;	
	
	
	public Node(Node<T> link, T data) {
		this.link = link;
		this.data = data;
	}
	
	public Node<T> getLink() {
		return this.link;
	}

	public void setLink(Node<T> link) {
		this.link = link;
	}
	
	public T getData() {
		return this.data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
}