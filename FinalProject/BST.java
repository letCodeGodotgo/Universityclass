package FinalProject;

import java.util.*;

public class BST<T> {						//O(log n)
	private BSTNode<T> root;
	private Comparator<? super T> comparator = null;
	
	public BST() {
		root = null;
	}
	
	public BST(Comparator<? super T> c) {
		this();
		comparator = c;
	}
	
	//Compare two keys
	@SuppressWarnings("unchecked")
	private int compa(T key1, T key2) {
		return (comparator == null) ? ((Comparable<T>)key1).compareTo(key2)
				: comparator.compare(key1, key2);
	}
	
	//Search with 'key'
	public T search(T key) {				//O(log n)
		BSTNode<T> ptr = root;
		while (true) {
			if(ptr == null)
				return null;
			//Compare key and key of pointer
			int cond = compa(key, ptr.getKey());
			if (cond == 0)
				return ptr.getData();
			// If key is smaller, then search in left subtree
			else if (cond < 0)
				ptr = ptr.getLeft();
			//If key is bigger, search in right subtree
			else
				ptr = ptr.getRight();
		}
	}
	
	// Add Node T to subtree
	private void addNode (BSTNode<T> node, T key) {
		int cond = compa(key, node.getKey());
		if (cond == 0)
			return;
		else if (cond < 0) {
			if (node.getLeft() == null)
				node.setLeft(new BSTNode<T>(key));
			else
				addNode(node.getLeft(), key);
		}
		else {
			if (node.getRight() == null)
				node.setRight(new BSTNode<T>(key));
			else
				addNode(node.getRight(), key);
		}
	}
	
	// Add Node
	public void add(T key) {				//O(log n)
		if(root == null)
			root = new BSTNode<T>(key);
		else
			addNode(root, key);
	}
	
	//Calculate size of the tree with recursive method
	public int recSize() {
		return recSize(root);
	}

	public int recSize(BSTNode<T> node) {
		if (node == null)
			return 0;
		else
			return 1 + recSize(node.getLeft()) + recSize(node.getRight());
	}

	//Calculate size of the tree with iterative method
//	public int iterSize() {
//		int count = 0;
//		if (root != null) {
//			ArrayStack<BSTNode<T>> nodeStack = new ArrayStack<BSTNode<T>>();
//			BSTNode<T> currNode;
//			nodeStack.push(root);;
//			while (!nodeStack.isEmpty()) {
//				currNode = nodeStack.top();
//				nodeStack.pop();
//				count++;
//				
//				if(currNode.getLeft() != null)
//					nodeStack.push(currNode.getLeft());
//				if(currNode.getRight() != null)
//					nodeStack.push(currNode.getRight());
//			}
//		}
//		return count;
//	}
	
	//Find maximum depth of the tree
	public int maxDepth() {
		return findDepth(root, 0);
	}
	
	public int findDepth(BSTNode<T> node, int depth) {
		if (node == null)
			return depth;
		return Math.max(findDepth(node.getLeft(), depth + 1),  findDepth(node.getRight(), depth + 1));
	}
	
	//Print traversal of tree with three different methods
	public void Inorder() {
		Inorder(root);
	}
	public void Postorder() {
		Postorder(root);
	}
	public void Preorder() {
		Preorder(root);
	}
	
	
	private void Inorder(BSTNode<T> node) {
		if (node != null) {
			Inorder(node.getLeft());
			System.out.print(node.getKey() + " ");
			Inorder(node.getRight());
		}
	}
	
	private void Postorder(BSTNode<T> node) {
		if (node != null) {
			Postorder(node.getLeft());
			Postorder(node.getRight());
			System.out.print(node.getKey() + " ");
		}
	}
	
	private void Preorder(BSTNode<T> node) {
		if(node != null) {
			System.out.print(node.getKey() + " ");
			Preorder(node.getLeft());
			Preorder(node.getRight());
		}
	}
}