package FinalProject;

import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<String> Llist = new LinkedList<>();
		ArrayList<String> Alist = new ArrayList<>();
		
		double startTime, endTime;
		int choice = 1;
		
		while (choice != 0) {
			System.out.println("--------------MENU--------------");
			System.out.println("1) Sort Customer with Array List");
			System.out.println("2) Sort Customer with Linked List");
			System.out.println("3) BST with 2000 random numbers");
			System.out.println("0) stop");
			System.out.print("Select: ");
			choice = Integer.parseInt(br.readLine());
			
			switch(choice) {
			case 0:
				break;
				
			case 1:
				System.out.println("Enter your 'Customer.txt' file address: ");
				File path = new File(br.readLine());
				try {
					BufferedReader File = new BufferedReader(new FileReader(path));
					while(File.ready()) {
						String text = File.readLine();
						Alist.add(text);
					}
				} catch (IOException e) {
					
				}
				Alist.dump();
				System.out.println("Enter what you want to find: ");
				String target1 = br.readLine();
				startTime = System.nanoTime();
				Alist.contains(target1);
				endTime = System.nanoTime();
				System.out.println((endTime - startTime) + " millisecond\n");
				Alist.sort();
				System.out.println("Sorted: ");
				Alist.dump();
				System.out.println("Enter what you want to find: ");
				String target2 = br.readLine();
				startTime = System.nanoTime();
				Alist.contains(target2);
				endTime = System.nanoTime();
				System.out.println((endTime - startTime) + " millisecond\n");
				break;
				
			case 2:
				System.out.println("Enter your 'Customer.txt' file address: ");
				File path2 = new File(br.readLine());
				try {
					BufferedReader File2 = new BufferedReader(new FileReader(path2));
					while(File2.ready()) {
						String text = File2.readLine();
						Llist.addEnd(text);
					}
				} catch (IOException e) {
				
				} 
				Llist.dump();
				System.out.println("Enter what you want to find: ");
				String target3 = br.readLine();
				startTime = System.nanoTime();
				Llist.contains(target3);
				endTime = System.nanoTime();
				System.out.println("\n" + (endTime - startTime) + " millisecond\n");
				Llist.sort();
				System.out.println("Sorted: ");
				Llist.dump();
				System.out.println("Enter what you want to find: ");
				String target4 = br.readLine();
				startTime = System.nanoTime();
				Llist.contains(target4);
				endTime = System.nanoTime();
				System.out.println("\n" + (endTime - startTime) + " millisecond\n");
				break;
				
			case 3:
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
				}
				
				System.out.println("1. Tree's maximum depth: " + bst.maxDepth() + "\n");
				System.out.println("2. Size of the tree with Recursive method: " + bst.recSize() + "\n");
				System.out.println("3. Traversal of the tree with In-order, pre-order, post-order methods");
				System.out.println("In-order traversal of the tree: ");
				bst.Inorder();
				System.out.println("\nPre-order traversal of the tree: ");
				bst.Preorder();
				System.out.println("\nPost-order traversal of the tree: ");
				bst.Postorder();
				System.out.println("\n");
				break;
			default:
				System.out.println("Wrong choice!");
				break;
			}
		}

	}

}
