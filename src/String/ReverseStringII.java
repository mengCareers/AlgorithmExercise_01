/* 541. Reverse String II
input : s, k
reverse the first k characters for every 2k characters
if last chunk not enough 2k,
    if (0, k), reverse all
    if [k, 2k), reverse the first k 
 * Thought Process:
 * 
 */
package String;

/**
 *
 * @author xinrong
 */
public class ReverseStringII {

    public static void main(String[] args) {
        ReverseStringII inst = new ReverseStringII();
        String s = "abceeegh";
        int k = 3;
        String res = inst.reverseStr(s, k);
        System.out.println(res);
    }

    public String reverseStr(String s, int k) {
        int si = 0;
        while (si < s.length()) {
            int ei = si + k * 2 - 1;
            if (ei < s.length()) {
                s = reverseUtil(s, si, ei - k);

            } else if (ei - k < s.length()) {
                s = reverseUtil(s, si, si + k - 1);
            } else {
                s = reverseUtil(s, si, Math.min(s.length() - 1, ei));
            }
            si = ei + 1;
        }
        return s;
    }

    private String reverseUtil(String s, int si, int ei) {
        StringBuilder sb = new StringBuilder(s.substring(si, ei + 1));
        return s.substring(0, si) + sb.reverse().toString() + s.substring(ei + 1);
    }

}
