package srm632.div2;

/**
 * Created by shashank on 9/19/14.
 */
public class RunningAroundPark
{
    public int numberOfLap(int N, int[] d)
    {
        int ans = 1;
        for (int i=0; i<d.length-1; i++) {
            if(d[i]>=d[i+1]){
                ans++;
            }
        }
        return ans;
    }


}

