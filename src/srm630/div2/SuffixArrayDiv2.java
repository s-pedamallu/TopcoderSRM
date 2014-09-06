package srm630.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by shashank on 9/4/14.
 */
public class SuffixArrayDiv2 {
    private String newString;
    public String smallerOne(String ref) {
        HashMap<String, Integer> suffixMap = new HashMap<String, Integer>();
        String[] suffixes = getAllSuffixes(ref, suffixMap);
        int[] suffixArray = getSuffixArray(suffixes, suffixMap);
        boolean result = checkSmallerString(ref, suffixArray, suffixes, suffixMap);
        if(result) {
            System.out.println("Smaller string with same suffix array is: "+newString);
            return "Exists";
        }else{
            return "Does not exist";
        }
    }

    private String[] getAllSuffixes(String ref, HashMap<String,Integer> suffixMap) {
        String[] strArray = new String[ref.length()];
        for(int i=0; i<ref.length(); i++){
            strArray[i] = new String(ref.substring(i,ref.length()));
            suffixMap.put(strArray[i],i);
        }
        return strArray;
    }

    private int[] getSuffixArray(String[] suffixes, HashMap<String,Integer> suffixMap) {
        int[] order = new int[suffixes.length];
        Arrays.sort(suffixes);
        for(int i=0; i<suffixes.length; i++){
            order[i]=suffixMap.get(suffixes[i]);
        }
        return order;
    }

    private boolean checkSmallerString(String ref,int[] originalSuffixArray, String[] suffixes, HashMap<String,Integer> suffixMap){
        for(int k=0; k<suffixes.length; k++){
            String base = suffixes[k];
            int charPos = suffixMap.get(base);
            for (int i=0; i<base.length(); i++) {
                char toChange = base.charAt(i);
                if(toChange=='a') {
                    continue;
                }
                toChange--;
                StringBuffer sb = new StringBuffer(ref.substring(0,charPos+i));
                sb.append(toChange);
                sb.append(ref.substring(charPos+i+1,ref.length()));
                newString = sb.toString();
                HashMap<String,Integer> tmpSuffixMap = new HashMap<String, Integer>();
                String[] newSuffixes = getAllSuffixes(newString,tmpSuffixMap);
                int[] newSuffixArray = getSuffixArray(newSuffixes,tmpSuffixMap);
                if(isSame(originalSuffixArray,newSuffixArray)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isSame(int[] one, int[] two) {
        for(int i=0; i<one.length; i++){
            if(one[i]!=two[i]){
                return false;
            }
        }
        return true;
    }

    // For debugging
    public static void main(String[] args) throws IOException {
        SuffixArrayDiv2 obj = new SuffixArrayDiv2();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter reference string: ");
        String input = br.readLine();
        System.out.println(obj.smallerOne(input));
    }
}
