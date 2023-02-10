import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public abstract class GenericList<T> implements Iterable<T> {
	class Node<T> {
		private T data;
		private Node<T> next;
		private Node<T> prev;
		
		public Node(T val) {
			data = val;
			next = null;
			prev = null;
		}
		
		public T getData() {
			return data;
		}

		public void setData(T element) {
			data = element;
		}
		
		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> node) {
			next = node;
		}
		
		public Node<T> getPrev() {
			return prev;
		}
		
		public void setPrev(Node<T> node) {
			prev = node;
		}
	}
	
	private Node<T> head = null;
	private int length = 0;
	
	public void print() {
		if (this.head == null) {
			// List is empty
			System.out.println("Empty List");
			return;
		}
		Node<T> cur = this.head;
		while (cur != null) {
			System.out.println(cur.data);
			cur = cur.next;
		}
	}
	
	abstract public void add(T data);
	
	public T delete() {
		// set head to the next node after the current head
		if (this.head == null) {
			return null;
		}
		T temp = this.head.data;
		if (this.head.next == null) {
			this.head = null;
		} else {
			this.head = this.head.next;
			this.head.prev = null;
		}
		this.length--;
		return temp;
	}
	
	public ArrayList<T> dumpList() {
		// until next node is null, add node to new array list, return it
		ArrayList<T> dumpArray = new ArrayList<>();
		while (this.head != null) {
			dumpArray.add(this.head.data);
			this.head = this.head.next;
			this.length--;
		}
		return dumpArray;
	}
	
	public T get(int index) {
		// check for out of bounds, if yes return null
		// if not, range loop for node at index and return data from node
		if (index >= 0 && index < this.length) {
			Node<T> cur = this.head;
			int i = 0;
			for (; i < index; i++) {
				cur = cur.next;
			}
			return cur.data;
		}
		return null;
	}
	
	public T set(int index, T element) {
		// check for out of bounds, if yes return null
		// if not, range loop for node at index, use node setter to replace value
		// return old value in temp variable
		if (index >= 0 && index < this.length) {
			Node<T> cur = this.head;
			int i = 0;
			for (; i < index; i++) {
				cur = cur.next;
			}
			T oldData = cur.data;
			cur.setData(element);
			return oldData;
		}
		return null;
	}
	
	public int getLength() {
		// return length private data member
		return this.length;
	}
	
	public void setLength(int newlength) {
		this.length = newlength;
	}
	
	public Node<T> getHead() {
		// return head private data member
		return this.head;
	}
	
	public void setHead(Node<T> newHead) {
		// set the private data member to new head
		this.head = newHead;
	}
	
	public ListIterator<T> listIterator(int index) {
		if (index >= 0 && index < this.length) {
			Node<T> cur = this.head;
			int i = 0;
			for (; i < index; i++) {
				cur = cur.next;
			}
			GLListIterator<T> listIter = new GLListIterator<>(cur, index);
			return listIter;
		}
		return null;
	}
	
	public Iterator<T> iterator() {
		GLLIterator<T> iter = new GLLIterator<>(this.head);
		return iter;
	}
	
	public Iterator<T> descendingIterator() {
		Node<T> cur = this.head;
		while (cur.next != null) {
			cur = cur.next;
		}
		ReverseGLLIterator<T> revIter = new ReverseGLLIterator<>(cur);
		return revIter;
	}
}
