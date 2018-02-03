/*
 * Thought Process:
 * 
 */
package TwoPtrs;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class WindowSum {
    
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7};
        List<Integer> A = new ArrayList<>();
        for (int index = 0; index < array.length; index++)
        {
            A.add(array[index]);
        }
        List<Integer> ans = new WindowSum().getSum(A, 3);
        System.out.println(ans);
    }
    
    public List<Integer> getSum(List<Integer> A, int k) {
        List<Integer> res = new ArrayList<Integer>();
        int cnt = 0;
        for (int r = 0; r < A.size(); r++) {
            cnt++;
            if (cnt >= k) { 
                int sum = 0;
                for (int l = r; l >= r - k + 1; l--) 
                    sum += A.get(l);
                res.add(sum);
            }
        }       
        return res;
    }
}
