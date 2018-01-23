import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class FcfsTest {
	Fcfs fcfs;
	
	@Before
	public void testThis(){
		fcfs = new Fcfs();
	}

	@Test
	public void test() {
		int[] arrivalTime = new int[] {1,5,9,25};
		int[] jobSize = new int[] {12,7,2,5};
		int[][] output = new int[][] {{1,1,0,1,12}, {2,5,8,13,19},
									{3,9,11,20,21}, {4,25,0,25,29}};
		assertArrayEquals(output, fcfs.fcfs(arrivalTime, jobSize));
	}
	
	@Test
	public void test1() {
		int[] arrivalTime = new int[] {1,5,10,15};
		int[] jobSize = new int[] {8,5,6,7};
		int[][] output = new int[][] {{1,1,0,1,8}, {2,5,4,9,13},
									{3,10,4,14,19}, {4,15,5,20,26}};
		assertArrayEquals(output, fcfs.fcfs(arrivalTime, jobSize));
	}

}
