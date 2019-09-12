package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import main.java.Event;
import main.java.State;
import main.java.Transition;
import main.java.Workflow;

import org.junit.Before;
import org.junit.Test;

/**
 * This class is use to test the workflow of the workflow execution engine
 * @author Satyam Bhadoria
 *
 */
public class TestWorkflow {
	
	private Workflow w = new Workflow("MetaCube hiring process");
	private State startState;
	private State hrReviewstate;
	private State l1_InterviewState;
	private State l2_InterviewState;
	private State management_Interview_State;
	private State offer_state;

	/**
	 * method to initialize all states before testing
	 */
	@Before
	public void beginWorkflow(){
		
		startState = new State("start");
		hrReviewstate = new State("hr Review");
		l1_InterviewState = new State("l1 Interview");
		l2_InterviewState = new State("l2 Interview");
		management_Interview_State = new State("management Interview");
		offer_state = new State("offer");
		
		/*adding states to the workflow*/
		w.addState(startState);
		w.addState(hrReviewstate);
		w.addState(l1_InterviewState);
		w.addState(l2_InterviewState);
		w.addState(management_Interview_State);
		w.addState(offer_state);
		w.setStartState();
		
	}
	
	/**
	 * method to test for success for selection
	 */
	@Test
	public void testSelectedSuccess() {
		
		Event event1 = new Event("hr process");
		w.transitionStep(event1);
		Event event2 = new Event("hr ok");
		w.transitionStep(event2);
		Event event3 = new Event("l1 ok");
		w.transitionStep(event3);
		Event event4 = new Event("l2 ok");
		w.transitionStep(event4);
		Event event5 = new Event("management ok");
		w.transitionStep(event5);
		
		List<Transition> actualObject = w.getTransitionList();
		List<String> actual = new ArrayList<String>() ;
		actual.add("Selected");
		for(Transition transition : actualObject) {
			actual.add(transition.getInitialState().getStateName() + transition.getFinalState().getStateName() + transition.getEvent().getEventName());
		}
		List<String> expected = new ArrayList<String>();
		expected.addAll(Arrays.asList("Selected","starthr Reviewhr process" ,"hr Reviewl1 Interviewhr ok" ,
										"l1 Interviewl2 Interviewl1 ok" , "l2 Interviewmanagement Interviewl2 ok" , 
				 							"management Interviewoffermanagement ok"));
		assertEquals(expected,actual);
	}
	
	/**
	 * method to test for failure for selection
	 */
	@Test
	public void testSelectedFailure() {
		
		Event event1 = new Event("hr process");
		w.transitionStep(event1);
		Event event2 = new Event("hr ok");
		w.transitionStep(event2);
		Event event3 = new Event("l1 ok");
		w.transitionStep(event3);
		Event event4 = new Event("l2 ok");
		w.transitionStep(event4);
		Event event5 = new Event("management ok");
		w.transitionStep(event5);
		
		List<Transition> actualObject = w.getTransitionList();
		List<String> actual = new ArrayList<String>() ;
		actual.add("Selected");
		for(Transition transition : actualObject) {
			actual.add(transition.getInitialState().getStateName() + transition.getFinalState().getStateName() + transition.getEvent().getEventName());
		}
		List<String> expected = new ArrayList<String>();
		expected.addAll(Arrays.asList("Selected","starthr Reviewhr process" ,"hr Reviewl1 Interviewhr ok" ,
										"l2 Interviewmanagement Interviewl2 ok" , 
				 							"management Interviewoffermanagement ok"));
		assertNotEquals(expected,actual);
	}

	/**
	 * method to test for success of rejection
	 */
	@Test
	public void testRejectSuccess() {
		
		Event event1 = new Event("hr process");
		w.transitionStep(event1);
		Event event2 = new Event("hr ok");
		w.transitionStep(event2);
		Event event3 = new Event("l1 ok");
		w.transitionStep(event3);
		Event event4 = new Event("l2 reject");
		w.transitionStep(event4);
		
		List<Transition> actualObject = w.getTransitionList();
		List<String> actual = new ArrayList<String>() ;
		actual.add("rejected");
		for(Transition transition : actualObject) {
			actual.add(transition.getInitialState().getStateName() + transition.getFinalState().getStateName() + transition.getEvent().getEventName());
		}
		List<String> expected = new ArrayList<String>();
		expected.addAll(Arrays.asList("rejected","starthr Reviewhr process" ,"hr Reviewl1 Interviewhr ok" ,
										"l1 Interviewl2 Interviewl1 ok" , "l2 Interviewl2 Interviewl2 reject"));
		assertEquals(expected,actual);
	}
	
	/**
	 * method to test for reject process failure - Negative test case
	 */
	@Test
	public void testRejectFailure() {
		
		Event event1 = new Event("hr process");
		w.transitionStep(event1);
		Event event2 = new Event("hr ok");
		w.transitionStep(event2);
		Event event3 = new Event("l1 ok");
		w.transitionStep(event3);
		Event event4 = new Event("l2 reject");
		w.transitionStep(event4);
		
		List<Transition> actualObject = w.getTransitionList();
		List<String> actual = new ArrayList<String>() ;
		actual.add("rejected");
		for(Transition transition : actualObject) {
			actual.add(transition.getInitialState().getStateName() + transition.getFinalState().getStateName() + transition.getEvent().getEventName());
		}
		List<String> expected = new ArrayList<String>();
		 expected.addAll(Arrays.asList());
		assertNotEquals(expected,actual);
		
		
	}
	
	/**
	 * method to test for null pointer exception
	 */
	@Test(expected=NullPointerException.class)
	public void testNullPointerException() {
		
		Event event1 = new Event(null);
		w.transitionStep(event1);
		Event event2 = new Event("hr ok");
		w.transitionStep(event2);
		Event event3 = new Event("l1 ok");
		w.transitionStep(event3);
		Event event4 = new Event("l2 reject");
		w.transitionStep(event4);
		
		List<Transition> actualObject = w.getTransitionList();
		List<String> actual = new ArrayList<String>() ;
		actual.add("rejected");
		for(Transition transition : actualObject) {
			actual.add(transition.getInitialState().getStateName() + transition.getFinalState().getStateName() + transition.getEvent().getEventName());
		}
		List<String> expected = new ArrayList<String>();
		expected.addAll(Arrays.asList());
		assertNotEquals(expected,actual);
	}
}
