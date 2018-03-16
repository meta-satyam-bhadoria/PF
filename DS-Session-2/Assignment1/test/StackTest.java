package test;

import static org.junit.Assert.*;
import main.java.util.Stack;

import org.junit.Test;

/**
 * This class is to test the Stack class implementation
 * @author satyam bhadoria
 *
 */
public class StackTest {

	/**
	 * method to test push method
	 */
	@Test
	public void testPushMethod() {
		Stack<Integer> stack = new Stack<>();
		stack.push(3);
		stack.push(4);
		Integer[] expected = new Integer[] {4,3};
		assertArrayEquals(expected, stack.toArray());
	}
	
	/**
	 * method to test pop method
	 */
	@Test
	public void testPopMethod() {
		Stack<Integer> stack = new Stack<>();
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.pop();
		Integer[] expected = new Integer[] {4,3};
		assertArrayEquals(expected, stack.toArray());
	}
	
	/**
	 * method to test pop method for getting IndexOutOfBoundsException
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testPopMethodForException() {
		Stack<Integer> stack = new Stack<>();
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		Integer[] expected = new Integer[] {4,3};
		assertArrayEquals(expected, stack.toArray());
	}
	
	/**
	 * method to test peek method
	 */
	@Test
	public void testPeekMethod() {
		Stack<Integer> stack = new Stack<>();
		stack.push(3);
		stack.push(4);
		Integer expected = 4;
		assertEquals(expected, stack.peek());
	}
	
	/**
	 * method to test peek method for getting IndexOutOfBoundsException
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testPeekMethodForException() {
		Stack<Integer> stack = new Stack<>();
		Integer expected = 4;
		assertEquals(expected, stack.peek());
	}
}
