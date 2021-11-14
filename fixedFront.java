public class fixedFront<T> implements QueueInterface<T> {
	protected final int cap = 40;
	protected T[] elements;
	protected int num = 0;
	protected int front = 0;
	protected int rear;
	
	public fixedFront() {
		elements = (T[]) new Object[cap];
		rear = cap - 1;
	}
	
	public fixedFront (int maxSize) {
		elements = (T[]) new Object[maxSize];
		rear = maxSize - 1;
	}
	
	public void enqueue (T element) throws QueueOverflowException1 {
		if (isFull())
			throw new QueueOverflowException1 ("Enqueue attempted on a full queue");
		else {
			rear = (rear + 1) % elements.length;
			elements[rear] = element;
			num = num + 1;
		}
	}
	
	public T dequeue() throws QueueUnderflowException1 {
		if (isEmpty())
			throw new QueueUnderflowException1("Dequeue attempted on empty queue");
		
		else {
			elements[front] = elements[front +1];
			front = (front + 1) % elements.length;
			
			
			return elements[front];
			
		}
	}
	
	public Object front() {
		return front;
	}
	public Object rear() {
		return rear;
	}
	
	public boolean isEmpty() {
		return num == 0;
	}
	
	public boolean isFull() {
		return num == elements.length;
	}
	
	public int size() {
		return num;
	}
	
	public void dump() throws QueueUnderflowException1 {
		if (isEmpty())
			throw new QueueUnderflowException1("Dequeue attempted on empty queue");
		
		else {
			for (int i = 0; i < num; i++) 
				System.out.print(elements[(i + front) % elements.length] + " ");
			System.out.println();
			
		}
	}



}
