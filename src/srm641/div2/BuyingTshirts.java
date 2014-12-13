package srm641.div2;

public class BuyingTshirts
{
	public int meet(int T, int[] Q, int[] P)
	{
		int pSum = 0;
		int qSum = 0;
		int ans = 0;
		for (int i=0; i<Q.length; i++) {
			pSum +=P[i];
			qSum +=Q[i];
			if(pSum>=T && qSum>=T) {
				pSum-=T;
				qSum-=T;
				ans+=1;
			}
			else if (pSum>=T) {
				pSum-=T;
			}
			else if (qSum>=T) {
				qSum-=T;
			}
		}
		return ans;
	}
	
	
}