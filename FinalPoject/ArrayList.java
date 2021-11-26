package FinalPoject;

public class ArrayList<T> {
	protected final int capa = 10;
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
	
	protected void find(String target) {
		locat = 0;
		found = false;
		while (locat < numElem) {
			if(elements[locat].equals(target)) {
				found = true;
				return;
			}
			else locat++;
		}
	}
	
	public void add(String element) {
		if (isFull()) return;
		else {
			elements[numElem] = element;
//			increase(elements);
			numElem++;
			
		}
	}
	
	public boolean contains(String target) {
		find(target);
		return found;
	}
	
	public String get(String target) {
		find(target);
		if (found) return elements[locat];
		else return null;
	}
	
	public boolean isFull() {
		return (numElem == elements.length);
	}
	
	public boolean isEmpty() {
		return (numElem == 0);
	}
	
	public int size() { return numElem;}
	
	public String[] increase(String[] arr) {
		arr = elements[elements.length + 2];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i];
		}
		return newArr;
	}
	
	public void dump() {
		for (int i = 0; i < numElem; i++) 
			System.out.print(elements[(i + front) % elements.length] + " ");
		System.out.println();
		
	}



}
