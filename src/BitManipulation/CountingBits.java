package BitManipulation;

/* 338.Counting Bits
input : num
output: arr[], arr[i] is # of 1's in binary representation of i (i in the rang 0 <= i <= num)
 * Thought Process:
 * 
 */

/**
 *
 * @author xinrong
 */
public class CountingBits {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; ++i) 
            res[i] = countUtil(i);
        return res;
    }    
    private int countUtil(int i) {
        int cnt = 0;
        while (i > 0) {
            cnt++;
            i = i & (i - 1);
        }
        return cnt;
    }
}
