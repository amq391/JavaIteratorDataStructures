import java.util.Iterator;

public class GenericStack<T> extends GenericList<T> {
	private Node<T> tail = null;

	public GenericStack(T val) {
		Node<T> newHead = new Node<T>(val);
		setHead(newHead);
		tail = newHead;
		setLength(getLength() + 1);
	}
	
	public T removeTail() {
		T oldTail = tail.getData();
		if (tail.getPrev() == null) {
			return delete();
		}
		tail = tail.getPrev();
		setLength(getLength() - 1);
		return oldTail;
	}

	@Override
	public void add(T data) {
		Node<T> newNode = new Node<T>(data);
		if (getHead() == null) {
			setHead(newNode);
			tail = newNode;
		} else {
			getHead().setPrev(newNode);
			newNode.setNext(getHead());
			setHead(newNode);
		}
		setLength(getLength() + 1);
	}
	
	public void push(T data) {
		add(data);
	}
	
	public T pop() {
		return delete();
	}

}
