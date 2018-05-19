/* 481.Magical String
input : n
output: # of '1' in the first n number in s
magical string s :
s consists of '1' and '2' 
concatenating the # of contiguous '1' and '2' generates s itself
 * Thought Process:
 * GET:
a(a(1) + a(2) + ... + a(k)) = (3 + (-1)k )/2
 * Next time:
it's fluffy, add pointers
The problem is actually about the Kolakoski Sequence : https://en.wikipedia.org/wiki/Kolakoski_sequence
a(a(1) + a(2) + ... + a(k)) = (3 + (-1)k )/2
When we feel that an array related problem is fluffy, we'd better add pointers to make things clear.
In my solution, there are two pointers : cntAppendNum, posToAppend
That is, we need to append kSeq[cntAppendNum] * numToAppend starting from index posToAppend.
Whenever the numToAppend equals to 1, cntOne plus one.
Attention that the length of kSeq should be n + 1, or else array index will be out of bounds when build the last digit.
 */
package String;

/**
 *
 * @author xinrong
 */
public class MagicalString {

    public int magicalString(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 3) {
            return 1;
        }
        int[] kSeq = new int[n + 1];
        kSeq[0] = 1;
        kSeq[1] = 2;
        kSeq[2] = 2;
        int cntAppendNum = 2; // the position to generate numbers to append
        int posToAppend = 3; // the position to append
        int cntOne = 1;
        int numToAppend = 1;
        while (posToAppend < n) {
            for (int i = 0; i < kSeq[cntAppendNum]; i++) {
                kSeq[posToAppend] = numToAppend;
                if (numToAppend == 1 && posToAppend < n) {
                    cntOne++;
                }
                posToAppend++;
            }
            numToAppend = 3 - numToAppend;
            cntAppendNum++;
        }
        return cntOne;
    }
}
