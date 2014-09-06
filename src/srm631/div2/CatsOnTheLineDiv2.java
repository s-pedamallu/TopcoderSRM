package srm631.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by shashank on 9/6/14.
 */
public class CatsOnTheLineDiv2 {
    public String getAnswer(int[] pos, int[] count, int time) {
        arrangeInProperOrder(pos,count);
        boolean res = checkPossibility(pos, count, time);
        if(res) {
            return "Possible";
        }else {
            return "Impossible";
        }
    }

    private void arrangeInProperOrder(int[] pos, int[] count) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0; i<pos.length; i++){
            map.put(pos[i],count[i]);
        }
        Arrays.sort(pos);
        for(int i=0; i<pos.length; i++){
            count[i] = map.get(pos[i]);
        }
    }


    private boolean checkPossibility(int[] pos, int[] count, int time){
        int nextFreePos = Integer.MIN_VALUE;
        for(int i=0; i<pos.length; i++){
            int leftMost = pos[i]-time;
            if(leftMost>=nextFreePos) {
                int excess = count[i]-time;
                if(excess > time+1){
                    return false;
                }else {
                    nextFreePos = pos[i]+excess;
                }
            }else{
                nextFreePos += count[i];
                if(nextFreePos-pos[i]-1>time){
                    return false;
                }
            }
        }
        return true;
    }

    // For debugging
    public static void main(String[] args) throws IOException{
        CatsOnTheLineDiv2 obj = new CatsOnTheLineDiv2();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter positions array:");
        String input = br.readLine();
        String[] tmp = input.split(", ");
        int[] pos = new int[tmp.length];
        int[] catCount = new int[tmp.length];
        for (int i=0 ; i<tmp.length; i++) {
            pos[i] = Integer.parseInt(tmp[i]);
        }
        System.out.println("Enter cat count array:");
        input = br.readLine();
        tmp = input.split(", ");
        for (int i=0 ; i<tmp.length; i++) {
            catCount[i] = Integer.parseInt(tmp[i]);
        }
        System.out.println("Enter time limit:");
        input = br.readLine();
        int time = Integer.parseInt(input);
        System.out.println(obj.getAnswer(pos,catCount,time));
    }

    // TestCase 1:
    // pos: 5, 1, -10, 7, 12, 2, 10, 20
    // count: 3, 4, 2, 7, 1, 4, 3, 4
    // time: 6
}
