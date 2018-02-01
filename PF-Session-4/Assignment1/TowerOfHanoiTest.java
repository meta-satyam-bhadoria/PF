/*
 * This test case file is to test TowerOfHanoi class working.
 */
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * class to test QuickSort class implementation
 * @author satyam bhadoria
 *
 */
public class TowerOfHanoiTest {
	public TowerOfHanoi towerOfHanoi = new TowerOfHanoi();		//creating object

	/*successful test case for tower of hanoi*/
	@Test
	public void testTowerOfHanoi() {
		int n = 3;
		List<String> expected=Arrays.asList("Move disk 1 from rod A to rod C",
				"Move disk 2 from rod A to rod B",
				"Move disk 1 from rod C to rod B",
				"Move disk 3 from rod A to rod C",
				"Move disk 1 from rod B to rod A",
				"Move disk 2 from rod B to rod C",
				"Move disk 1 from rod A to rod C");
		try {
			assertEquals(expected, towerOfHanoi.towerOfHanoi(n, 'A', 'C', 'B'));
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}
	}
	
	/*failure test case for tower of hanoi when number of disk is 0*/
	@Test(expected = ArithmeticException.class)
	public void testTowerOfHanoi1() throws ArithmeticException {
		int n = 0;
		List<String> expected=Arrays.asList("");
		assertEquals(expected, towerOfHanoi.towerOfHanoi(n, 'A', 'C', 'B'));
	}
	
	/*failure test case for tower of hanoi when number of disk is in negative*/
	@Test(expected = ArithmeticException.class)
	public void testTowerOfHanoi2() throws ArithmeticException {
		int n = -2;
		List<String> expected=Arrays.asList("");
		assertEquals(expected, towerOfHanoi.towerOfHanoi(n, 'A', 'C', 'B'));
	}

}
