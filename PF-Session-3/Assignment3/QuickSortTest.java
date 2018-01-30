/*
 * This test case file is to test QuickSort class working.
 */
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * class to test QuickSort class implementation
 * @author satyam bhadoria
 *
 */
public class QuickSortTest {
	protected QuickSort sort = new QuickSort();		//creating object
	
	/*positive test case*/
	@Test
	public void test() {
		int inputArray[] = new int[] {1,5,2,8,3,9,23,67,13};
		int startIndex = 0;
		int endIndex = 8;
		int expected[] = new int[] {1,2,3,5,8,9,13,23,67};
		assertArrayEquals(expected, sort.quickSort(inputArray, startIndex, endIndex));
	}
	
	/*positive test case*/
	@Test
	public void test1() {
		int inputArray[] = new int[] {1,5,2,4,-9,2,-1,-7,65,14};
		int startIndex = 0;
		int endIndex = 9;
		int expected[] = new int[] {-9,-7,-1,1,2,2,4,5,14,65};
		assertArrayEquals(expected, sort.quickSort(inputArray, startIndex, endIndex));
	}
	
	/*positive test case*/
	@Test
	public void test2() {
		int inputArray[] = new int[] {1,1,1,1,1};
		int startIndex = 0;
		int endIndex = 4;
		int expected[] = new int[] {1,1,1,1,1};
		assertArrayEquals(expected, sort.quickSort(inputArray, startIndex, endIndex));
	}
	
	/*negative test case*/
	@Test(expected = ArithmeticException.class)
	public void test3() {
		int inputArray[] = new int[] {};
		int startIndex = 0;
		int endIndex = 0;
		int expected[] = new int[] {};
		assertArrayEquals(expected, sort.quickSort(inputArray, startIndex, endIndex));
	}

}
