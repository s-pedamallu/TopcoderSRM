package srm645.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BacteriesColony
{
	public int[] performTheExperiment(int[] colonies)
	{
		boolean flag;
		int[] temp;
		do{
		flag=false;
		temp = new int[colonies.length];
		temp[0]=colonies[0];
		temp[temp.length-1]=colonies[temp.length-1];
		for(int i=1; i<colonies.length-1; i++)	{
			if(colonies[i]<colonies[i-1] && colonies[i]<colonies[i+1]) {
				temp[i]=colonies[i]+1;
				flag=true;
			}
			else if(colonies[i]>colonies[i-1] && colonies[i]>colonies[i+1]) {
				temp[i]=colonies[i]-1;
				flag=true;
			}
		}		
		}while(flag);
		return temp;
	}
	
	public static void main(String[] a) throws IOException{
		BacteriesColony bc = new BacteriesColony();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] tokens = input.split(",");
		int[] arr = new int[tokens.length];
		for(int i=0; i<arr.length; i++){
			arr[i]=Integer.valueOf(tokens[i]);
		}
		int[] result = bc.performTheExperiment(arr);
		for(int i=0; i<arr.length; i++){
			System.out.print(result[i]+",");
		}
	}
}
//Powered by [KawigiEdit] 2.0!