package test;

import static org.junit.Assert.*;
import main.java.util.InfixToPostfix;

import org.junit.Before;
import org.junit.Test;

/**
 * This class is used to test the InfixToPostfix class implementation
 * @author Satyam Bhadoria
 *
 */
public class InfixToPostfixTest {

	private InfixToPostfix infixExpression;
	
	/**
	 * method to instantiate the object of InfixToPostfix class
	 */
	@Before
	public void initiateInstance() {
		infixExpression = new InfixToPostfix();
	}
	/**
	 * method to test convertToPostfix method for succesful converting to postfix expression
	 */
	@Test
	public void testConvertToPostfix() {
		String infixExpr = "a + b * c / ( d + e)";
		String postfixExpr = "abcde+/*+";
		assertEquals(postfixExpr, infixExpression.convertToPostfix(infixExpr));
	}
	
	/**
	 * method to test convertToPostfix method to generate Arithmetic expression exception
	 */
	@Test(expected = ArithmeticException.class)
	public void testConvertToPostfixForException() {
		String infixExpr = "a + b * c / ( d +* e)";
		String postfixExpr = "abcde+/*+";
		assertEquals(postfixExpr, infixExpression.convertToPostfix(infixExpr));
	}

}
