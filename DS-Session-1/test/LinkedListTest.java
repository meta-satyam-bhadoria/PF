package test;

import static org.junit.Assert.*;

import org.junit.Test;

import myjava.util.LinkedList;

public class LinkedListTest {

	@Test
	public void test() {
		LinkedList<Integer> l = new LinkedList<>();
		l.add(3);
		l.add(4);
		l.add(3);
		l.remove(-1);
		l.display();
	}

}
