/* 
str = SS
      ^    
ss  = SSSS
        ^
    = _SS_
        ^
 * Thought Process:
 * 
 */
package String;

/**
 *
 * @author xinrong
 */
public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        repeatedSubstringPattern("abcabc");
    }

    public static boolean repeatedSubstringPattern(String str) {
        String ss = str + str;
        ss =ss.substring(1, ss.length() - 1);
        return ss.contains(str);
    }
}
