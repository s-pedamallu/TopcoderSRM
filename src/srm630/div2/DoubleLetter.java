package srm630.div2;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by shashank on 8/21/14.
 */
public class DoubleLetter {

    public String ableToSolve(String src) {
        boolean modified = true;
        while (modified) {
            StringBuffer newStr = new StringBuffer();
            modified = false;
            for (int i=0; i<src.length(); i++){
                if(!modified && i+1<src.length() && src.charAt(i)==src.charAt(i+1)) {
                    i++;
                    modified = true;
                    continue;
                }else {
                    newStr.append(src.charAt(i));
                }
            }
            src = newStr.toString();
        }
        if (src.length()>0)
            return "Impossible";
        else
            return "Possible";
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(new DoubleLetter().ableToSolve(input));
    }
}
