package srm645.div2;

import java.util.Arrays;
import java.util.HashMap;

public class ConnectingCars {
	
	public long minimizeCost(int[] positions, int[] lengths)
	{
		HashMap<Integer,Integer> lMap = new HashMap<Integer,Integer>();		
		for (int i=0; i<positions.length; i++){
			lMap.put(positions[i],lengths[i]);			
		}
		Arrays.sort(positions);
		
		long energy = Long.MAX_VALUE;
		for (int i=0; i<positions.length; i++) {
			int curPos = positions[i];
			long tempEnergy = 0L;
			for(int j=i-1; j>-1; j--) {
				int diff = curPos-(positions[j]+lMap.get(positions[j]));
				tempEnergy += diff;
				curPos=positions[j]+diff;
			}
			curPos = curPos+lMap.get(positions[i]);
			for(int j=i+1; j<positions.length; j++){								
				tempEnergy += (positions[j]-curPos);
				curPos += lMap.get(positions[j]);				
			}
			energy = Math.min(energy, tempEnergy);
		}
		return energy;
	}
	
	public static void main(String[] args)
	{
		long time;
		long answer;
		boolean errors = false;
		long desiredAnswer;
		
//		<%:start-tests%>
		time = System.currentTimeMillis();
		answer = new ConnectingCars().minimizeCost(new int[]{1, 3, 10, 20}, new int[]{2, 2, 5, 3});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 15L;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new ConnectingCars().minimizeCost(new int[]{100, 50, 1}, new int[]{10, 2, 1});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 96L;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new ConnectingCars().minimizeCost(new int[]{4, 10, 100, 13, 80}, new int[]{5, 3, 42, 40, 9});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 66L;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new ConnectingCars().minimizeCost(new int[]{5606451, 63581020, 81615191, 190991272, 352848147, 413795385, 468408016, 615921162, 760622952, 791438427}, new int[]{42643329, 9909484, 58137134, 99547272, 39849232, 15146704, 144630245, 604149, 15591965, 107856540});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 1009957100L;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
//		<%:end-tests%>
		
		if (errors)
			System.out.println("Some of the test cases had errors :-(");
		else
			System.out.println("You're a stud (at least on the test data)! :-D ");
	}


}
