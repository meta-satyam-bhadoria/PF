package main.java.util;

import java.util.HashMap;
import java.util.Map;

/**
 * This class contain priority of operators
 * @author satyam bhadoria
 *
 */
public class Priority {
	public Map<Character, Integer> priorities= new HashMap<>();
	
	/**
	 * constructor
	 */
	public Priority() {
		priorities.put('+', 1);
		priorities.put('-', 1);
		priorities.put('*', 2);
		priorities.put('/', 2);
		priorities.put('%', 2);
		priorities.put('^', 3);
	}
	
}
