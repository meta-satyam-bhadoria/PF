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

	protected NQueen nQueen = new NQueen();
	
	/*positive test case*/
	@Test
	public void test() {
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
	
	/*positive test case*/
	@Test
	public void test1() {
		int dimension = 3;
		int[][] board = new int[dimension][dimension];
		assertEquals(false, nQueen.nQueen(board, 0, dimension));
	}
	
	/*negative test case*/
	@Test(expected = ArithmeticException.class)
	public void test2() {
		int dimension = 0;
		int[][] board = new int[dimension][dimension];
		assertEquals(false, nQueen.nQueen(board, 0, dimension));
	}

}
