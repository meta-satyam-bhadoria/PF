package main.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * This class represents the various methods required to make the workflow 
 * for a candidate
 * @author Satyam Bhadoria
 * 
 */
public class Workflow {
	private State currentState;
	private int stateCounter = 0;					//counter to fetch state from linked list of state objects
	private String workflowName;
	private List<Event> eventList = new ArrayList<>();
	private List<Transition> transitionList = new ArrayList<>();
	private LinkedList<State> stateList = new LinkedList<>();
	
	/**
     * constructor
     * @param workflowName - string having name of the workflow
     */
	public Workflow (String workflowName) {
		this.workflowName = workflowName;
	}
	
	/**
	 * method that adds the event in event list and manages the next move
	 * @param event - the current event that occurred
	 * @throws NullPointerException - throws this type of exception
	 */
	public void transitionStep (Event event) throws NullPointerException {
		
		if (event.getEventName() == " " || event.getEventName() == "") {
			throw new NullPointerException ();
		}
		this.eventList.add (event);
		
		/*method called to check the type of event that occurred*/
		checkEvent (event , event.getEventName() );
		
	}

	/**
	 * method that checks if the event has reject or ok keyword in it
	 * @param event - object of event class in which variable ok or reject have to 
	 * be changed
	 * @param eventStatus - name of the event to be checked
	 * @return status - string status of candidate
	 */
	public String checkEvent (Event event , String eventStatus) {
		String status = null;
		
		event.changeStatus (eventStatus);					//change the status of variable
			
		if ( event.isReject() ) {
			status = "Rejected";
			
			Transition transition = new Transition (currentState, currentState, event);
			this.transitionList.add (transition);
		
		} else {
			currentState = stateList.get (++stateCounter);		//initializes current state to the next state
			
			if (currentState.getStateName () == "offer") {
				status = "Selected";
			}
			Transition transition = new Transition ( stateList.get (stateCounter - 1), currentState, event);
			transitionList.add (transition);
		}
		
		return status;
	}
	
	/**
	 * method to return the transition list
	 * @return transitionList - contains all the transition 
	 */
	public List<Transition> getTransitionList () {
		return this.transitionList;
	}
	
	/**
	 * method to set start state
	 */
	public void setStartState () {
		this.currentState = this.stateList.get (stateCounter);
	}
	
	/**
	 * method that returns the state list
	 * @return stateList - contains the list of objects
	 */
	public LinkedList<State> getStateList () {
		return this.stateList;
	}

	/**
	 * method that returns the event list
	 * @return event_list contains the list of event objects
	 */
	public List<Event> getEventList () {
		return this.eventList;
	}
	
	/**
	 * method to add state to the list
	 * @param state - new state
	 */
	public void addState (State state) {
		this.stateList.add (state);
	}
	
	/**
	 * verify if passed state and current state is equal
	 * @param state - passed state
	 * @return true or false
	 */
	public boolean verify (State state) {
		return this.currentState == state ? true : false;
	}
}
