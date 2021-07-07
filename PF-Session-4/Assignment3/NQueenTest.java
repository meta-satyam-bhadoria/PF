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
	
	/**
	 * successful test case for nQueen
	 * 
	 */
	@Test
	public void testNQueenForTrueReturn() {
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
	
	/**
	 * successful test case for nQueen
	 */
	@Test
	public void testNQueenForReturnFalse() {
		int dimension = 3;
		int[][] board = new int[dimension][dimension];
		assertEquals(false, nQueen.nQueen(board, 0, dimension));
	}
	
	/**
	 * failure test case for checking arithmetic exception when nQueen when dimension of board is 0
	 */
	@Test(expected = ArithmeticException.class)
	public void testNQueenArithmeticExceptionCheck() {
		int dimension = 0;
		int[][] board = new int[dimension][dimension];
		assertEquals(false, nQueen.nQueen(board, 0, dimension));
	}
	
	/**
	 * failure test case for checking arithmetic exception when nQueen when row number  is negative
	 * 
	 */
	@Test(expected = ArithmeticException.class)
	public void testNQueenArithmeticExceptionCheck1() {
		int dimension = 4;
		int[][] board = new int[dimension][dimension];
		assertEquals(false, nQueen.nQueen(board, -1, dimension));
	}
	
	/**
	 * failure test case for checking Array out of bound of index exception
	 */
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testNQueenIndexOutOfBound() {
		int dimension = 4;
		int[][] board = new int[dimension][dimension];
		assertEquals(false, nQueen.nQueen(board, 0, 5));
	}

}
