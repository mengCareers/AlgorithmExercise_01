/*
 *  LC:14. Longest Common Prefix
 *  Get:
BF: all str in strs .indexOf(prefix) != -1
    prefix must be part of strs[0]
    we try strs[0], if it can't, we try substring(0, len - 1);
 */
package String;

/**
 * 
 * @author xinrong
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) 
            return "";
        
        String prefix = strs[0];
        
        for(int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) == -1) { // if -1, not contain prefix
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) 
                    return "";
            }
        }
        return prefix;
    }
    public static void main(String[] args) {
        String[] strs = {"zdabc", "cdabc"};
        String ans = new LongestCommonPrefix().longestCommonPrefix(strs);
        System.out.println(ans);
    }
}
