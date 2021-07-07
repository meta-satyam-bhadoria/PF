package main.java.util;

import java.util.Arrays;

/**
 * This class implements the array list with some methods to add, remove elements
 * @author satyam bhadoria
 *
 * @param <T> - generic parameter
 */
public class ArrayList<T> {
	private T[] array = null;
	
	/**
	 * constructor for initialising array of size 0
	 */
	public ArrayList() {
		this.array = createArray(0);
	}
	
	/**
	 * method which add element at end of the list
	 * @param item - element to add
	 */
	public void add (T item) {
		this.array = Arrays.copyOf(this.array, this.array.length + 1);
		this.array[this.array.length - 1] = item;
	}
	
	/**
	 * method which add element at particular position
	 * @param position - position where to add
	 * @param item - element to add
	 */
	public void add (int position, T item){
		
		if(position <= this.array.length && position >= 0) {
			
			this.array = Arrays.copyOf(this.array, this.array.length + 1);
			
			for( int i = this.array.length - 1; i > position; i--) {
				this.array[i] = this.array[i - 1];
			}
			this.array[position] = item;
			
		} else { 
			throw new IndexOutOfBoundsException();
		}
		
	}
	
	/**
	 * method to remove element from position
	 * @param position - position from where to remove
	 * @return - removed element
	 */
	public T remove (int position) {
		T removedNumber;
		
		if (position < this.array.length && position >= 0) {
			removedNumber = this.array[position];
			this.array = append( Arrays.copyOfRange(this.array, 0, position) , Arrays.copyOfRange(this.array, position + 1, this.array.length));
		
		} else{
			throw new IndexOutOfBoundsException();
		}
		return removedNumber;
	}
	
	/**
	 * method to remove first occurence of element given
	 * @param item - element to remove
	 * @return true or false 
	 */
	public boolean remove (T item) {
		boolean isRemoved = false;
		
		for (int i = 0; i < this.array.length; i++) {
			
			if (this.array[i] == item) {
				this.array = append( Arrays.copyOfRange(this.array, 0, i) , Arrays.copyOfRange(this.array, i + 1, this.array.length));
				isRemoved = true;
				break;
			}
		}
		return isRemoved;
	}
	
	/**
	 * method which returns the index of first occurrence of element
	 * @param item - element to be search
	 * @return index of element at first occurence
	 */
	public int indexOf (T item) {
		int index = -1;
		
		for (int i = 0; i < this.array.length; i++) {
			
			if (this.array[i] == item) {
				index = i;
			}
		}
		return index;
	}
	
	/**
	 * method which returns the index of first occurrence of element after given location
	 * @param location - search after this location
	 * @param item - element to be search
	 * @return - index of element after specified location
	 */
	public int indexOf (int location, T item) {
		int index = -1;
		
		for (int i = location; i < this.array.length; i++) {
			
			if (this.array[i] == item) {
				index = i;
			}
		}
		return index;
	}
	
	/**
	 * method removes all element by re-creating array of 0 size
	 */
	public void clear () {
		this.array = createArray(0);
	}
	
	/**
	 * method which sort the array
	 */
	public void sort () {
		Arrays.sort(this.array);
	}
	
	/**
	 * method which reverse all elements of array
	 */
	public void reverse () {
		
		for(int i = 0, j = this.array.length - 1; i < j; i++, j--) {
			T temp = this.array[i];
			this.array[i] = this.array[j];
			this.array[j] = temp;
		}
	}
	
	/**
	 * method which append array into the list
	 * @param arrayToAppend - array to append
	 */
	public void append(T[] arrayToAppend) {
		this.array = append(this.array , arrayToAppend);
	}
	
	/**
	 * method which append same type of list into this list
	 * @param listToAdd - list to append
	 */
	public void append (ArrayList<T> listToAdd) {
		this.array = append (this.array , listToAdd.array);
	}
	
	/**
	 * method which append array into another array 
	 * @param firstArray - array in which another array will get append
	 * @param secondArray - array to append 
	 * @return resultant of both array after append
	 */
	private T[] append (T[] firstArray, T[] secondArray) {
		T[] arr = createArray(firstArray.length + secondArray.length);
		System.arraycopy(firstArray, 0, arr, 0, firstArray.length);
		System.arraycopy(secondArray, 0, arr, firstArray.length, secondArray.length);
		return arr;
	}
	
	/**
	 * method to create array
	 * @param arrSize - size of array
	 * @return - created array
	 */
	@SuppressWarnings("unchecked")
	private T[] createArray (int arrSize) {
		return (T[]) new Object[arrSize];
	}
	
	/**
	 * method to get this array
	 * @return - array
	 */
	public T[] getArray(){
		return this.array;
	}
}