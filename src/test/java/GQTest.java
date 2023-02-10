import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;
import org.junit.jupiter.api.Test;

class GQTest {
	
	@Test
	void queueDeleteTest() {
		GenericQueue<String> q = new GenericQueue<>("a");
		assertEquals("a", q.delete(), "queue: delete failed");
	}
	
	@Test
	void queueDumpListTest() {
		GenericQueue<Integer> q = new GenericQueue<>(4);
		q.enqueue(3);
		q.enqueue(9);
		
		ArrayList<Integer> dump = q.dumpList();
		Integer[] expectedArray = {4, 3, 9};
		assertArrayEquals(expectedArray, dump.toArray(), "queue: dumpArray failed");
	}
	
	@Test
	void queueGetTest() {
		GenericQueue<String> q = new GenericQueue<>("4");
		q.enqueue("3");
		q.enqueue("9");
		assertEquals("3", q.get(1), "queue: get failed");
	}
	
	@Test
	void queueSetTest() {
		GenericQueue<String> q = new GenericQueue<>("4");
		q.enqueue("3");
		q.enqueue("9");
		q.set(1, "45");
		assertEquals("45", q.get(1), "queue: set failed");
	}
	
	@Test
	void queueGetLengthTest() {
		GenericQueue<Double> q = new GenericQueue<>(5.66);
		q.enqueue(4.55);
		q.enqueue(4.57);
		q.enqueue(4.59);
		q.enqueue(4.5009);
		q.enqueue(4.34);
		assertEquals(6, q.getLength(), "queue: getLength failed");
	}
	
	@Test
	void queueSetLengthTest() {
		GenericQueue<Double> q = new GenericQueue<>(5.66);
		q.enqueue(4.55);
		q.enqueue(4.57);
		q.enqueue(4.59);
		q.enqueue(4.5009);
		q.enqueue(4.34);
		q.setLength(4);
		assertEquals(4, q.getLength(), "queue: setLength failed");
	}
	
	@Test
	void queueGetHeadTest() {
		GenericQueue<String> q = new GenericQueue<>("abc");
		q.enqueue("efg");
		q.enqueue("hij");
		q.enqueue("klm");
		q.enqueue("nop");
		assertEquals("abc", q.getHead().getData(), "queue: getHead failed");
	}
	
	@Test
	void queueSetHeadTest() {
		GenericQueue<String> q = new GenericQueue<>("abc");
		q.enqueue("efg");
		q.enqueue("hij");
		q.enqueue("klm");
		q.enqueue("nop");
		GenericList<String>.Node<String> node = q.new Node<>("new");
		q.setHead(node);
		assertEquals("new", q.getHead().getData(), "queue: setHead failed");
	}
	
	@Test
	void queueConstructorTest() {
		GenericQueue<Double> q = new GenericQueue<>(7.889);
		assertEquals(7.889, q.getHead().getData(), "queue: constructor failed");
	}
	
	@Test
	void queueAddTest() {
		GenericQueue<Double> q = new GenericQueue<>(3.14);
		q.add(0.04);
		assertEquals(2, q.getLength(), "queue: add failed");
	}
	
	@Test
	void queueEnqueueTest() {
		GenericQueue<Double> q = new GenericQueue<>(3.14);
		q.enqueue(0.04);
		ArrayList<Double> result = q.dumpList();
		Double[] expectedArray = {3.14, 0.04};
		assertArrayEquals(expectedArray, result.toArray(), "queue: enqueue failed");
	}
	
	@Test
	void queueDequeueTest() {
		GenericQueue<Double> q = new GenericQueue<>(3.14);
		q.enqueue(0.04);
		q.dequeue();
		ArrayList<Double> result = q.dumpList();
		Double[] expectedArray = {0.04};
		assertArrayEquals(expectedArray, result.toArray(), "queue: dequeue failed");
	}
	
	@Test
	void queueRemoveTailTest() {
		GenericQueue<Double> q = new GenericQueue<>(3.14);
		q.enqueue(0.23);
		q.enqueue(0.34);
		q.enqueue(0.04);
		assertEquals(0.04, q.removeTail(), "queue: removeTail failed");
	}
	
