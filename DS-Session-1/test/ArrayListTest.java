package test;

import static org.junit.Assert.*;

import org.junit.Test;

import myjava.util.ArrayList;

public class ArrayListTest {

	@Test
	public void testAddMethod() {
		ArrayList<String> s = new ArrayList<>();
		s.add("1");
		s.add(1, "2");
		s.add("3");
		String[] expected = new String[] {"1","2","3"};
		assertArrayEquals(expected, s.getArray());  
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testAddMethodForException() {
		ArrayList<String> s = new ArrayList<>();
		s.add("1");
		s.add(2, "2");
		s.add("3");
		String[] expected = new String[] {"1","2","3"};
		assertArrayEquals(expected, s.getArray());  
	}
	
	@Test
	public void testRemoveMethod() {
		ArrayList<String> s = new ArrayList<>();
		s.add("1");
		s.add("2");
		s.add("3");
		String expected = "1";
		assertEquals(expected, s.remove(0));  
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveMethodForException() {
		ArrayList<String> s = new ArrayList<>();
		s.add("1");
		s.add("2");
		s.add("3");
		String expected = "1";
		assertEquals(expected, s.remove(5));  
	}
}
