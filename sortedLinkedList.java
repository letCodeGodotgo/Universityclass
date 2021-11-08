import java.io.*;
import java.util.*;

public class sortedLinkedList {
	public static void main (String[] args) throws IOException {
		LinkedList<String> list = new LinkedList<String>();
		list.toArray();
		
//		String[][] empData;
//		String emp;
		
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\NamGyu Lee\\Employees.txt"));

		try {
			while(br.ready()) {
				String text = br.readLine();
				list.addEnd(text);
			}
		} catch (IOException e) {
			
		}
		
		list.dump();
		list.sortList();
		System.out.println("\nSorted list:\n");
		list.dump();
		
//		String[] emp = list.elements;
//		String[] name = emp.split(" ");
//		String[] ID = emp.split(" ");
//		
//		empData = new String[name.length][ID.length];
//		System.out.println(empData);
//		empData.dump();

//		while (br.readLine() != null) {
//			
//		}
	}

}
