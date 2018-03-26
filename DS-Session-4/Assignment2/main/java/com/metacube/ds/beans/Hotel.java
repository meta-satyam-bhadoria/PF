package main.java.com.metacube.ds.beans;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to build a hotel and keep a track of rooms
 * 
 * @author satyam bhadoria
 *
 */
public class Hotel {
	private Map<Integer, String> listOfRooms;
	private int numOfRooms;
	
	/**
	 * Constructor
	 * 
	 * @param numOfRooms - number of rooms
	 */
	public Hotel(int numOfRooms){
		this.numOfRooms = numOfRooms;
		listOfRooms = new HashMap<>(numOfRooms);
	}
	
	/**
	 * Allots the room to the desirable person on first come first serve,
	 * but the number alloted is based on a hash function that uses age to determine 
	 * the room number
	 * 
	 * @param person - person object
	 */
	public void allotRooms(Person person) {
		int age = person.getAge();
		int roomNum = nextAvailableRoom(age % numOfRooms, 0);
		listOfRooms.put(roomNum, person.getName());
	}
	
	/**
	 * if the room number is not available directly using the hash function
	 * next room available is returned
	 * 
	 * @param roomNum - room number
	 * @param counter - counter for check whether room are left or not
	 * @return available room number 
	 */
	private int nextAvailableRoom(int roomNum, int counter) {
		
		if(counter >= this.numOfRooms) {
			throw new IndexOutOfBoundsException("no room left for allotment");
		} else if(listOfRooms.containsKey(roomNum)) {
			roomNum++;
			roomNum %= this.numOfRooms;
			roomNum = nextAvailableRoom(roomNum, counter + 1);
		}
		return roomNum;
	}
	
	/**
	 * returns the list of rooms with the name of the person alloted to
	 * @return list of rooms containing person name
	 */
	public Map<Integer, String> getListOfRoom() {
		return listOfRooms;
	}
}
