import java.util.Iterator;

public class GLLIterator<T> implements Iterator<T> {
	private GenericList<T>.Node<T> cur;

	public GLLIterator(GenericList<T>.Node<T> node) {
		cur = node;
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

}
