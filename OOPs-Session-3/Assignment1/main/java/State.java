package main.java;

/**
 * This class represents the various state of workflow
 * @author Satyam Bhadoria
 * 
 */
public class State {
	private String stateName;
	
	/**
	 * constructor initializing statename
	 * @param stateName - name of state
	 */
	public State(String stateName){
		this.stateName = stateName;
	}

	/**
	 * method to get the state name
	 * @return stateName - name of state
	 */
	public String getStateName() {
		return this.stateName;
	}
	
}
