
public class empCollection implements empCollectionInterface {
	protected final int length = 30;
	protected String[] elements;
	protected int numElement = 0;
	protected int front = 0;
	
	protected boolean found;
	protected int location;
	
	public empCollection() {
		elements = (String[]) new Object[length];
	}
	
	public empCollection(int capa) {
		elements = (String[]) new Object[capa];
	}
	
	public boolean add(String element) {
		if (isFull())
			return false;
		else {
			elements[numElement] = element;
			numElement++;
			return true;
		}
	}

	@Override
	public  Object get(String target) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(String target) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void dump() {
		for (int i = 0; i < numElement; i++) 
			System.out.print(elements[(i + front) % elements.length] + " ");
		System.out.println();
		
	}
	
	public int minIndex(int startIndex, int endIndex) {
		int indexOfMin = startIndex;
		for (int index = startIndex + 1; index <= endIndex; index++)
			if (elements[index].compareTo(elements[indexOfMin]) > 0)
				indexOfMin = index;
		return indexOfMin;
	}
	
//	public void selectionSort() {
//		int endIndex = length -1;
//		for (int current = 0; current < endIndex; current++)
//			swap(current, minIndex(current, endIndex));
//	}
	
	public void selectionSort(String[] arr) {
		int Min;
		String temp;
		
		for (int i = 0; i < arr.length - 1; i++) {
			Min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j].compareTo(arr[Min]) > 0) 
					Min = j;
			}
			
			temp = arr[Min];
			arr[Min] = arr[i];
			arr[i] = temp;
		}
	}

}
