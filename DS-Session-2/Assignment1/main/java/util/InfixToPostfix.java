package main.java.util;

/**
 * This class is used to convert infix expression into postfix expression
 * @author satyam bhadoria
 *
 */
public class InfixToPostfix {
	private Stack<Character> operatorStack;
	private Stack<Character> stack;
	private Priority priority;
	
	/**
	 * constructor
	 */
	public InfixToPostfix() {
		operatorStack = new Stack<>();
		stack = new Stack<>();
		priority = new Priority();
	}
	
	public void convertToPostfix(char[] infix) {
		
		int i = 0;
		int length = infix.length;
		while(length > 0) {
			length--;
			if( infix[i] >= 97 && infix[i] <=122) {
				stack.push(infix[i]);
				
			} else if(infix[i] == ' ') {
				continue;
			} else {
				if( operatorStack.isEmpty() ) {
					operatorStack.push(infix[i]);
					
				} else if( priority.priorities.get( operatorStack.peek() ) <= priority.priorities.get(infix[i]) ) {
					operatorStack.push(infix[i]);
					
				} else {
					stack.push(operatorStack.pop());
					operatorStack.push(infix[i]);
				}
			}
			i++;
		}
		
		while(!operatorStack.isEmpty()) {
			stack.push(operatorStack.pop());
		}
		
		stack.display();
	}
}
