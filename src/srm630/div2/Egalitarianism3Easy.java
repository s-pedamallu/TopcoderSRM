package srm630.div2;

import java.util.Iterator;

/**
 * Created by shashank on 8/21/14.
 */
public class Egalitarianism3Easy {
    public int maxCities(int numCities, int[] src, int[] dest, int[] len) {
        HashMap<String,Integer> allDistances = new HashMap<String,Integer>();
        for(int i=1; i<numCities; i++) {
            for(int j=i+1; j<=numCities; j++) {
                String key = i+"-"+j;
                allDistances.put(key,Integer.MAX_VALUE);
            }
        }
        int min=Integer.MAX_VALUE;
        for (int i=0; i<numCities-1; i++){
            String key = src[i]+"-"+dest[i];
            allDistances.put(key,len[i]);
        }

        for(int i=1; i<numCities; i++) {
            for(int j=i+1; j<=numCities; j++) {
                
            }
        }

    }
}
