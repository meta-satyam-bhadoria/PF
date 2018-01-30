/*
 * test case file to test Fcfs class working
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * class to test Fcfs class implementation
 * @author satyam bhadoria
 *
 */
public class FcfsTest {
	protected Fcfs fcfs;		//create object
	
	/*initialize object*/
	@Before
	public void testThis(){
		fcfs = new Fcfs();
	}
	
	/*positive test case*/
	@Test
	public void test() {
		int[] arrivalTime = new int[] {1,5,9,25};
		int[] jobSize = new int[] {12,7,2,5};
		int[][] output = new int[][] {{1,1,0,1,12}, {2,5,8,13,19},
									{3,9,11,20,21}, {4,25,0,25,29}};
		assertArrayEquals (output, fcfs.fcfs (arrivalTime, jobSize) );
	}
	
	/*positive test case*/
	@Test
	public void test1() {
		int[] arrivalTime = new int[] {1,5,10,15};
		int[] jobSize = new int[] {8,5,6,7};
		int[][] output = new int[][] {{1,1,0,1,8}, {2,5,4,9,13},
									{3,10,4,14,19}, {4,15,5,20,26}};
		assertArrayEquals (output, fcfs.fcfs (arrivalTime, jobSize) );
	}
	
	/*negative test case*/
	@Test(expected = ArithmeticException.class)
	public void test2() {
		int[] arrivalTime = new int[] {};
		int[] jobSize = new int[] {};
		int[][] output = new int[][] {};
		assertArrayEquals (output, fcfs.fcfs (arrivalTime, jobSize) );
	}

}
