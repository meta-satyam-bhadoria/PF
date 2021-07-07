package main.java.util;

/**
 * This class is used to convert infix expression into postfix expression
 * @author satyam bhadoria
 *
 */
public class InfixToPostfix {
	private Stack<Character> operatorStack;
	private String postFix;
	private Priority priority;
	
	/**
	 * constructor
	 */
	public InfixToPostfix() {
		operatorStack = new Stack<>();
        postFix = "";
		priority = new Priority();
	}
	
        /**
         * method to convert infix expression to post fix expression
         * @param infixExpr - infix expression
         */
	public String convertToPostfix(String infixExpr) {
        boolean flagForRepeatedOperator = false;
        char[] infixExpression = infixExpr.toCharArray();
        int index = 0;
        int length = infixExpr.length();
        
        while(length > 0) {
                length--;
                
                if(infixExpression[index] == ' ') {
                    index++;
                    continue;
                } else if(infixExpression[index] == '(') {
                    operatorStack.push(infixExpression[index]);

                } else if( infixExpression[index] == ')' ) {
                	
                    while( operatorStack.peek() != '(' ) {
                        postFix += operatorStack.pop();
                    }
                    operatorStack.pop();
                    
                } else if( !priority.isContain(infixExpression[index]) ) {
                    postFix += infixExpression[index];
                    flagForRepeatedOperator = true;

                } else {
                	
                    if(!flagForRepeatedOperator) {
                        throw new ArithmeticException("Invalid infix expression");
                        
                    } else if( !operatorStack.isEmpty() && priority.getPriority( operatorStack.peek() ) > priority.getPriority( infixExpression[index]) ) {
                        
                        while(!operatorStack.isEmpty() && priority.getPriority( operatorStack.peek() ) > priority.getPriority( infixExpression[index])) {
                            postFix += operatorStack.pop();
                        }
                        operatorStack.push(infixExpression[index]);

                    } else {
                        operatorStack.push(infixExpression[index]);
                    }
                    flagForRepeatedOperator = false;
                }
                index++;
        }
        
        /*appending remaining operator in stack to postfix expression*/
        while(!operatorStack.isEmpty()) {
            postFix += operatorStack.pop();
        }

        return postFix;
	}
}
