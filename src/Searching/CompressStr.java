/*
 * Thought Process:
 * 
 */
package Searching;

/**
 *
 * @author xinrong
 */
public class CompressStr {
    
    public static void main(String[] args) {
        String ans = new CompressStr().compress("abddddddde");
        System.out.println(ans);
    }
    
    public String compress(String s) {
        if (s == null || s.length() <= 1)
            return s;
        int cnt = 1;
        char ch = s.charAt(0);
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
                cnt++;
            }
            else {
                sb.append(ch).append(cnt);
                cnt = 1;
                ch = s.charAt(i);
            }
        }
        sb.append(ch).append(cnt);
        if (sb.length() >= s.length())
            return s;
        return sb.toString();
    }
}
