import java.util.Iterator;

public class GenericQueue<T> extends GenericList<T> {
	private Node<T> tail = null;
	
	public GenericQueue(T val) {
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
		tail.setNext(null);
		setLength(getLength() - 1);
		return oldTail;
	}

	@Override
	public void add(T data) {
		Node<T> newNode = new Node<T>(data);
		if (tail == null) {
			setHead(newNode);
			tail = newNode;
		} else {
			tail.setNext(newNode);
			newNode.setPrev(tail);
			tail = newNode;
		}
		setLength(getLength() + 1);
	}
	
	public void enqueue(T data) {
		add(data);
	}
	
    public T dequeue() {
		return delete();
	}
}
