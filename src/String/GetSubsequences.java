/*
 * Thought Process:
 * 
 */
package String;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author xinrong
 */
public class GetSubsequences {

    public static void main(String[] args) {
        GetSubsequences inst = new GetSubsequences();
        Set<String> res = inst.getSubsequences("abc");
        System.out.println(res);
    }

    Set<String> result;

    public Set<String> getSubsequences(String str) {
        result = new HashSet<>();
        getSubsequencesUtil(str);
        return result;
    }

    private void getSubsequencesUtil(String str) {
        for (int i = 0; i < str.length(); i++) {
//            for (int j = str.length(); j >= i; j--) {
            for (int j = i; j <= str.length(); j++) {
                String substr = str.substring(i, j);
                if (!result.contains(substr)) {
                    result.add(substr);
                }
                // drop character at index k
                for (int k = 1; k < substr.length() - 1; k++) {
                    StringBuilder sb = new StringBuilder(substr);
                    sb.deleteCharAt(k);
                    if (!result.contains(sb)) {
                        getSubsequencesUtil(sb.toString());
                    }
                }
            }
        }
    }

}
