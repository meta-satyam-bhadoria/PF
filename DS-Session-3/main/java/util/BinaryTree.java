package main.java.util;

/**
 * This class behaves as a node
 * @author Satya Bhadoria
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
	 * method to add node in a binary tree with the logic left subtree contain data smaller than parent and
	 * right subtree contain data larger than parent node
	 * @param node - node to be added
	 */
	public void addToBinaryTree(BinaryTree<T> node) {
		
		if( (node.getData().toString().compareTo( this.data.toString() ) > 0) ) {
			
			if(this.rightChild == null) {
				this.rightChild = node;
				
			} else{
				this.rightChild.addToBinaryTree(node);
			}
		} else {
			
			if(this.leftChild == null) {
				this.leftChild = node;
				
			} else {
				this.leftChild.addToBinaryTree(node);
			}
		}
	}
	
	
	public BinaryTree<T> createBinaryTree(T[] array) {
		
		if(array.length == 0) {
			throw new ArithmeticException("Empty array passed");
		}
		return createBinaryTree(array, 0);
	}
	
	
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
	
	public void appendNodeToBinaryTree(BinaryTree<T> node) {
		
		
	}
	
	
	private void searchForApend() {
		if(this.rightChild != null) {
			this.rightChild.searchForApend();
		}
		
		if(this.leftChild == null) {
			
		}
	}
} 
