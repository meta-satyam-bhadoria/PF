/*
 * This program will find the way for knight to
 * visit all square once of n X n chess board.
 */

/**
 * This class implements the algorithm to fins the path.
 * @author Satyam Bhadoria
 * @version 1.0
 */
public class KnightsTour {
	
	/**
	 * This method  return the whether knights have visited
	 * square or not.
	 * @param board - chess board of nXn size
	 * @param dimensionOfBoard - dimension of chess board
	 * @return either true or false
	 */
	public static boolean knightsTour ( int board[][], int dimensionOfBoard) {
		board[0][0] = 1;
		return (knightsVisit (board, dimensionOfBoard, 0, 0, 1)) ;
	}
	
	/**
	 * This method check for safe square to visit knight
	 * @param board - chess board of nXn size
	 * @param dimensionOfBoard - dimension of chess board
	 * @param rowNum - row number to check
	 * @param colNum - column number to check
	 * @return either true or false
	 */
	public static boolean isSafe ( int board[][], int dimensionOfBoard, int rowNum, int colNum) {
		return ( (rowNum >= 0) && (rowNum < dimensionOfBoard) && (colNum >=0) && (colNum < dimensionOfBoard) && (board[rowNum][colNum] == 0) );
	}
	
	/**
	 * This method implements the algorithm.
	 * There are maximum of 8 cases to visit knight.
	 * So all eight cases is mentioned in this method.
	 * @param board - chess board of nXn size
	 * @param dimensionOfBoard - dimension of chess board
	 * @param rowNum - row number
	 * @param colNum - column number
	 * @param count - for check whether visited all square or not
	 */
	public static boolean knightsVisit ( int board[][], int dimensionOfBoard, int rowNum, int colNum, int count) {
		
		/*if visited all square return true*/
		if( count == dimensionOfBoard * dimensionOfBoard) {
			return true;
		}
		
		/*First case
		 *    0 0 0 0 0
		 *    0 0 0 0 0
		 *    0 0 K 0 0
		 *    0 0 0 0 0
		 *    0 0 0 1 0
		 */
		if ( isSafe (board, dimensionOfBoard, rowNum + 2, colNum + 1) ) {
			board[rowNum + 2][colNum + 1] = count + 1;		//if safe then make a visit
			
			if (knightsVisit (board, dimensionOfBoard, rowNum + 2, colNum + 1, count + 1) ) {
				return true;
			}
			board[rowNum + 2][colNum + 1] = 0;				//not safe backtrack
		}
		
		/*Second case
		 *    0 0 0 0 0
		 *    0 0 0 0 0
		 *    0 0 K 0 0
		 *    0 0 0 0 1
		 *    0 0 0 0 0
		 */
		if ( isSafe (board, dimensionOfBoard, rowNum + 1, colNum + 2) ) {
			board[rowNum + 1][colNum + 2] = count + 1;		//if safe then make a visit
			
			if (knightsVisit (board, dimensionOfBoard, rowNum + 1, colNum + 2, count + 1) ) {
				return true;
			}
			board[rowNum + 1][colNum + 2] = 0;				//not safe backtrack
		}
		
		/*Third case
		 *    0 0 0 0 0
		 *    0 0 0 0 1
		 *    0 0 K 0 0
		 *    0 0 0 0 0
		 *    0 0 0 0 0
		 */
		if ( isSafe (board, dimensionOfBoard, rowNum - 1, colNum + 2) ) {
			board[rowNum - 1][colNum + 2] = count + 1;		//if safe then make a visit
			
			if (knightsVisit (board, dimensionOfBoard, rowNum - 1, colNum + 2, count + 1) ) {
				return true;
			}
			board[rowNum - 1][colNum + 2] = 0;				//not safe backtrack
		}
		
		/*Fourth case
		 *    0 0 0 1 0
		 *    0 0 0 0 0
		 *    0 0 K 0 0
		 *    0 0 0 0 0
		 *    0 0 0 0 0
		 */
		if ( isSafe (board, dimensionOfBoard, rowNum - 2, colNum + 1) ) {
			board[rowNum - 2][colNum + 1] = count + 1;		//if safe then make a visit
			
			if (knightsVisit (board, dimensionOfBoard, rowNum - 2, colNum + 1, count + 1) ) {
				return true;
			}
			board[rowNum - 2][colNum + 1] = 0;				//not safe backtrack
		}
		
		/*Fifth case
		 *    0 1 0 0 0
		 *    0 0 0 0 0
		 *    0 0 K 0 0
		 *    0 0 0 0 0
		 *    0 0 0 0 0
		 */
		if ( isSafe (board, dimensionOfBoard, rowNum - 2, colNum - 1) ) {
			board[rowNum - 2][colNum - 1] = count + 1;		//if safe then make a visit
			
			if (knightsVisit (board, dimensionOfBoard, rowNum - 2, colNum - 1, count + 1) ) {
				return true;
			}
			board[rowNum - 2][colNum - 1] = 0;				//not safe backtrack
		}
		
		/*Sixth case
		 *    0 0 0 0 0
		 *    1 0 0 0 0
		 *    0 0 K 0 0
		 *    0 0 0 0 0
		 *    0 0 0 0 0
		 */
		if ( isSafe (board, dimensionOfBoard, rowNum - 1, colNum - 2) ) {
			board[rowNum - 1][colNum - 2] = count + 1;		//if safe then make a visit
			
			if (knightsVisit (board, dimensionOfBoard, rowNum - 1, colNum - 2, count + 1) ) {
				return true;
			}
			board[rowNum - 1][colNum - 2] = 0;				//not safe backtrack
		}
		
		/*Seventh case
		 *    0 0 0 0 0
		 *    0 0 0 0 0
		 *    0 0 K 0 0
		 *    1 0 0 0 0
		 *    0 0 0 0 0
		 */
		if ( isSafe (board, dimensionOfBoard, rowNum + 1, colNum - 2) ) {
			board[rowNum + 1][colNum - 2] = count + 1;		//if safe then make a visit
			
			if (knightsVisit (board, dimensionOfBoard, rowNum + 1, colNum - 2, count + 1) ) {
				return true;
			}
			board[rowNum + 1][colNum - 2] = 0;				//not safe backtrack
		}
		
		/*Eighth case
		 *    0 0 0 0 0
		 *    0 0 0 0 0
		 *    0 0 K 0 0
		 *    0 0 0 0 0
		 *    0 1 0 0 0
		 */
		if ( isSafe (board, dimensionOfBoard, rowNum + 2, colNum - 1) ) {
			board[rowNum + 2][colNum - 1] = count + 1;		//if safe then make a visit
			
			if (knightsVisit (board, dimensionOfBoard, rowNum + 2, colNum - 1, count + 1) ) {
				return true;
			}
			board[rowNum + 2][colNum - 1] = 0;				//not safe backtrack
		}
		return false;			//return false or backtrack if no case is safe to visit
	}
	
	/**
	 * driver program to test the above implementation
	 */
	public static void main(String args[]) {
		int dimensionOfBoard = 8;
		int[][] board = new int[dimensionOfBoard][dimensionOfBoard];
		
		knightsTour(board, dimensionOfBoard);
		
		/*print board*/
		for (int i = 0; i < dimensionOfBoard; i++) {
			for (int j = 0;j < dimensionOfBoard; j++) {
				System.out.print( board[i][j] + "  ");
			}
			System.out.println();
		}
	}
}