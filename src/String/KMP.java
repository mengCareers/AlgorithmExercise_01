/*
 * Thought Process:
 * 
 */
package String;

/**
 *
 * @author xinrong
 */
public class KMP {

    public static void main(String[] args) {
        String s = "dabcdzadz";
        String p = "dzb";
        int idx = findPinS(p, s);
        System.out.println(p + " firstly occurr at index " + idx + " of " + s);
    }

    // build next[]
    private static int[] buildNext(String p) {
        int[] next = new int[p.length() + 1];
        int pi = 0;
        int li = -1; // len
        next[pi] = li;

        while (pi < p.length()) {
            // WE AIM TO calculate next[pi + 1] 
            // 若此时i=3，那我们接下来要求解的便是P[0]...p[3]的最长相同前后缀的长度，也就是next[4]，而非next[3]
            if (li == -1 || p.charAt(pi) == p.charAt(li)) {
                pi++;
                li++;
                next[pi] = li;
            } else {
                li = next[li];
            }
        }
        return next;
    }

    /**
     *
     * @param p pattern
     * @param s main string
     * @return the first occurrence of p in s, -1 not match
     */
    public static int findPinS(String p, String s) {
        int[] next = buildNext(p);
        int pi = 0, si = 0;
        while (si < s.length() && pi < p.length()) {
            if (pi == -1 || s.charAt(si) == p.charAt(pi)) {
                si++;
                pi++;
            } else {
                pi = next[pi];
            }
        }

        if (pi == p.length()) {
            return si - pi;
        }

        return -1;
    }
}
