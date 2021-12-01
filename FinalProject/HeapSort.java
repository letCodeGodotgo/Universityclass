package FinalProject;

public class HeapSort {				//O(nlogn)
	public static void sort (String[] a) { sort (a, a.length);}
	
	public static void sort(String[] a, int size) {
		if(size < 2)
			return;
		
		int parentIdx = getParent(size - 1);
		
		for(int i = parentIdx; i >= 0; i--)
			heapify(a, i, size - 1);
		
		for (int i = size - 1; i > 0; i--) {
			swap(a, 0, i);
			heapify(a, 0, i - 1);
		}
	}
	
	private static int getParent (int child) {
		return (child - 1) / 2;
	}
	
	private static void swap(String[] a, int i, int j) {
		String temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	private static void heapify (String[] a, int parentIdx, int lastIdx) {
		int leftChild;
		int rightChild;
		int largest;
		
		while((parentIdx * 2) + 1 <= lastIdx) {
			leftChild = (parentIdx * 2) + 1;
			rightChild = (parentIdx * 2) + 2;
			largest = parentIdx;
			
			if(a[leftChild].compareTo(a[largest]) > 0)
				largest = leftChild;
			
			if(rightChild <= lastIdx && a[rightChild].compareTo(a[largest]) > 0)
				largest = rightChild;
			
			if (largest != parentIdx) {
				swap(a, parentIdx, largest);
				parentIdx = largest;
			}
			else
				return;
		}
	}

}