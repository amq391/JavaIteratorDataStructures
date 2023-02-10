import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;
import org.junit.jupiter.api.Test;

public class GSTest {
	
	@Test
	void stackDeleteTest() {
		GenericStack<String> s = new GenericStack<>("a");
		assertEquals("a", s.delete(), "stack: delete failed");
	}
	
	@Test
	void stackDumpListTest() {
		GenericStack<Integer> s = new GenericStack<>(4);
		s.push(3);
		s.push(9);
		
		ArrayList<Integer> dump = s.dumpList();
		Integer[] expectedArray = {9, 3, 4};
		assertArrayEquals(expectedArray, dump.toArray(), "stack: dumpArray failed");
	}
	
	@Test
	void stackGetTest() {
		GenericStack<String> s = new GenericStack<>("4");
		s.push("3");
		s.push("9");
		assertEquals("4", s.get(2), "stack: get failed");
	}
	
	@Test
	void stackSetTest() {
		GenericStack<String> s = new GenericStack<>("4");
		s.push("3");
		s.push("9");
		s.set(2, "78");
		assertEquals("78", s.get(2), "stack: set failed");
	}
	
	@Test
	void stackGetLengthTest() {
		GenericStack<Double> s = new GenericStack<>(5.66);
		s.push(4.55);
		s.push(4.57);
		s.push(4.59);
		s.push(4.5009);
		s.push(4.34);
		assertEquals(6, s.getLength(), "stack: getLength failed");
	}
	
	@Test
	void stackSetLengthTest() {
		GenericStack<Double> s = new GenericStack<>(5.66);
		s.push(4.55);
		s.push(4.57);
		s.push(4.59);
		s.push(4.5009);
		s.push(4.34);
		s.setLength(2);
		assertEquals(2, s.getLength(), "stack: setLength failed");
	}
	
	@Test
	void stackGetHeadTest() {
		GenericStack<String> q = new GenericStack<>("abc");
		q.push("efg");
		q.push("hij");
		q.push("klm");
		q.push("nop");
		assertEquals("nop", q.getHead().getData(), "stack: getHead failed");
	}
	
	@Test
	void stackSetHeadTest() {
		GenericStack<String> s = new GenericStack<>("abc");
		s.push("efg");
		s.push("hij");
		s.push("klm");
		s.push("nop");
		GenericList<String>.Node<String> node = s.new Node<>("new");
		s.setHead(node);
		assertEquals("new", s.getHead().getData(), "stack: setHead failed");
	}
	
	@Test
	void stackConstructorTest() {
		GenericStack<Double> s = new GenericStack<>(7.889);
		assertEquals(7.889, s.getHead().getData(), "stack: constructor failed");
	}
	
	@Test
	void stackAddTest() {
		GenericStack<Double> s = new GenericStack<>(3.14);
		s.add(4.45);
		assertEquals(2, s.getLength(), "stack: add failed");
	}
	
	@Test
	void stackPushTest() {
		GenericStack<Double> s = new GenericStack<>(3.14);
		s.push(4.45);
		ArrayList<Double> result = s.dumpList();
		Double[] expectedArray = {4.45, 3.14};
		assertArrayEquals(expectedArray, result.toArray(), "stack: push failed");
	}
	
	@Test
	void stackPopTest() {
		GenericStack<Double> s = new GenericStack<>(3.14);
		s.push(4.45);
		s.pop();
		ArrayList<Double> result = s.dumpList();
		Double[] expectedArray = {3.14};
		assertArrayEquals(expectedArray, result.toArray(), "stack: pop failed");
	}
	
	@Test
	void stackRemoveTailTest() {
		GenericStack<Double> s = new GenericStack<>(3.14);
		s.push(4.45);
		s.push(4.5);
		s.push(0.85);
		assertEquals(3.14, s.removeTail(), "stack: removeTail failed");
	}
	
	@Test
	void stackIterTest() {
		ArrayList<String> result = new ArrayList<>();
		
		GenericStack<String> s = new GenericStack<>("dinosaur");
		s.push("hello");
		s.push("vase");
		s.push("water");
		
		Iterator<String> iter = s.iterator();
		while (iter.hasNext()) {
			result.add(iter.next());
		}
		
		String[] expectedArray = {"water", "vase", "hello", "dinosaur"};
		assertArrayEquals(expectedArray, result.toArray(), "stack: normal iterator failed");
	}
	
	@Test
	void stackDescIterTest() {
		ArrayList<Integer> result = new ArrayList<>();
		
		GenericStack<Integer> s = new GenericStack<>(4);
		s.push(2);
		s.push(9);
		s.push(0);
		
		Iterator<Integer> iter = s.descendingIterator();
		while (iter.hasNext()) {
			result.add(iter.next());
		}
		
		Integer[] expectedArray = {4, 2, 9, 0};
		assertArrayEquals(expectedArray, result.toArray(), "stack: descending iterator failed");
	}
	
	@Test
	void stackListIterTest() {
		ArrayList<Double> result = new ArrayList<>();
		
		GenericStack<Double> s = new GenericStack<>(3.1);
		s.push(9.08);
		s.push(4.45);
		s.push(2.3);
		s.push(0.08);
		s.push(5.56);
		s.push(7.88);
		
		Iterator<Double> iter = s.listIterator(3);
		while (iter.hasNext()) {
			result.add(iter.next());
		}
		
		Double[] expectedArray = {2.3, 4.45, 9.08, 3.1};
		assertArrayEquals(expectedArray, result.toArray(), "stack: list iterator failed");
	}
}
