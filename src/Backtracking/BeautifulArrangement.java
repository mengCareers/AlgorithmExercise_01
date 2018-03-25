/* 526.Beautiful Arrangement
 * Thought Process:
 * GOOD GOOD, BUT TLE
 * How to solve it? We don't really need to list the resources.
 * we just test each digit in a resource, if valid throught the end
 * then the resource is valid
 */
package Backtracking;

/**
 *
 * @author xinrong
 */
public class BeautifulArrangement {

    int cnt = 0;

    public int countArrangement(int N) {
        if (N == 0) {
            return 0;
        }
        permuteUtil(N, 1, new boolean[N + 1]);
        return cnt;
    }

    private void permuteUtil(int N, int pos, boolean[] used) {
        if (pos > N) {
            cnt++;
        } else {
            for (int i = 1; i <= N; i++) {
                if (!used[i] && (i % pos == 0 || pos % i == 0)) {
                    used[i] = true;
                    permuteUtil(N, pos + 1, used);
                    used[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        int ans = new BeautifulArrangement().countArrangement(11);
        System.out.println(ans);
    }
    /*
    int cnt = 0;
    
    public int countArrangement(int N) {
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = i + 1;
        }
        
        permuteUtil(new int[N], 0, nums);
        return cnt;
    }
    
    private void permuteUtil(int[] order, int curheight, int[] nums) {
        if (curheight == nums.length) {
            int[] curres = printOrderArr(order, nums);
            if (isBeautiful(curres)) {
                cnt++;
            }
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isValid(order, curheight, i)) {
                order[curheight] = i;
                permuteUtil(order, curheight + 1, nums);
            }
        }
    }
    
    private int[] printOrderArr(int[] order, int[] nums) {
        int[] res = new int[order.length];
        int ri = 0;
        for (int i : order) {
            res[ri++] = nums[i];
        }
        return res;
    }
    
    private boolean isValid(int[] res, int curptr, int i) {
        for (int k = 0; k < curptr; k++) {
            if (res[k] == i) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isBeautiful(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                continue;
            if (!((i + 1) % arr[i] == 0 && (i + 1) / arr[i] != 0)
                    && !(arr[i] % (i + 1) == 0 && arr[i] / (i + 1) != 0))
                return false;
        }
        return true;
    } 
     */

}
