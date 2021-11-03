import java.util.*;

public class Lab7_part2 {
	public static int convert (char c) {
		switch (c) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		}
		
		return -1;
	}
	
	public static String inPost (String expression) {
		String result = "";
		ArrayStack<Character> stack = new ArrayStack<>();
		
		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);
			
			if (convert(c) > 0) {
				while(stack.isEmpty() == false && convert(stack.top()) >= convert(c)) {
					result = stack.pop();
				}
			}
		}
	}
	
	public static int calculate(String expression) {
		Scanner tokenizer = new Scanner(expression);
		ArrayStack<Integer> stack = new ArrayStack<Integer>();
		
		int val;
		String operator;
		int oper1, oper2;
		int result = 0;
		
		
		while (tokenizer.hasNext()) {
			if (tokenizer.hasNextInt()) {
				val = tokenizer.nextInt();
				stack.push(val);
			}
			
			else {
				operator = tokenizer.next();

				oper1 = stack.top();
				stack.pop();
				
				oper2 = stack.top();
				stack.pop();
				
				if(operator.equals("/"))
					result = oper1/oper2;
				else if(operator.equals("*"))
					result = oper1 * oper2;
				else if (operator.equals("+"))
					result = oper1 + oper2;
				else if (operator.equals("-"))
					result = oper1 - oper2;
				
				stack.push(result);
			}
		}
		
		result = stack.top();
		stack.pop();
		
		return result;
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		String expression = null;
		final String STOP = "X";
		int result;
		
		while(!STOP.equals(expression)) {
			System.out.println("\nPostfix Expression (" + STOP + "to stop): ");
			expression = sc.nextLine();
			
			if (!STOP.equals(expression)) {
				try {
					result = Lab7_part2.calculate(expression);
					System.out.println("Result = " + result);
				} catch(Exception e) {
					
				}
			}
		}
	}

}
