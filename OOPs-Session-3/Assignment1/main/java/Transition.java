package main.java;

/**
 * This class depicts the transition that occurred due to the event that occurred
 * @author Satyam Bhadoria
 * 
 */
public class Transition {
	private State initialState;
	private State finalState;
	private Event event;

	/**
	 * constructor to initialize initialState,finalState and event
	 * @param initialState - state object depicting initial state 
	 * @param finalState - state object depicting final state
	 * @param event - event object depicting occurred event
	 */
	public Transition(State initialState, State finalState, Event event) {
		
		this.initialState = initialState;
		this.finalState = finalState;
		this.event = event;
		
	}
	
	/**
	 * method to get the initial state
	 * @return initialState - returns initial state
	 */
	public State getInitialState() {
		return this.initialState;
	}
	
	/**
	 * method to get the final state
	 * @return finalState - returns final state
	 */
	public State getFinalState() {
		return this.finalState;
	}
	
	
	/**
	 * method to get the event
	 * @return event object
	 */
	public Event getEvent() {
		return this.event;
	}
}
