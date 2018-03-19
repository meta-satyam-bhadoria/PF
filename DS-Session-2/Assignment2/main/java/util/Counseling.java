package main.java.util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * This class simulates the counseling process.
 * @author Satyam Bhadoria
 *
 */
public class Counseling {
	
	private static Logger logger = Logger.getLogger(Counseling.class.getName());
	
	/**
	 * method for simulate counseling process
	 * @param candidateQueue - queue of candidate
	 * @param collegeList - list of college
	 * @param input - array of college selected by candidates
	 * @return final list containing candidate and college name
	 */
	public List<String> startCounselling(Queue<Candidate> candidateQueue, List<College> collegeList, int[] input) {
		int inputCounter = 0;
		int choiceForSelectingCollege;
		int totalStudents = candidateQueue.size();
		List<Candidate> candidateList = new ArrayList<Candidate>();
		
		Arrays.sort(candidateQueue.toArray());				//Sorting candidates according to their marks
		
		for(int i = 0; i < totalStudents;i++) {
			Candidate c = candidateQueue.deQueue();
			candidateList.add(c);
			logger.info("Call for Student:"+ c.getName() +" Remaining Students = "+candidateQueue.size());
			boolean flag = false;
			int j;
			
			//Printing the list of colleges.
			for( j = 0; j < collegeList.size(); j++) {
				if(collegeList.get(j).isSeatAvailable()) {
					flag = true;
					logger.info("Id:"+(j+1)+"College name:"+collegeList.get(j).getName()+"  "+"Available seats:"+collegeList.get(j).getAvailableSeats());
				}
			}
			
			if(flag) {
				choiceForSelectingCollege = input[inputCounter++]-1;   	//Choice entered by the candidate.
				
				/*For invalid choice*/
				if(((choiceForSelectingCollege > j)&&(choiceForSelectingCollege <= 0)) || (collegeList.get(choiceForSelectingCollege).getAvailableSeats()<=0)) {
					throw new IllegalArgumentException("Wrong Choice");
				}
				c.setCollegeName(collegeList.get(choiceForSelectingCollege).getName());
				collegeList.get(choiceForSelectingCollege).updateAvailableSeats();
			}
		}
		List<String> result = new ArrayList<>();   		//Final college list for candidates.
		
		for(Candidate c : candidateList) {
			result.add("Name: "+c.getName()+" "+"College Allotted: "+c.getCollegeName());
		}
		return result;
	}

}
