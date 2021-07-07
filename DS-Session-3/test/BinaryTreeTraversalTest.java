package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.java.util.BinaryTree;
import main.java.util.BinaryTreeTraversal;

/**
 * This class is to test the implementation of BinaryTreeTraversal class
 * @author Satyam Bhadoria
 *
 */
public class BinaryTreeTraversalTest {

	private BinaryTree<String> node;
	private String[] array = new String[] {"2", "4", "6", "3"};
	private BinaryTreeTraversal<String> traverse;
	
	/**
	 * initiating objects 
	 */
	@Before
	public void inititate() {
		node = new BinaryTree<>();
		node = node.createBinaryTree(array);
		traverse = new BinaryTreeTraversal<>();
	}
	
	/**
	 * method to test preOrder method
	 */
	@Test
	public void testPreOrder() {
		String expected = "2436";
		assertEquals(expected, traverse.preOrder(node));
	}
	
	/**
	 * method to test postOrder method
	 */
	@Test
	public void testPostOrder() {
		String expected = "3462";
		assertEquals(expected, traverse.postOrder(node));
	}
	
	/**
	 * method to test inOrder method
	 */
	@Test
	public void testInOrder() {
		String expected = "3426";
		assertEquals(expected, traverse.inOrder(node));
	}
	
	/**
	 * method to test isBinaryTreeMirror method for checking of mirror equality of two binary trees
	 */
	@Test
	public void testIsBinaryTreeMirrorEqual() {
		BinaryTree<String> root = new BinaryTree<>("2");
		BinaryTree<String> left = new BinaryTree<>("6");
		BinaryTree<String> right = new BinaryTree<>("4");
		BinaryTree<String> rightRight = new BinaryTree<>("3");
		root.setLeft(left);
		root.setRight(right);
		right.setRight(rightRight);
		assertTrue(traverse.isBinaryTreeMirrorEqual(node, root));
		
	}

	/**
	 * method to test createBinaryTree method for getting exception
	 */
	@Test(expected = ArithmeticException.class)
	public void testCreateBinaryTree() {
		String[] arr = new String[] {};
		BinaryTree<String> b = node.createBinaryTree(arr);
	}
}
