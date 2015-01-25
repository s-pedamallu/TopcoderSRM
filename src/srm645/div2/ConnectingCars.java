package srm645.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class ConnectingCars {
	
	private class Car implements Comparable<Car>{		
		int from;
		int to;
		int length;
		
		public Car(int f, int l) {			
			this.from = f;
			this.to = f+l;
			this.length = l;
		}

		@Override
		public int compareTo(Car o) {
			return this.from<o.from ? -1 : 1;			
		}
				
	}
	
	public long minimizeCost(int[] positions, int[] lengths)
	{
		Car[] cars = new Car[positions.length];		
		for (int i=0; i<positions.length; i++){
			cars[i] = new Car(positions[i], lengths[i]);		
		}
		Arrays.sort(cars);
		
		long minEnergy = Long.MAX_VALUE;
		for (int i=0; i<positions.length; i++) {
			int curPos = cars[i].from;
			long tempEnergy = 0L;
			for(int j=i-1; j>-1; j--) {				
				tempEnergy += curPos-cars[j].to;				
				curPos-=cars[j].length;
			}
			curPos = cars[i].to;
			for(int j=i+1; j<positions.length; j++){								
				tempEnergy += cars[j].from - curPos;
				curPos += cars[j].length;				
			}
			minEnergy = Math.min(minEnergy, tempEnergy);
		}
		return minEnergy;
	}
	
	/*
	 * Test Cases:
	 * Input:
	 * {1 3 10 20}
	 * {2 2 5 3}
	 * Desired Output:
	 * 15
	 * 
	 * Input:
	 * {100 50 1}
	 * {10 2 1}
	 * Desired Output:
	 * 96
	 * 
	 * Input:
	 * {4 10 100, 13 80}
	 * {5 3 42 40 9}
	 * Desired Output:
	 * 66
	 * 
	 * Input:
	 * {5606451 63581020 81615191 190991272 352848147 413795385 468408016 615921162 760622952 791438427}
	 * {42643329 9909484 58137134 99547272 39849232 15146704 144630245 604149 15591965 107856540}
	 * Desired Output:
	 * 1009957100
	 * */
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] tokens = input.split(" ");
		int[] pos = new int[tokens.length];
		for (int i=0; i<tokens.length; i++) {
			pos[i] = Integer.valueOf(tokens[i]);
		}
		input = br.readLine();
		tokens = input.split(" ");
		int[] len = new int[tokens.length];
		for (int i=0; i<tokens.length; i++) {
			len[i] = Integer.valueOf(tokens[i]);
		}
		System.out.println(new ConnectingCars().minimizeCost(pos, len));
	}


}
