package test;

import static org.junit.Assert.*;
import main.java.util.Queue;

import org.junit.Test;

/**
 * this class is to test the implementation of queue class
 * @author Satyam Bhadoria
 *
 */
public class QueueTest {

	/**
	 * method to test enQueue method for inserting into queue
	 */
	@Test
	public void testEnQueue() {
		Queue<Integer> queue = new Queue<>();
		queue.enQueue(3);
		queue.enQueue(5);
		Integer[] expected = new Integer[] {3,5};
		assertArrayEquals(expected, queue.toArray());
	}
	
	/**
	 * method to test deQueue method for removing from queue
	 */
	@Test
	public void testDequeue() {
		Queue<Integer> queue = new Queue<>();
		queue.enQueue(3);
		queue.enQueue(5);
		queue.enQueue(2);
		queue.deQueue();
		Integer[] expected = new Integer[] {5,2};
		assertArrayEquals(expected, queue.toArray());
	}
	
	/**
	 * method to test deQueue method for check for ArrayIndexOutOfBoundsException
	 */
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testDeQueueForException() {
		Queue<Integer> queue = new Queue<>();
		queue.enQueue(3);
		queue.enQueue(5);
		queue.deQueue();
		queue.deQueue();
		queue.deQueue();
	}
	
	/**
	 * method to test getFront method for getting front element
	 */
	@Test
	public void testGetFront() {
		Queue<Integer> queue = new Queue<>();
		queue.enQueue(3);
		queue.enQueue(5);
		Integer expected = 3;
		assertEquals(expected, queue.getFront());
	}
	
	/**
	 * method to test getFront method for check for ArrayIndexOutOfBoundsException
	 */
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testGetFrontForException() {
		Queue<Integer> queue = new Queue<>();
		queue.getFront();
	}

}
