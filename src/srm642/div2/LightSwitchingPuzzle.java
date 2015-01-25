package srm642.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LightSwitchingPuzzle {

	public int minFlips(String state)
	{
		int a = allYs(state);
		int b = allNs(state);
		return Math.min(a+1, b);
	}
	
	private int allYs(String s) {
		/*StringBuffer desired = new StringBuffer(s.length());
		for (int i=0; i<s.length(); i++) {
			desired.append('Y');
		}*/
		int ans = 0;
		StringBuffer sb = new StringBuffer(s);
		for (int i=0; i<sb.length(); i++) {
			if(sb.charAt(i)=='N') {
				ans++;
				for (int j=i; j<s.length(); j+=(i+1)){
					sb.setCharAt(j, sb.charAt(j)=='Y'?'N':'Y');
				}
			}
		}
		return ans;
	}
	
	private int allNs(String s) {
		/*StringBuffer desired = new StringBuffer(s.length());
		for (int i=0; i<s.length(); i++) {
			desired.append('N');
		}*/
		int ans = 0;
		StringBuffer sb = new StringBuffer(s);
		for (int i=0; i<sb.length(); i++) {
			if(sb.charAt(i)=='Y') {
				ans++;
				for (int j=i; j<s.length(); j+=(i+1)){
					sb.setCharAt(j, sb.charAt(j)=='Y'?'N':'Y');
				}
			}
		}
		return ans;
	}
	
	public static void main(String args[]) throws IOException {
		LightSwitchingPuzzle fa = new LightSwitchingPuzzle();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("Expression: ");
			String exp = br.readLine();
			System.out.println(fa.minFlips(exp));
		}
	}
}
