package main.java;
 
/**
 * This class depicts the occurring event for a particular candidate
 * @author Satyam Bhadoria
 * 
 */
public class Event {
	
	/*variables to store event results*/
	private boolean ok = false;
	private boolean reject = false;
	
	private String eventName;
	
	/**
	 * constructor initializing the 
	 * @param eventName - name of the event
	 */
	public Event(String eventName){
		this.eventName = eventName;
	}
	
	/**
	 * method to return the value of ok variable
	 * @return ok - boolean value of ok
	 */
	public boolean isOk() {
		return this.ok;
	}

   /**
    * method to set value of ok variable
    * @param ok - value of ok variable
    */
	public void setOk(boolean ok) {
		this.ok = ok;
	}


	/**
	 * method to return the value of reject variable
	 * @return reject - boolean value of reject
	 */
	public boolean isReject() {
		return this.reject;
	}

    /**
    * method to set value of reject variable
    * @param reject -  value of reject variable
    */
	public void setReject(boolean reject) {
		this.reject = reject;
	}

     
	/**
	 * method to return the name of the event
	 * @return eventName - the event name
	 */
	public String getEventName() {
		return this.eventName;
	}


	/**
	 * method to set value of eventname variable
	 * @param eventName - contains the name of the event
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}


    /**
     * this method changes the status of boolean variable either for ok or for reject
     * according to the event name
     * @param eventStatus - name of the event
     */
	public void changeStatus(String eventStatus) {
		eventStatus = eventStatus.toLowerCase();

		if(eventStatus.contains("reject")) {
			this.setReject(true);
		} else {
			this.setOk(true);
		}
	}
}
