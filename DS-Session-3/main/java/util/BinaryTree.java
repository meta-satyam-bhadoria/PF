package main.java.util;

/**
 * This class behaves as a node
 * @author Satyam Bhadoria
 *
 * @param <T> - generic parameter
 */
public class BinaryTree<T> {
	private T data;
	private BinaryTree<T> leftChild;
	private BinaryTree<T> rightChild;
	
	/**
	 * constructor
	 * @param data - data in the node
	 */
	public BinaryTree(T data) {
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
	}
	
	/**
	 * constructor
	 */
	public BinaryTree() {
		this.leftChild = null;
		this.rightChild = null;
	}

	/**
	 * getter to get data from node
	 * @return data
	 */
	public T getData() {
		return data;
	}

	/**
	 * setter to set data in the node
	 * @param data - data for node
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * getter to get left child of the node
	 * @return letf child
	 */
	public BinaryTree<T> getLeft() {
		return leftChild;
	}

	/**
	 * setter to set left child of the node
	 * @param right - left child
	 */
	public void setRight(BinaryTree<T> right) {
		this.rightChild = right;
	}

	/**
	 * getter to get right child of the node
	 * @return right child
	 */
	public BinaryTree<T> getRight() {
		return rightChild;
	}

	/**
	 * setter to set right child of the node
	 * @param left - right child
	 */
	public void setLeft(BinaryTree<T> left) {
		this.leftChild = left;
	}
	
	/**
	 * method to create binary tree using an array in left ot right
	 * @param array - given array
	 * @return root node of created tree
	 */
	public BinaryTree<T> createBinaryTree(T[] array) {
		
		if(array.length == 0) {
			throw new ArithmeticException("Empty array passed");
		}
		return createBinaryTree(array, 0);
	}
	
	/**
	 * method to create binary tree using an array in left ot right
	 * @param array - given array
	 * @param i - index for creating node
	 * @return root node for passed array
	 */
	private BinaryTree<T> createBinaryTree(T[] array, int i) {
		BinaryTree<T> node = new BinaryTree<>(array[i]);
		
		if(array.length > (i * 2) + 1) {
			node.setLeft( createBinaryTree(array, (i * 2) + 1) );
		}
		
		if(array.length > (i * 2) + 2) {
			node.setRight( createBinaryTree(array, (i * 2) + 2) );
		}
		return node;
	}
} 
