/*
 * This test case file is to test NQueen class working.
 */
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * class to test NQueen class implementation
 * @author satyam bhadoria
 *
 */
public class NQueenTest {

	public NQueen nQueen = new NQueen();
	
	/*successful test case for nQueen*/
	@Test
	public void testNQueen() {
		int dimension = 4;
		int[][] board = new int[dimension][dimension];
		assertEquals(true, nQueen.nQueen(board, 0, dimension));
		
		/*print board*/
		for (int i = 0; i < dimension; i++){
			for (int j = 0; j < dimension; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	/*successful test case for nQueen*/
	@Test
	public void testNQueen1() {
		int dimension = 3;
		int[][] board = new int[dimension][dimension];
		assertEquals(false, nQueen.nQueen(board, 0, dimension));
	}
	
	/*failure test case for nQueen when dimension of board is 0*/
	@Test(expected = ArithmeticException.class)
	public void testNQueen2() {
		int dimension = 0;
		int[][] board = new int[dimension][dimension];
		assertEquals(false, nQueen.nQueen(board, 0, dimension));
	}
	
	/*failure test case for nQueen when starting row is negative*/
	@Test(expected = ArithmeticException.class)
	public void testNQueen3() {
		int dimension = 4;
		int[][] board = new int[dimension][dimension];
		assertEquals(false, nQueen.nQueen(board, -1, dimension));
	}
	
	/*failure test case for nQueen when dimension is greater board size*/
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testNQueen4() {
		int dimension = 4;
		int[][] board = new int[dimension][dimension];
		assertEquals(false, nQueen.nQueen(board, 0, 5));
	}

}
