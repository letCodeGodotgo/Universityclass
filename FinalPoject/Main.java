package FinalPoject;

import java.io.*;

public class Main {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\NamGyu Lee\\Coustomer.txt"));
		LinkedList<Integer> list = new LinkedList<>();
		
		try {
			while(br.ready()) {
				int text = Integer.parseInt(br.readLine());
				list.addEnd(text);
				HeapSort(list, text);
			}
		} catch (IOException e) {
			
		}
		
		HeapSort(list);
	}

}
