/* 679.24 Game
You have 4 cards each containing a number from 1 to 9. You need to judge whether they could operated through *, /, +, -, (, ) to get the value of 24.
The division operator / represents real division, not integer division. For example, 4 / (1 - 2/3) = 12.
Every operation done is between two numbers
You cannot concatenate numbers together
Input: [4, 1, 8, 7]
Output: True
Explanation: (8-4) * (7-1) = 24
* Get:
=> Standard backtracking template, we modify list to represent current state.
Attention : the order of removing fi, fj and adding fi, fj matters.
=> Usage of epsilon, for test case [3, 3, 8, 8], it is true when 8 / (3 - 8 / 3). 
We want real divisition rather than double division. 
Double division always return rough value, so we add Epsilon to make up the difference.
 * 
 */
package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class Game24 {

    public static void main(String[] args) {
        Game24 inst = new Game24();
        int[] nums = {4, 1, 8, 7};
        boolean res = inst.judgePoint24(nums);
        System.out.println(res);
    }

    boolean canGet24 = false;
    double epsilon = 0.001;

    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int num : nums) {
            list.add((double) num);
        }
        backtrackingUtil(list);
        return canGet24;
    }

    private void backtrackingUtil(List<Double> list) {
        if (canGet24) {
            return;
        }
        if (list.size() == 1) {
            if (Math.abs(list.get(0) - 24.0) < epsilon) {
                canGet24 = true;
            }
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < i; j++) {
                double fi = list.get(i), fj = list.get(j);
                List<Double> nxtRound = new ArrayList<>();
                
                nxtRound.addAll(Arrays.asList(fi + fj, fi - fj, fj - fi, fi * fj));
                if (Math.abs(fj) > epsilon) {
                    nxtRound.add(fi / fj);
                }
                if (Math.abs(fi) > epsilon) {
                    nxtRound.add(fj / fi);
                }
                
                list.remove(i);
                list.remove(j);
                for (Double nxt : nxtRound) {
                    list.add(nxt);
                    backtrackingUtil(list);
                    list.remove(list.size() - 1);
                }
                list.add(j, fj);
                list.add(i, fi);
            }
        }
    }
}
