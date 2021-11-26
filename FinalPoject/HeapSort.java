package FinalPoject;

public class HeapSort<T> {
	public void swap (T[] a, T ptr1, T ptr2) {
		T t = a[ptr1];
		a[ptr1] = a[ptr2];
		a[ptr2] = t;
	}
	
	public void downHeap(T[] a, T left, T right) {
		T temp = a[left];
		T parent;
		T child;
		
		for (parent = left; parent < (right + 1) / 2; parent = child) {
			int chl = parent * 2 + 1;
			int chr = chl + 1;
			child = (chr <= right && a[chr] > a[chl]) ? chr: chl;
			if (temp >= a[child])
				break;
			a[parent] = a[child];
		}
		a[parent] = temp;
	}
	
	public void Heapsort(T[] a, T n) {
		for (int i = (n - 1) / 2; i >= 0; i--)
			downHeap(a, i, n - 1);
		
		for (int i = n - 1; i > 0; i--) {
			swap(a, 0, i);
			downHeap(a, 0, i - 1);
		}
	}

}
