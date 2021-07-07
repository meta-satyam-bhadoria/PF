package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.java.util.Candidate;
import main.java.util.College;
import main.java.util.Counseling;
import main.java.util.Queue;

/**
 * this class is to test the Counseling process of candidate
 * @author Satyam Bhadoria
 *
 */
public class CounsellingTest {
	
	private Counseling counseling;
	private List<College> collegeList;
	private Queue<Candidate> candidateQueue;
	
	/**
	 * method to initiate the candidate queue and college list
	 */
	@Before
	public void init() {
		Candidate c1 = new Candidate("name1", 80);
		Candidate c2 = new Candidate("name2", 60);
		Candidate c3 = new Candidate("name3", 20);
		Candidate c4 = new Candidate("name4", 90);
		Candidate c5 = new Candidate("name5", 70);
		Candidate c6 = new Candidate("name6", 65);
		Candidate c7 = new Candidate("name7", 34);
		Candidate c8 = new Candidate("name8", 67);
		
		candidateQueue = new Queue<>();
		candidateQueue.enQueue(c1);
		candidateQueue.enQueue(c2);
		candidateQueue.enQueue(c3);
		candidateQueue.enQueue(c4);
		candidateQueue.enQueue(c5);
		candidateQueue.enQueue(c6);
		candidateQueue.enQueue(c7);
		candidateQueue.enQueue(c8);
		
		College clg1 = new College(1, "College1", 2);
		College clg2 = new College(2, "College2", 1);
		College clg3 = new College(3, "College3", 0);
		College clg4 = new College(4, "College4", 1);
		
		collegeList = new ArrayList<College>();
		collegeList.add(clg1);
		collegeList.add(clg2);
		collegeList.add(clg3);
		collegeList.add(clg4);
		counseling = new Counseling();
	}
	
	/**
	 * method to test working of counseling process
	 * successful case
	 */
	@Test
	public void testCounselingProcess() {
		int[] input = {1,1,2,4};
		List<String> actual = counseling.startCounselling(candidateQueue, collegeList, input);
		List<String> expected = new ArrayList<>();
		expected.add("Name: name4 College Allotted: College1");
		expected.add("Name: name1 College Allotted: College1");
		expected.add("Name: name5 College Allotted: College2");
		expected.add("Name: name8 College Allotted: College4");
		expected.add("Name: name6 College Allotted: null");
		expected.add("Name: name2 College Allotted: null");
		expected.add("Name: name7 College Allotted: null");
		expected.add("Name: name3 College Allotted: null");
		assertEquals(expected, actual);
 	}

	/**
	 * method to expect the illegal argument exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test1() {
		int[] input = {1,1,1,4};
		List<String> actual = counseling.startCounselling(candidateQueue, collegeList, input);
		List<String> expected = new ArrayList<>();
		expected.add("Name: name4 College Allotted: College1");
		expected.add("Name: name1 College Allotted: College1");
		expected.add("Name: name5 College Allotted: College2");
		expected.add("Name: name8 College Allotted: College4");
		expected.add("Name: name6 College Allotted: null");
		expected.add("Name: name2 College Allotted: null");
		expected.add("Name: name7 College Allotted: null");
		expected.add("Name: name3 College Allotted: null");
		assertEquals(expected, actual);
 	}
}
