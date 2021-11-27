package FinalPoject;

public class HeapSort {
	public static void sort (int[] a) { sort (a, a.length);}
	
	private static void sort(int[] a, int size) {
		if(size < 2)
			return;
		
		int parentIdx = getParent(size - 1);
		
		for(int i = parentIdx; i >= 0; i--)
			heap(a, i, size - 1);
		
		for (int i = size - 1; i > 0; i--) {
			swap(a, 0, i);
			heap(a, 0, i - 1);
		}
	}
	
	private static int getParent (int child) {
		return (child - 1) / 2;
	}
	
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	private static void heap (int[] a, int parentIdx, int lastIdx) {
		int leChIdx = 2 * parentIdx + 1;	//Left Child index
		int riChIdx = 2 * parentIdx + 2;	// Right Child index
		int largIdx = parentIdx;	//Largest index
		
		//compare left child node
		if (leChIdx <= lastIdx && a[largIdx] < a[leChIdx])
			largIdx = leChIdx;
		
		// compare right child node
		if (riChIdx <= lastIdx && a[largIdx] < a[riChIdx])
			largIdx = riChIdx;
		
		if (parentIdx != largIdx) {
			swap(a, largIdx, parentIdx);
			heap(a, largIdx, lastIdx);
		}
	}

}
