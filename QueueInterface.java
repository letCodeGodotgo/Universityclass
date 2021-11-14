public interface QueueInterface<T> {
	void enqueue (T element) throws QueueOverflowException1;
	
	T dequeue() throws QueueUnderflowException1;
	
	boolean isFull();
	
	boolean isEmpty();
	
	int size();

}
