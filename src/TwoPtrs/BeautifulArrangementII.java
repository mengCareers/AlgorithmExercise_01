/* 667. Beautiful Arrangement II
*boolean flag* : 
true if k is even initially, if k is even, we start from E.
also used as swithch flag to indicate it is either S's turn or  E's turn
*int cntK* :
times of execution in switch pattern
if k != n-1, we do switch pattern k times only, then list the left values increasingly
 * Thought Process:
 * 
 */
package TwoPtrs;

/**
 *
 * @author xinrong
 */
public class BeautifulArrangementII {

    public static void main(String[] args) {
        int[] res = constructArray(9, 8);
        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int[] constructArray(int n, int k) {
        int s = 1, e = n;
        int[] res = new int[n];
        int ri = 0;
        boolean flag = false;
        if (k % 2 == 0) {
            flag = true;
        }
        int cntK = 0;
        while (s <= e) {
            if (!flag) {
                res[ri++] = s;
                s++;
                flag = true;
                cntK++;
            } else {
                res[ri++] = e;
                e--;
                flag = false;
                cntK++;
            }
            if (cntK == k) {
                break;
            }
        }
        for (int i = s; i <= e; i++) {
            res[ri++] = i;
        }
        return res;
    }

}
