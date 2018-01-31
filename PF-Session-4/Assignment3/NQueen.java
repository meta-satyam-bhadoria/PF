/*
 * This program is about nQueen problem in which
 * the task is to place 'n' queen in 'n X n' board
 * such that no two queens will intersect each other
 * either vertically or horizontally or diagonally. 
 */

/**
 * This class will implements the algorithm for
 * placing n queens in nXn board.
 * @author satyam bhadoria
 * @version 1.0
 */
public class NQueen {
	
	/**
	 * This method will place n queens safely.
	 * @param board - of n X n size
	 * @param startRow - row number from where queens are going to be placed
	 * @param dimension - dimension of board
	 */
	protected boolean nQueen (int[][] board, int startRow, int dimension) {
		
		/*throw exception if row number is in negative*/
		if (startRow < 0) {
			throw new ArithmeticException("row number should not be in negative");
		}
		
		/*throw exception if dimension is less than 1*/
		if (dimension <= 0) {
			throw new ArithmeticException("dimension of board should be greater than 0");
		}
		
		/*returns true if queens placed in every row*/
		if (startRow >= dimension) {
			return true;
		}
		
		/*this loop places queen safely*/
		for (int colNum = 0; colNum < dimension; colNum++) {
			
			/*place queen if square is safe to place*/
			if ( isSafe (board, startRow, colNum, dimension) ) {
				board[startRow][colNum] = 1;
				
				/*place at next row*/
				if ( nQueen (board, startRow + 1, dimension) ) {
					return true;
				}
			}
			board[startRow][colNum] = 0;		//unplacing queen as it is unsafe position
		}
		return false;
	}
	
	/**
	 * This method checks for place is safe or unsafe
	 * @param board - of size nXn
	 * @param rowNum - current row position
	 * @param colNum - current column position
	 * @param dimension - board size
	 */
	private boolean isSafe (int[][] board, int rowNum, int colNum, int dimension) {
		return checkColumn (board, rowNum - 1, colNum, dimension);
	}
	
	/**
	 * This method checks for squares vertically above the
	 * current square for safe or unsafe
	 * @param board - of size nXn
	 * @param rowNum - current row position
	 * @param colNum - current column position
	 * @param dimension - board size
	 * @return
	 */
	private boolean checkColumn (int[][] board, int rowNum, int colNum, int dimension) {
		
		/*if finds any square already placed with queen return unsafe position
		 * else check for left diagonal */
		for (int i = rowNum; i >= 0; i--) {
			if ( board[i][colNum] == 1 ){
				return false;
			}
		}
		return checkLeftDiagonal (board, rowNum, colNum, dimension);
	}
	
	/**
	 * This method checks for squares to diagonally
	 * left to top to current square for safe or unsafe
	 * @param board - of size nXn
	 * @param rowNum - current row position
	 * @param colNum - current column position
	 * @param dimension - board size
	 * @return
	 */
	private boolean checkLeftDiagonal (int[][] board, int rowNum, int colNum, int dimension) {
		
		/*if finds any square already placed with queen return unsafe position
		 * else check for right diagonal */
		for (int i = colNum - 1, j = rowNum; (i >= 0 && j >= 0); i--, j--) {
			if ( board[j][i] == 1 ) {
				return false;
			}
		}
		return checkRightDiagonal (board, rowNum, colNum, dimension);
	}
	
	/**
	 * This method checks for squares to diagonally
	 * right to top to current square for safe or unsafe
	 * @param board - of size nXn
	 * @param rowNum - current row position
	 * @param colNum - current column position
	 * @param dimension - board size
	 * @return
	 */
	private boolean checkRightDiagonal (int[][] board, int rowNum, int colNum, int dimension) {
		
		/*if finds any square already placed with queen return unsafe position else safe*/
		for (int i = colNum + 1; (i < dimension && rowNum >= 0); i++, rowNum--) {
			if ( board[rowNum][i] == 1 ) {
				return false;
			}
		}
		return true;
	}
}
