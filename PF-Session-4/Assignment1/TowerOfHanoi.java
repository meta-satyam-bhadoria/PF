/*
 * This file contain class which will find the sequence of
 * move disks from first rod to third rod with the help
 * of second rod such no larger disk can come on smaller disk.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * This class will implements the tower of hanoi problem
 * as discussed above.
 * @author satyam bhadoria
 * @version 1.0
 */
public class TowerOfHanoi {
	
	/**
	 * This method returns the list of moves required for
	 * solving tower of hanoi problem
	 * @param moves
	 * @param n
	 * @param first
	 * @param third
	 * @param second
	 * @return moves
	 */
	protected List<String> towerOfHanoi (int n, char first, char third, char second) throws DiskError{
		List<String> moves =  new ArrayList<String>();		//create list of moves
		
		/*throws exception if disk number is not greater than 0*/
		if(n <= 0){
			throw new DiskError("There should be atleast one disk");
		}
		
		/*move top disk from first to last if only one disk is present*/
		if (n == 1) {
			moves.add ("Move disk 1 from rod " +  first + " to rod " + third);
			return moves;
		}
		
		/*move n-1 disk from first to second*/
		moves.addAll( towerOfHanoi (n-1, first, second, third) );
		moves.add ("Move disk " + n + " from rod " +  first + " to rod " + third);
		
		/*move n-1 disk from second to third*/
		moves.addAll( towerOfHanoi (n-1, second, third, first) );
		return moves;
	}
}

/**
 * creating own exception class
 *
 */
class DiskError extends Exception{
	DiskError(String message){
		super(message);
	}
}
