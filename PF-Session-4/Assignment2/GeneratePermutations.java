/*
 * This program will implements the logic of
 * generating all set of permutations of letters
 * of a string.
 */
import java.util.ArrayList;
import java.util.List;

/**
 * This class implements algorithm for generating
 * all possible combination of letters in a string.
 * @author satyam bhadoria
 * @version 1.0
 */
public class GeneratePermutations {
	
	/**
	 * This method call another method to generate
	 * permutations.
	 * @param string - to which combinations to be generated.
	 * @return set - set of all possible combination
	 */
	public List<String> generatePermutations (String string) {
		List<String> set = new ArrayList<String>();			//store set of all possible permutations.
		
		/*throw exception if no string is passed or string size 0 is passed*/
		if (string.length() == 0) {
			throw new ArithmeticException("String size should be greater than zero");
		}
		generate (set , string , 1);			//method to find permutations
		return set;
	}
	
	/**
	 * This method actually implements the algorithm
	 * @param set - 
	 * @param string - combinations to be generated
	 * @param stringIndex - from which to find permutations
	 * @return set - set of all permutations
	 */
	public List<String> generate (List<String> set, String string, int stringIndex) {
		char[] str = string.toCharArray();			//store string in array form
		
		/*if operation done on final index return set */
		if(stringIndex == string.length()){
			set.add(string);
			return set;
		}
		
		/*perform operation from string index to final index to find permutations*/
		for(int i = stringIndex; i <= string.length(); i++){
			string = new String(str, 0, string.length());
			
			generate(set, string, stringIndex + 1);			//repeat process recursive on sub string
			
			/*swap two adjacent letters to create new string*/
			if(i < string.length()){
				char temporaryChar = str[i];
				str[i] = str[stringIndex - 1];
				str[stringIndex - 1] = temporaryChar;
			}
		}
		return set;
	}
}
