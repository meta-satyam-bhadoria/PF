/**
* exception class used by Pyramid class
*/

/**
 * This class shows message when this type of exception is raised by pyramid class
 * @author satyam bhadoria
 *
 */
public class PatternException extends Exception {
	
	/**
	 * Constructor
	 * @param message - message to show
	 */
	public PatternException(String message){
		super(message);
	}
}
