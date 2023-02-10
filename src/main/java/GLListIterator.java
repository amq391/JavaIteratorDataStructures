import java.util.ListIterator;

public class GLListIterator<T> implements ListIterator<T> {
	private GenericList<T>.Node<T> cur;
	private int index;
	
	public GLListIterator(GenericList<T>.Node<T> node, int ind) {
		cur = node;
		index = ind;
	}

	@Override
	public boolean hasNext() {
		if (cur == null) {
			return false;
		}
		return true;
	}

	@Override
	public T next() {
		T temp = cur.getData();
		cur = cur.getNext();
		return temp;
	}

	@Override
	public boolean hasPrevious() {
		if (cur != null) {
			return true;
		}
		return false;
	}

	@Override
	public T previous() {
		T temp = cur.getPrev().getData();
		cur = cur.getPrev();
		return temp;
	}

	@Override
	public int nextIndex() {
		return index + 1;
	}

	@Override
	public int previousIndex() {
		return index - 1;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void set(T e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(T e) {
		// TODO Auto-generated method stub
		
	}

}
