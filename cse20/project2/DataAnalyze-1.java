import java.util.Scanner;
public class DataAnalyze {

	public static void main(String[] args) {

		int i = 0;
		Scanner scnr =new Scanner(System.in);
		int minAvg = Integer.MAX_VALUE;
		int maxAvg = Integer.MIN_VALUE;
		int avg1 = 0;
		int avg2 = 0;
		int avg3 = 0;
		int avg4 = 0;
		int[] avg = new int[4];

		// Ask for sample size
		System.out.print("Please enter sample size: ");
		int sample = scnr.nextInt();
		int[] myTrials1 = new int[sample];
		int[] myTrials2 = new int[sample];
		int[] myTrials3 = new int[sample];
		int[] myTrials4 = new int[sample];

		// Enter trial numbers
		System.out.println("Trial 1");
		for(i = 0; i < sample; i++) {
			System.out.print("Enter sample #" + i + ":");
			myTrials1[i] = scnr.nextInt();
			if(i == 0) {
				avg1 = myTrials1[i];
			}else if(i > 0) {
				avg1 = avg1 + myTrials1[i];
			}
		}

		avg1 = avg1/sample;
		avg[0] = avg1;

		System.out.println("Trial 2");
		for(i = 0; i < sample; i++) {
			System.out.print("Enter sample #" + i + ":");
			myTrials2[i] = scnr.nextInt();
			if(i == 0) {
				avg2 = myTrials2[i];
			}else if(i > 0) {
				avg2 = avg2 + myTrials2[i];
			}
		}

		avg2 = avg2/sample;
		avg[1] = avg2;

		System.out.println("Trial 3");
		for(i = 0; i < sample; i++) {
			System.out.print("Enter sample #" + i + ":");
			myTrials3[i] = scnr.nextInt();
			if(i == 0) {
				avg3 = myTrials3[i];
			}else if(i > 0) {
				avg3 = avg3 + myTrials3[i];
			}
		}

		avg3 = avg3/sample;
		avg[2] = avg3;

		System.out.println("Trial 4");
		for(i = 0; i < sample; i++) {
			System.out.print("Enter sample #" + i + ":");
			myTrials4[i] = scnr.nextInt();
			if(i == 0) {
				avg4 = myTrials4[i];
			}else if(i > 0) {
				avg4 = avg4 + myTrials4[i];
			}
		}

		avg4 = avg4/sample;
		avg[3] = avg4;

		System.out.println("\tSample #\tTrial 1\tTrial 2\tTrial3\tTrial 4"); // Table header line

		for(i = 0; i < sample;i++) {
			System.out.println("\t" + i + "\t\t" + myTrials1[i] + "\t" + myTrials2[i] + "\t" + myTrials3[i] + "\t" + myTrials4[i]);
		}

		System.out.println("Average" + "#\t\t" + avg1 + "\t" + avg2 + "\t" + avg3 + "\t" + avg4);

		for (i = 0; i < avg.length; i++) {

			if(avg[i] > maxAvg){
				maxAvg = avg[i];
			}	
			if(avg[i] < minAvg){
				minAvg = avg[i];
			}

		}


		System.out.println("Min Average: " + minAvg);
		System.out.println("Max Average: " + maxAvg);

		System.out.print("The trials ");
		int doubleMinAvg = 0;
		doubleMinAvg = 2*minAvg;		
		if (minAvg == maxAvg)  {
			System.out.print("match EXACTLY!");
		}
		else if (maxAvg < doubleMinAvg){
			System.out.print("concur with each other!");


		}
		else {
			if (maxAvg != minAvg)  {
				System.out.print("do NOT concur!");
			}
		}
	}

}
