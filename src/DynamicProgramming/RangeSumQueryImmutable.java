package DynamicProgramming;


import java.util.HashMap;
import java.util.Map;
import javafx.util.Pair;

/* Q: 303. Range Sum Query - Immutable
sumRange(i, j): find the sum of the elements between i and j inclusive
 * Thought Process:
 * Save num in list, Brute Force causes TLE
Get:
    - Why TLE? sumRange is called many times with the same arguments
    - How to solve it? Using hashing to save pre-computed all range sums
    ! Still TLE
    - How to solve it?    derive sumRange(i,j) from sum[j + 1] which equals to sumRange(0,j)
    - How to derive?      sumRange(i,j) = sum[j + 1] - sum[i]
    - How to build sum[]? sum[i + 1] = sum[i] + nums[i];

    arr as a 引用数据类型, can = another arr.
    class javafx.util.Pair, Pair p1 = new Pair(3, 4)
                            Pair p2 = new Pair(3, 4)
                            p1 == p2 is true
 */

/**
 *
 * @author xinrong
 */
public class RangeSumQueryImmutable {
    private int[] sum;
    
    public RangeSumQueryImmutable(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
    
    /*
    Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();
    
    public RangeSumQueryImmutable(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) { // j may = i
                sum += nums[j];
                map.put(new Pair(i, j), sum);
            }
        }
    }
    
    public int sumRange(int i, int j) {
        return map.get(new Pair(i, j));
    }
    */
}
