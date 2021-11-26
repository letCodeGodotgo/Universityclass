
public class BSTMain {
	public static void main (String[] args) {
		BST<Integer> bst = new BST<>();
		
		bst.add(25);
		bst.add(15);
		bst.add(10);
		bst.add(4);
		bst.add(12);
		bst.add(22);
		bst.add(18);
		bst.add(24);
		bst.add(50);
		bst.add(35);
		bst.add(44);
		bst.add(70);
		bst.add(66);
		bst.add(90);
		bst.add(31);
		
		System.out.println("1. Tree's maximum depth: " + bst.maxDepth() + "\n");
		System.out.println("2. Size of the tree with Iterative method: " + bst.iterSize());
		System.out.println("Size of the tree with Recursive method: " + bst.recSize() + "\n");
		System.out.println("3. Traversal of the tree with In-order, pre-order, post-order methods");
		System.out.println("In-order traversal of the tree: ");
		bst.Inorder();
		System.out.println("\nPre-order traversal of the tree: ");
		bst.Preorder();
		System.out.println("\nPost-order traversal of the tree: ");
		bst.Postorder();
	}

}
