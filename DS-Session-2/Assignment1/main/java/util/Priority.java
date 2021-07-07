package main.java.util;

import java.util.HashMap;
import java.util.Map;

/**
 * This class contain priority of operators
 * @author satyam bhadoria
 *
 */
public class Priority {
	private Map<Character, Integer> priorities= new HashMap<>();
	
	/**
	 * constructor
	 */
	public Priority() {
        priorities.put('(', 0);
        priorities.put(')', 0);
		priorities.put('+', 1);
		priorities.put('-', 1);
		priorities.put('*', 2);
		priorities.put('/', 2);
		priorities.put('%', 2);
		priorities.put('^', 3);
	}
	
	/**
	 * method which return the priority of operator
	 * @param operator - operator fro which priority to be returned
	 * @return priority of operator
	 */
	public int getPriority(Character operator) {
		int priority = -1;
		
		if( isContain(operator) ) {
			priority = priorities.get(operator);
		}
		return priority;
	}
	
	/**
	 * method to check the availability of operator
	 * @param operator - operator passed
	 * @return true or false
	 */
	public boolean isContain(Character operator) {
		return priorities.containsKey(operator);
	}
	
}
