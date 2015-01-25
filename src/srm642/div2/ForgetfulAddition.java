package srm642.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ForgetfulAddition
{
	public int minNumber(String expression)
	{
		int sum = Integer.MAX_VALUE;
		for(int i=1; i<expression.length(); i++) {
			int a = Integer.valueOf(expression.substring(0,i));			
			int b = Integer.valueOf(expression.substring(i,expression.length()));
			sum = Math.min(sum,a+b);			
		}
		return sum;
	}
	
	public static void main(String args[]) throws IOException {
		ForgetfulAddition fa = new ForgetfulAddition();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("Expression: ");
			String exp = br.readLine();
			System.out.println(fa.minNumber(exp));
		}
	}
}
//Powered by [KawigiEdit] 2.0!