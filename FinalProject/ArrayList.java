package FinalProject;

import java.util.*;

public class ArrayList<T> {					//O(N)
	protected final int capa = 36;
	protected String[] elements;
	protected int numElem = 0;
	protected int front = 0;
	protected boolean found;
	protected int locat;
	
	public ArrayList() {
		elements = new String[capa];
	}
	
	public ArrayList(int capac) {
		elements = new String[capac];
	}
	
	public int indexOf(Object value) {		//O(N)
		int i = 0;
		for (i = 0; i < numElem; i++) {
			if (elements[i].equals(value))
				return i;
		}
		
		return -1;
	}
	
	public int lastIndexOf(Object value) {
		for (int i = numElem - 1; i >= 0; i--) {
			if (elements[i].equals(value))
				return i;
		}
		return -1;
	}
	
	public boolean add(String element) {		//O(1)
		addLast(element);
		return true;
	}
	
	public void addLast(String element) {		//O(1)
		if (isFull()) resize();
		
		elements[numElem] = element;
		numElem++;
	}
	
	public void add(int index, String element) {	//O(N)
		if (index > numElem || index < 0)
			throw new IndexOutOfBoundsException();
		
		if (index == numElem)
			addLast(element);
		else {
			if (numElem == elements.length)
				resize();
		}
		
		for (int i = numElem; i > index; i--)
			elements[i] = elements[i - 1];
		
		elements[index] = element;
		numElem++;
	}
	
	private void resize() {							//O(1)
		int elements_capacity = elements.length;
		
		if (Arrays.equals(elements, null)) {
			elements = new String[capa];
			return;
		}
		
		if (numElem == elements_capacity) {
			int new_capacity = elements_capacity * 2;
			elements = Arrays.copyOf(elements, new_capacity);
			return;
		}
		
		if (numElem < (elements_capacity / 2)) {
			int new_capacity = elements_capacity / 2;
			elements = Arrays.copyOf(elements, Math.max(new_capacity, capa));
			return;
		}
	}
	
	public boolean remove (String target) {				//O(N)
		indexOf(target);
		if (found) {
			elements[locat] = elements[numElem - 1];
			elements[numElem - 1] = null;
			numElem--;
		}
		return found;
	}
	
	public boolean contains(Object value) {		//O(1)
		if (indexOf(value) >= 0) {
			System.out.println("Found");
			return true;
		}
		else {
			System.out.println("Not Found");
			return false;
		}
	}
	
	public String get(String target) {			//O(1)
		indexOf(target);
		if (found) return elements[locat];
		else return null;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T[] toArray(T[] a) {				//O(1)
		if (a.length < numElem)
			return (T[]) Arrays.copyOf(elements,  numElem, a.getClass());
		System.arraycopy(elements,  0,  a,  0,  numElem);;
		return a;
	}
	
	public void sort() {
		sortList();
	}
	
	public void sortList() {					//O(1)
		String[] a = this.toArray(elements);
		HeapSort.sort(a);
	}
	
	public boolean isFull() {
		return (numElem == elements.length);
	}
	
	public boolean isEmpty() {
		return (numElem == 0);
	}
	
	public int size() { return numElem;}
	
	public void dump() {						//O(N)
		for (int i = 0; i < numElem; i++) 
			System.out.print(elements[(i + front) % elements.length] + "\n");
		System.out.println();
		
	}



}