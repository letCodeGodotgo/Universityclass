import java.io.*;

public class Lab7 {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		empCollection emp = new empCollection(); 
		
		// Get 'Employees.txt' file address from user
		System.out.println("Enter your 'Employees.txt' file address: ");
		String fileAddre = br.readLine();
		
		BufferedReader file = new BufferedReader(new FileReader(fileAddre));

		try {
			while(file.ready()) {
				String text = file.readLine();
				emp.add(text);
			}
		} catch (IOException e) {
			
		}
		String[] empList = emp.elements;
		
		
		emp.dump();
		emp.selectionSort(empList);
		
	}

}
