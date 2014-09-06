package srm631.div2;

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
        int reachablePositions,catsHere;
        for (int i = 0; i < pos.length; i++) {
            for(int j=0; j<Math.min(2,pos.length); j++){
                reachablePositions = (time * 2 + 1);
                if(reachablePositions<count[i+j]){
                    return false;
                }
            }
            if(i+1<pos.length) {
                reachablePositions = (time * 2 + 1) + (pos[i + 1] - pos[i]);
                catsHere = count[i] + count[i + 1];
                if (reachablePositions < catsHere) {
                    return false;
                }
            }
            if(i>0 && i+1<pos.length) {
                reachablePositions = (time * 2 + 1) + (pos[i + 1] - pos[i - 1]);
                catsHere = count[i - 1] + count[i] + count[i + 1];
                if (reachablePositions < catsHere) {
                    return false;
                }
            }
        }
        return true;
    }
}
