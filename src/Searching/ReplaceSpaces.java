/*
 * Thought Process:
 * 
 */
package Searching;

/**
 *
 * @author xinrong
 */
public class ReplaceSpaces {
    public static void main(String[] args) {
        String s = "ajdk leig kal";
        String res = new ReplaceSpaces().replaceSpaces(s);
        System.out.println(res);
    }
    
    public String replaceSpaces(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append("%20");
            }
            else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