	@Test
	void queueIterTest() {
		ArrayList<String> result = new ArrayList<>();
		
		GenericQueue<String> q = new GenericQueue<>("dinosaur");
		q.enqueue("hello");
		q.enqueue("vase");
		q.enqueue("water");
		
		Iterator<String> iter = q.iterator();
		while (iter.hasNext()) {
			result.add(iter.next());
		}
		
		String[] expectedArray = {"dinosaur", "hello", "vase", "water"};
		assertArrayEquals(expectedArray, result.toArray(), "queue: normal iterator failed");
	}
	
	@Test
	void queueDescIterTest() {
		ArrayList<Integer> result = new ArrayList<>();
		
		GenericQueue<Integer> q = new GenericQueue<>(4);
		q.enqueue(2);
		q.enqueue(9);
		q.enqueue(0);
		
		Iterator<Integer> iter = q.descendingIterator();
		while (iter.hasNext()) {
			result.add(iter.next());
		}
		
		Integer[] expectedArray = {0, 9, 2, 4};
		assertArrayEquals(expectedArray, result.toArray(), "queue: descending iterator failed");
	}
	
	@Test
	void queueListIterTest() {
		ArrayList<Double> result = new ArrayList<>();
		
		GenericQueue<Double> q = new GenericQueue<>(3.1);
		q.enqueue(9.08);
		q.enqueue(4.45);
		q.enqueue(2.3);
		q.enqueue(0.08);
		q.enqueue(5.56);
		q.enqueue(7.88);
		
		Iterator<Double> iter = q.listIterator(3);
		while (iter.hasNext()) {
			result.add(iter.next());
		}
		
		Double[] expectedArray = {2.3, 0.08, 5.56, 7.88};
		assertArrayEquals(expectedArray, result.toArray(), "queue: list iterator failed");
	}
	
	/* Node class tests */
	
	@Test
	void nodeConstructorTest() {
		GenericQueue<Double> q = new GenericQueue<>(9.76);
		GenericList<Double>.Node<Double> node = q.new Node<>(2.14);
		assertEquals(2.14, node.getData(), "node constructor failed");
	}
	
	@Test
	void nodeGetDataTest() {
		GenericQueue<Double> q = new GenericQueue<>(9.76);
		GenericList<Double>.Node<Double> node = q.new Node<>(-3.45);
		assertEquals(-3.45, node.getData(), "node getData failed");
	}
	
	@Test
	void nodeSetDataTest() {
		GenericQueue<Double> q = new GenericQueue<>(9.76);
		GenericList<Double>.Node<Double> node = q.new Node<>(2.14);
		node.setData(88.8);
		assertEquals(88.8, node.getData(), "node setData failed");
	}
	
	@Test
	void nodeGetNextTest() {
		GenericQueue<Double> q = new GenericQueue<>(9.76);
		GenericList<Double>.Node<Double> node = q.new Node<>(2.14);
		assertEquals(null, node.getNext(), "node getNext failed");
	}
	
	@Test
	void nodeSetNextTest() {
		GenericQueue<Double> q = new GenericQueue<>(9.76);
		GenericList<Double>.Node<Double> node = q.new Node<>(2.14);
		q.getHead().setNext(node);
		assertEquals(2.14, q.getHead().getNext().getData(), "node setNext failed");
	}
	
	@Test
	void nodeGetPrevTest() {
		GenericQueue<Double> q = new GenericQueue<>(9.76);
		GenericList<Double>.Node<Double> node = q.new Node<>(2.14);
		assertEquals(null, node.getPrev(), "node getPrev failed");
	}
	
	@Test
	void nodeSetPrevTest() {
		GenericQueue<Double> q = new GenericQueue<>(9.76);
		GenericList<Double>.Node<Double> node = q.new Node<>(2.14);
		node.setPrev(q.getHead());
		assertEquals(9.76, node.getPrev().getData(), "node setPrev failed");
	}
}
