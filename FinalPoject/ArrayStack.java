package FinalPoject;

import java.util.*;

public class ArrayStack<T> {
	protected ArrayList<T> elements;
	
	public ArrayStack() {
		elements = new ArrayList<T>();
	}
	
	public void push(T element) {
		elements.add(element);
	}
	
	public T pop() {
		T pop = elements.remove(elements.size() -1);
		return pop;
	}
	
	public T top() {
		T topOfStack = null;
		topOfStack = elements.get(elements.size() -1);
		return topOfStack;
	}
	
	public boolean isEmpty() {
		return (elements.size() == 0);
	}

}
