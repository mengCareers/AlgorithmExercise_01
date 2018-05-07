/*
a string composed of 'L', 'R', 'X'
a move consists of either replacing 'XL' with 'LX'
                   or     replacing 'RX' with 'XR'
input : start, end
output: true if exists a sequence of moves to transform start to end
 * Thought Process:
for chars in start,
we can replace or not when meet 'XL' 
                      when meet 'RX'
 * Get :
'L' and 'R' as people facing left and right standing on one line.
'X' as an empty space.
invariant Solid : 'L' and 'R' can never cross each other
                  the start and end must be the same when reading only 'L' and 'R's
invariant Acessible : nth 'L' can never go to the right of its original position
                      nth 'R' can never go to the left  of its original position
if (start[i] != end[j])
    not solid
if (start[i] = 'L' and i < j || start[i] = 'R' and i > j)
    not accessible
 * 
 */
package MinimaxMaximin;

/**
 *
 * @author xinrong
 */
public class SwapAdjacentinLRString {

    public boolean canTransform(String start, String end) {
        int len = start.length();
        char[] s = start.toCharArray(), e = end.toCharArray();
        int si = -1, ei = -1;
        while (++si < len && ++ei < len) {
            while (si < len && s[si] == 'X') {
                si++;
            }
            while (ei < len && e[ei] == 'X') {
                ei++;
            }
            if ((si < len) ^ (ei < len)) {
                return false;
            }
            if (si < len && ei < len) {
                if (s[si] != e[ei]
                        || (s[si] == 'L' && si < ei)
                        || (s[si] == 'R' && si > ei)) {
                    return false;
                }
            }
        }
        return true;
    }
}
