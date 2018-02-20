/* 151. Reverse Words in a String
 * Thought Process:
 * 
 */
package Searching;

/**
 *
 * @author xinrong
 */
public class ReverseWordOrderinSentence {
    
    public static void main(String[] args) {
        String s = "a b  c";
        String ans = new ReverseWordOrderinSentence().reverse(s);
        System.out.println(ans);
    }
    
    public String reverse(String s) {      
        if (s == null || s.length() == 0)
            return s;
        char[] arr = s.toCharArray();
        reverseUtil(arr, 0, s.length() - 1);
        int ws = 0, we = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                we = i - 1;
                reverseUtil(arr, ws, we);
                ws = i + 1;
            }
        }
        
        reverseUtil(arr, ws, s.length() - 1);
        StringBuilder sb = new StringBuilder();
        for (char c : arr)
            sb.append(c);
        return sb.toString();
    }
    
    
    private void reverseUtil(char[] arr, int lo, int hi) {
        while(lo < hi) {
            char t = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = t;
            lo++;
            hi--;
        }
    }
}
