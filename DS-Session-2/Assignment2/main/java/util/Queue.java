package main.java.util;

import java.util.Arrays;

/**
 * This class is used to implement the queue
 * @author Satyam Bhadoria
 * 
 * @param <T> - generic type
 */
public class Queue<T>{
   private T[] array;

   /**
    * constructor
    */
    public Queue() {
        this.array = createArray(0);
    }
    
    /**
     * method is used for insert the item from rear end of the queue
     * @param item - element to insert
     */
    public void enQueue(T item) {
        this.array = Arrays.copyOf(array, this.array.length + 1);
        this.array[this.array.length - 1] = item;
    }
    
    /**
     * method to removed the element from the front end of the queue
     * @return removed element
     */
    public T deQueue() {
        T removedElement = this.array[0];
        this.array = Arrays.copyOfRange(this.array, 1, this.array.length);
        return removedElement;
    }
    
    /**
     * method to empty the queue
     */
    public void makeEmpty() {
    	this.array = createArray(0);
    }
    
    /**
     * method to get the front element of the queue
     * @return font element of the queue
     */
    public T getFront() {
    	return this.array[0];
    }
    
    /**
     * method to return the size of queue
     * @return size of queue
     */
    public int size() {
        return this.array.length;
    }
    
    /**
     * method to return the queue as an array
     * @param arr - empty array(type equal to element type) of size equal to queue size
     * @return queue as an array
     */
    public T[] toArray(T[] arr) {
        
        for(int i = 0; i < this.array.length; i++) {
            arr[i] = this.array[i];
        }
        return arr;
    }
    
    /**
     * method which return queue as an array
     * @return queue as an array
     */
    public T[] toArray() {
        return this.array;
    }
    
    /**
     * method to create array of given size
     * @param arrSize - size of array
     * @return created array
     */
    private T[] createArray(int arrSize) {
    	return (T[]) new Object[arrSize];
    }
    
    /**
     * method to convert the queue into string
     * @return queue as string
     */
    @Override
    public String toString() {
        String s = "[";
        
        if(size() != 0) {
            s += this.array[0];
            
            for(int i = 1; i < this.array.length; i++) {
                s += ", " + this.array[i];
            }
        }
        return s+ "]";
    }
}