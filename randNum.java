import java.io.*;
import java.util.*;

public class randNum {
	public static void main (String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("Random Number.txt", true));
		
		BST<Integer> bst = new BST<>();
		int max = 2000;
		int randNum[] = new int[max];
		
		
		for (int i = 0; i < max; i++) {
			int num = (int)(Math.random() * 20000) + 1;
			randNum[i] = num;
			for (int j = 0; j < i; j++) {
				if (randNum[i] == randNum[j]) {
					i--;
					break;
				}
			}
			bst.add(randNum[i]);
			
//			System.out.print(randNum[i] + " ");
			
//			bw.write(randNum[i] + " ");
//			bw.newLine();
		}
//		bw.close();
		
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
