package test.java.com.metacube.ds;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import main.java.com.metacube.ds.beans.Hotel;
import main.java.com.metacube.ds.beans.Person;

import org.junit.Before;
import org.junit.Test;

/**
 * This class is to test the implemented system of room allotment to guest based on their ages.
 * @author satyam bhadoria
 *
 */
public class TestRooms {

	private Person p1;
	private Person p2;
	private Person p3;
	private Person p4;
	private Hotel hotel;
	private Map<Integer, String> actual;
	private Map<Integer, String> expected;
	
	/**
	 * method to initialize the objects
	 */
	@Before
	public void setUp() {
		p1 = new Person(82, "abc1");
		p2 = new Person(78, "abc2");
		p3 = new Person(62, "abc3");
		p4 = new Person(92, "abc4");
		hotel = new Hotel(7);
		actual = new HashMap<>();
		expected = new HashMap<>();
		hotel.allotRooms(p1);
		hotel.allotRooms(p2);
		hotel.allotRooms(p3);
		hotel.allotRooms(p4);
	}

	/**
	 * method to test the allotment of guests
	 */
	@Test
	public void testRoomAllotment() {
		actual = hotel.getListOfRoom();
		expected.put(1, "abc2");
		expected.put(2, "abc4");
		expected.put(5, "abc1");
		expected.put(6, "abc3");
		assertEquals(expected,actual);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRoomAllotmentForException() {
		Person p5 = new Person(58, "abc5");
		Person p6 = new Person(54, "abc6");
		Person p7 = new Person(49, "abc7");
		Person p8 = new Person(75, "abc8");
		hotel.allotRooms(p5);
		hotel.allotRooms(p6);
		hotel.allotRooms(p7);
		hotel.allotRooms(p8);
		actual = hotel.getListOfRoom();
		expected.put(1, "abc2");
		expected.put(2, "abc4");
		expected.put(5, "abc1");
		expected.put(6, "abc3");
		expected.put(7, "abc6");
		assertEquals(expected,actual);
	}

}
