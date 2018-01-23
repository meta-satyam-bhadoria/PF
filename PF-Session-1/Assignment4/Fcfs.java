/*
 * This file contain Fcfs class for
 * for simulating first come first serve algorithm
 */

/**
 * Fcfs class contain method fcfs for simulating
 * first come first serve algorithm
 * @author satyam bhadoria
 *
 */
public class Fcfs {
	
	/**
	 * This method simulates first come first serve
	 * scheduler of a machine.
	 * @param arrivalTime
	 * @param jobSize
	 * @return output
	 */
	int[][] fcfs(int[] arrivalTime, int[] jobSize){
		int[][] output = new int[arrivalTime.length][5];	//holds job start, wait, arrived and finished time
		int jobStartTime = 1;								//holds job start time
		
		/*finds job start, wait, arrived and finished time for each job*/
		for(int i = 0; i < arrivalTime.length; i++){
			output[i][0] = i + 1;							//assign job number
			output[i][1] = arrivalTime[i];					//job arrival time
		 
			/*assign job start time according to arrival time*/
			if(jobStartTime >= arrivalTime[i]){
				output[i][3] = jobStartTime;
			} else{
				output[i][3] = arrivalTime[i];
				jobStartTime = output[i][3];
			}
			output[i][4] = jobSize[i] + jobStartTime - 1;	//assign job finished time
			jobStartTime = output[i][4] + 1;
			 
			/*assign job wait time according to arrival time*/
			if(output[i][3] >= arrivalTime[i]){
				output[i][2] = output[i][3] - arrivalTime[i];
			} else{
				output[i][2] = 0;
			}
		}
		return output;
	}
}
