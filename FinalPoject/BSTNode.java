package FinalPoject;

public class BSTNode<T> {
	private T key;
	private T data;
	private BSTNode<T> left;
	private BSTNode<T> right;
	
	//Constructor
	public BSTNode(T key) {
		this.key = key;
		//data = data;
		left = null;
		right = null;
	}
	
	public void setKey (T key) {
		this.key = key;
	}
	
	public T getKey() {
		return key;
	}
	
	public void setData (T data) {
		this.data = data;
	}
	
	public T getData() {
		return data;
	}
	
	public void setLeft (BSTNode<T> link) {
		left = link;
	}
	
	public void setRight (BSTNode<T> link) {
		right = link;
	}
	
	public BSTNode<T> getLeft() {
		return left;
	}
	
	public BSTNode<T> getRight() {
		return right;
	}
	
	void print() {
		System.out.println(data);
	}

}