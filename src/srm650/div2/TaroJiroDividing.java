package srm650.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

class TaroJiroDividing {
	public int getNumber(int A, int B) {
		HashSet<Integer> numSet = new HashSet<Integer>();
		buildHashSetTaro(A, numSet);
		return getCommonSetJiro(B, numSet);
	}
	
	public static void main(String args[]) throws IOException{
		TaroJiroDividing tjd = new TaroJiroDividing();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] tokens = input.split(" ");
		while(tokens.length==2) {
			int a = Integer.valueOf(tokens[0]);
			int b = Integer.valueOf(tokens[1]);
			System.out.println(tjd.getNumber(a, b));
			input = br.readLine();
			tokens = input.split(" ");
		}
	}
	
	private void buildHashSetTaro(int dividend,HashSet<Integer> nums){
		nums.add(dividend);
		while((dividend&1)==0){
			dividend/=2;
			nums.add(dividend);
		}
	}
	
	private int getCommonSetJiro(int b, HashSet<Integer> nums) {
		int count = nums.contains(b)?1:0;
		while((b&1)==0){
			b/=2;
			if(nums.contains(b)){
				count++;
			}
		}
		return count;
	}
}