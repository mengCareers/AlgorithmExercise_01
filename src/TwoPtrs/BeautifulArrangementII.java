/* 667. Beautiful Arrangement II
INPUT: n, k
OUTPUT: int[]
GOAL: construct a list which contains [1, n] and is beautiful : 
                                                      -> [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has exactly k distinct integers
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
    
    public int[] constructArray_v1(int n, int k) {
        
        int s = 1, e = n, ri = 0;
        int cntK = k;
        int[] result = new int[n];
        boolean isSTurn = k % 2 != 0;
       
        while (cntK > 0) {         
            if (isSTurn) {
                result[ri++] = s;   
                s++;
            }
            else {
                result[ri++] = e;     
                e--;
            }
            isSTurn = !isSTurn;
            cntK--;
        }
        for (int val = s; val <= e; val++) {
            result[ri++] = val;
        }
        
        return result;
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
