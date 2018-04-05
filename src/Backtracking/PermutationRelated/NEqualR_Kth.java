/*
"123"
"132"
"213"
"231"
"312"
"321"
N = R = 3
return kth
 * Thought Process:
 * 
 */
package Backtracking.PermutationRelated;

/**
 *
 * @author xinrong
 */
public class NEqualR_Kth {

    public static void main(String[] args) {
        System.out.println(new NEqualR_Kth().permute(9, 24));
    }

    String res = "";
    int ki = 0;

    public String permute(int n, int k) {
        String curRes = "";
        permuteUtil(curRes, n, k);
        return res;
    }

    private void permuteUtil(String curRes, int n, int k) {
        if (n == curRes.length()) {
            ki++;
            if (ki == k) {
                res = curRes;
                return;
            }
        }

        for (int i = 0; i < n; i++) {
            if (curRes.contains(Integer.toString(i + 1))) {
                continue;
            }
            curRes += Integer.toString(i + 1);
            permuteUtil(curRes, n, k);
            curRes = curRes.substring(0, curRes.length() - 1);
        }
    }
}
