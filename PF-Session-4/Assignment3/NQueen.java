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
	 * @param dimensionOfMatrix - dimension of board
	 * @return true(if all queens are placed) or false(if not)
	 */
	public boolean nQueen (int[][] board, int startRow, int dimensionOfMatrix) {
		
		/*throw exception if row number is in negative*/
		if (startRow < 0) {
			throw new ArithmeticException("row number should not be in negative");
		}
		
		/*throw exception if dimension is less than 1*/
		if (dimensionOfMatrix <= 0) {
			throw new ArithmeticException("dimension of board is invalid");
		}
		
		return nQueenUtil (board, startRow, dimensionOfMatrix);
	}
	
	/**
	 * This method will place n queens safely.
	 * @param board - of n X n size
	 * @param startRow - row number from where queens are going to be placed
	 * @param dimensionOfMatrix - dimension of board
	 * @return true(if all queens are placed) or false(if not)
	 */
	private boolean nQueenUtil (int[][] board, int startRow, int dimensionOfMatrix) {
		
		/*returns true if queens placed in every row*/
		if (startRow >= dimensionOfMatrix) {
			return true;
		}
		
		/*this loop places queen safely*/
		for (int colNum = 0; colNum < dimensionOfMatrix; colNum++) {
			
			/*place queen if square is safe to place*/
			if ( isSafe (board, startRow - 1, colNum, dimensionOfMatrix) ) {
				board[startRow][colNum] = 1;
				
				/*place at next row*/
				if ( nQueenUtil (board, startRow + 1, dimensionOfMatrix) ) {
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
	 * @param dimensionOfMatrix - board size
	 * @return true(can be place) or false(cannot be place)
	 */
	public boolean isSafe (int[][] board, int rowNum, int colNum, int dimensionOfMatrix) {
		/*check for current column upwards*/
		for (int i = rowNum; i >= 0; i--) {
			if ( board[i][colNum] == 1 ){
				return false;
			}
		}
		
		/*check for left diagonal upwards*/
		for (int i = colNum - 1, j = rowNum; (i >= 0 && j >= 0); i--, j--) {
			if ( board[j][i] == 1 ) {
				return false;
			}
		}
		
		/*check for right diagonal upwards*/
		for (int i = colNum + 1; (i < dimensionOfMatrix && rowNum >= 0); i++, rowNum--) {
			if ( board[rowNum][i] == 1 ) {
				return false;
			}
		}
		return true;
	}
}
