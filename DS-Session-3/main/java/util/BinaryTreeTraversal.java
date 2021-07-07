package main.java.util;

/**
 * This class implements the binary tree containing methods pre-order and post-order
 * @author Satyam Bhadoria
 *
 * @param <T> - generic parameter
 */
public class BinaryTreeTraversal<T> {
	
	/**
	 * method to return the pre-order traversal of binary tree
	 * @param node - binary tree's node
	 * @return pre-order
	 */
	public String preOrder(BinaryTree<T> node) {
		String preOrder = "";
		
		if(node != null) {
			preOrder += node.getData().toString();
			preOrder += preOrder(node.getLeft());
			preOrder += preOrder(node.getRight());
			
		}
		return preOrder;
	}
	
	/**
	 * method to return the post-order traversal of binary tree
	 * @param node - binary tree's root node
	 * @return post-order
	 */
	public String postOrder(BinaryTree<T> node) {
		String postOrder = "";
		
		if(node != null) {
			postOrder += postOrder(node.getLeft());
			postOrder += postOrder(node.getRight());
			postOrder += node.getData().toString();
		}
		return postOrder;
	}
	
	/**
	 * method to return the in-order traversal of binary tree
	 * @param node - binary tree's root node
	 * @return in-order
	 */
	public String inOrder(BinaryTree<T> node) {
		String inOrder = "";
		
		if(node != null) {
			inOrder += inOrder(node.getLeft());
			inOrder += node.getData().toString();
			inOrder += inOrder(node.getRight());
		}
		return inOrder;
	}
	
	/**
	 * method to check whether two given binary trees are mirror equal
	 * @param firstTreeNode - first binary tree's node
	 * @param secondTreeNode - second binary tree's node
	 * @return true or false
	 */
	public boolean isBinaryTreeMirrorEqual(BinaryTree<T> firstTreeNode, BinaryTree<T> secondTreeNode) {
		boolean isEqual = false;
		
		if(firstTreeNode != null && secondTreeNode != null) {
			if( isBinaryTreeMirrorEqual(firstTreeNode.getLeft(), secondTreeNode.getRight())) {
				if(isBinaryTreeMirrorEqual(firstTreeNode.getRight(), secondTreeNode.getLeft())) {
					isEqual = firstTreeNode.getData() == secondTreeNode.getData();
				}
			}
		} 
		return (firstTreeNode == null && secondTreeNode == null) || isEqual;
	}
}
