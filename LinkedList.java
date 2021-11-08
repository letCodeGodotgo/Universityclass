import java.util.*;

public class LinkedList<T> {
	class Node<T> {
		private T data;
		private Node<T> next;
		
		Node (T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
	}
	
	T[] elements;
	private Node<T> head;
	private Node<T> currt;
	
	public LinkedList() {
		head = currt = null;
	}
	
	public T search(T obj, Comparator<? super T> c) {
		Node<T> ptr = head;
		
		while (ptr != null) {
			if (c.compare(obj,  ptr.data)== 0) {
				currt = ptr;
				return ptr.data;
			}
			
			ptr = ptr.next;
		}
		
		return null;
	}
	
	public void addFront(T obj) {
		Node<T> ptr = head;
		head = currt = new Node<T> (obj, ptr);
	}
	
	public void addEnd(T obj) {
		if (head == null) addFront(obj);
		else {
			Node<T> ptr = head;
			while (ptr.next != null) ptr = ptr.next;
			ptr.next = currt = new Node<T> (obj, null);
		}
	}
	
	public void removeFront() {
		if (head != null) 
			head = currt = head.next;
	}
	
	public void removeEnd() {
		if (head != null) {
			if (head.next == null) removeFront();
			else {
				Node<T> ptr = head;
				Node<T> pre = head;
				
				while (ptr.next != null) {
					pre = ptr;
					ptr = ptr.next;
				}
				
				pre.next = null;
				currt = pre;
			}
		}
	}
	
	public void remove(Node p) {
		if(head != null) {
			if(p == head) removeFront();
			else {
				Node<T> ptr = head;
				
				while (ptr.next != p) {
					ptr = ptr.next;
					if (ptr == null) return;
				}
				ptr.next = p.next;
				currt = ptr;
			}
		}
	}
	
	public void removeSelect() {
		remove(currt);
	}
	
	public void clear() {
		while (head != null) removeFront();
		currt = null;
	}
	
	public boolean next() {
		if (currt == null || currt.next == null)
			return false;
		currt = currt.next;
		return true;
	}
	
	public void printSelect() {
		if (currt == null)
			System.out.println("There is no selected Node");
		else System.out.println(currt.data);
	}
	
	public void sortList() {
		Node currt = null, ptr = null;
		Object temp;
		
		if (head == null) return;
		
		else {
			for(currt = head; currt.next != null; currt = currt.next) {
				for(ptr = currt.next; ptr != null; ptr = ptr.next) {
					if(((String) currt.data).compareTo((String) ptr.data) > 0) {
						temp = currt.data;
						currt.data = ptr.data;
						ptr.data = temp;
					}
				}
			}
		}
	}
	
	public Object[] toArray() {
		Object[] array = new Object[size];
		int idx = 0;
		for (Node<T> x = head; x !=null; x = x.next) {
			array[idx++] = (T) x.data;
		}
		return array;
	}
	
	public void dump() {
		Node<T> ptr = head;
		
		while (ptr != null) {
			System.out.println(ptr.data);
			ptr = ptr.next;
		}
	}
	
	

}
