package main.java.util;
/**
 * This class represents college.
 * @author Satyam Bhadoria
 *
 */
public class College {
	private int id;
	private String name;
	private int availableSeats;
	
	/**
	 * constructor
	 * @param id - id of college
	 * @param name - name of college
	 * @param seats - available seats in college
	 */
	public College(int id,String name, int seats) {
		this.id = id;
		this.name = name;
		this.availableSeats = seats;
	}

	/**
	 * getter for getting the id of college
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * getter for getting the name of college
	 * @return name of college
	 */
	public String getName() {
		return name;
	}

	/**
	 * getter for getting the available seats of college
	 * @return available seats
	 */
	public int getAvailableSeats() {
		return availableSeats;
	}

	/**
	 * method to update the available seat
	 */
	public void updateAvailableSeats() {
		this.availableSeats--;
	}
	
	/**
	 * Check for available seat
	 * @return true or false
	 */
	public boolean isSeatAvailable() {
		return (this.availableSeats > 0) ? true : false;
	}
}
