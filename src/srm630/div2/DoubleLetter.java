package srm630.div2;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by shashank on 8/21/14.
 */
public class DoubleLetter {

    public String ableToSolve(String src) {

        // declare a boolean variable to determine if src has been modified in the last iteration
        boolean isModified = true;

        // Iterate if the src has been modified
        while (isModified) {
            // variable to store modified src
            StringBuffer newStr = new StringBuffer();
            isModified = false;

            // At every character, if the src is not yet modified,
            // then check if the current character is same as the next character:
            // if yes, skip copying this character
            // else, copy this character to the newStr
            for (int i=0; i<src.length(); i++){
                if(!isModified && i+1<src.length() && src.charAt(i)==src.charAt(i+1)) {
                    i++;
                    isModified = true;
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
