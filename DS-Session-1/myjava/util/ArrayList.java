package myjava.util;

import java.util.Arrays;

public class ArrayList<T> {
	private T[] array = null;
	private int size = 0;
	private int index = 0;
	
	public ArrayList() {
		this.array = createArray(0);
	}
	
	public void add (T item) {
		this.array = Arrays.copyOf(this.array, this.array.length + 1);
		this.array[this.array.length - 1] = item;
	}
	
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
	
	public T remove (int position) {
		T removedNumber;
		if (position < this.array.length && position >= 0) {
			removedNumber = this.array[position];
			this.array = append ( Arrays.copyOfRange(this.array, 0, position) , Arrays.copyOfRange(this.array, position + 1, this.array.length));
		} else{
			throw new IndexOutOfBoundsException();
		}
		return removedNumber;
	}
	
	public boolean remove (T item) {
		boolean isRemoved = false;
		for (int i = 0; i < this.array.length; i++) {
			if (this.array[i] == item) {
				this.array = append ( Arrays.copyOfRange(this.array, 0, i) , Arrays.copyOfRange(this.array, i + 1, this.array.length));
				isRemoved = true;
				break;
			}
		}
		return isRemoved;
	}
	
	public int indexOf (T item) {
		int index = -1;
		for (int i = 0; i < this.array.length; i++) {
			if (this.array[i] == item) {
				index = i;
			}
		}
		return index;
	}
	
	public int indexOf (int location, T item) {
		int index = -1;
		for (int i = location; i < this.array.length; i++) {
			if (this.array[i] == item) {
				index = i;
			}
		}
		return index;
	}
	
	public void clear () {
		this.array = createArray(0);
	}
	
	public void sort () {
		Arrays.sort(this.array);
	}
	
	public void reverse () {
		for (int i = 0, j = this.array.length - 1; i < j; i++, j--) {
			T temp = this.array[i];
			this.array[i] = this.array[j];
			this.array[j] = temp;
		}
	}
	
	public void append (T[] arrayAppend) {
		this.array = append (this.array , arrayAppend);
		this.size += arrayAppend.length;
		this.index += arrayAppend.length;
	}
	
	public void append (ArrayList<T> listToAdd) {
		this.array = append (this.array , listToAdd.array);
		this.size += listToAdd.size;
		this.index += listToAdd.index;
	}
	
	private T[] append (T[] firstArray, T[] secondArray) {
		T[] arr = createArray(firstArray.length + secondArray.length);
		System.arraycopy(firstArray, 0, arr, 0, firstArray.length);
		System.arraycopy(secondArray, 0, arr, firstArray.length, secondArray.length);
		return arr;
	}
	
	@SuppressWarnings("unchecked")
	private T[] createArray (int arrSize) {
		return (T[]) new Object[arrSize];
	}
	
	public void display(){
		for(int i = 0 ;i < this.array.length;i++){
			System.out.println(this.array[i]);
		}
	}
	
	public T[] getArray(){
		return this.array;
	}
}