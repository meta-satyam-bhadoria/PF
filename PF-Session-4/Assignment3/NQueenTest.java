import static org.junit.Assert.*;

import org.junit.Test;

public class NQueenTest {

	NQueen nQueen = new NQueen();
	
	@Test
	public void test() {
		int dimension = 4;
		int[][] board = new int[dimension][dimension];
		assertEquals(true, nQueen.nQueen(board, 0, dimension));
	}
	
	@Test
	public void test1() {
		int dimension = 3;
		int[][] board = new int[dimension][dimension];
		assertEquals(false, nQueen.nQueen(board, 0, dimension));
	}

}
