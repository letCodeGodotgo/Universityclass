import java.io.*;
import java.util.ArrayList;

public class CS401ArrayImpl {
	public static void main (String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		System.out.println("Enter your 'Employees.txt' file address: ");
//		File path = new File(br.readLine());
//		BufferedReader file = new BufferedReader(new FileReader(path));
		
		File file = new File("C:\\남규\\IIT\\Fall 2021\\CS 401\\Employees.txt");
		
		//Read file
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		ArrayCollect array = new ArrayCollect();
		
		System.out.println(array.size());
		
		for (int i = 0; i < 15; i++) {
			String text = br.readLine();
			array.add(text);
			if(array.isFull()) array.increase(array.elements);
		}
		System.out.println(array.size());
		array.dump();
		
	}

}
