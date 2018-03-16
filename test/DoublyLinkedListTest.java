package test;

import static org.junit.Assert.*;
import main.java.util.DoublyLinkedList;

import org.junit.Test;

/**
 * This class is used to test the implementation of LinkedList class
 * @author satyam bhadoria
 *
 */
public class DoublyLinkedListTest {

	/**
	 * Method to test add method for successful result
	 */
	@Test
	public void testAddMethod() {
		DoublyLinkedList<String> s = new DoublyLinkedList<>();
		s.add("1");
		s.add(0, "2");
		s.add("3");
		String[] expected = new String[] {"2","1","3"};
		assertArrayEquals(expected, s.toArray());
	}
	
	/**
	 * 
	 * method to test add method for generating IndexOutOfBoundsException
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testAddMethodForException() {
		DoublyLinkedList<String> s = new DoublyLinkedList<>();
		s.add("1");
		s.add(2, "2");
		s.add("3");
		String[] expected = new String[] {"1","2","3"};
		assertArrayEquals(expected, s.toArray());  
	}
	
	/**
	 * method to test remove method by providing position for successful result
	 */
	@Test
	public void testRemoveMethod() {
		DoublyLinkedList<String> s = new DoublyLinkedList<>();
		s.add("1");
		s.add("2");
		s.add("3");
		String expected = "1";
		assertEquals(expected, s.remove(0));  
	}
	
	/**
	 * method to test remove method by providing position for generating IndexOutOfBoundsException
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveMethodForException() {
		DoublyLinkedList<String> s = new DoublyLinkedList<>();
		s.add("1");
		s.add("2");
		s.add("3");
		String expected = "1";
		assertEquals(expected, s.remove(5));  
	}
	
	/**
	 * method to test remove method by providing element for successful result
	 */
	@Test
	public void testRemoveMethodByElement() {
		DoublyLinkedList<String> s = new DoublyLinkedList<>();
		s.add("1");
		s.add("2");
		s.add("3");
		boolean expected = true;
		assertEquals(expected, s.remove("2"));  
	}
	
	/**
	 * method to test remove method by providing element for unsuccessful result
	 */
	@Test
	public void testRemoveMethodByElementUnSuccessful() {
		DoublyLinkedList<String> s = new DoublyLinkedList<>();
		s.add("1");
		s.add("2");
		s.add("3");
		boolean expected = false;
		assertEquals(expected, s.remove("4"));  
	}
	
	/**
	 * method to test getElement method at particular position
	 */
	@Test
	public void testGetElementMethod(){
		DoublyLinkedList<String> s = new DoublyLinkedList<>();
		s.add("1");
		s.add("2");
		s.add("3");
		String expected = "1";
		assertEquals(expected, s.getElement(0));  
	}
	
	/**
	 * method to test getElement method at particular position for getting IndexOutOfBoundsException
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetElementMethodForException(){
		DoublyLinkedList<String> s = new DoublyLinkedList<>();
		s.add("1");
		s.add("2");
		s.add("3");
		String expected = "2";
		assertEquals(expected, s.getElement(3));  
	}
	
	/**
	 * method to test reverse method 
	 */
	@Test
	public void testReverseMethod() {
		DoublyLinkedList<String> s = new DoublyLinkedList<>();
		s.add("1");
		s.add("2");
		s.add("3");
		s.reverse();
		String[] expected = new String[] {"3","2","1"};
		assertArrayEquals(expected, s.toArray());
	}
	
	/**
	 * method to test the sort method
	 */
	@Test
	public void testSortMethod() {
		DoublyLinkedList<String> s = new DoublyLinkedList<>();
		s.add("2");
		s.add("1");
		s.add("3");
		s.sort();
		String[] expected = new String[] {"1","2","3"};
		assertArrayEquals(expected, s.toArray());
	}
}
