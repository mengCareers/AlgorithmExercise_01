/* Q : 100个连续的数【打乱】之后，随机取出1个数，要求只遍历一次，问如何最快速的判断出少了哪一个？
 * Thought Process:
+ findLostUsingXOR2
A ^ B ^ B = A ^ ( B ^ B ) = A ^ 0 = A
对于1 2 3
异或1 2
 = 3
+ findLostUsingXOR1
if # of 1 even,^ = 0 : 
0001
0010
0011
0100
0101
0110
0111
----
0000
========
0001
0010
0011
        // 0100
0101
0110
0111
----
0100
0对应位最终结果0不变，1对应位最终结果0变1，
所以两两异或，最终结果是所缺数
 */
package BitManipulation;

/**
 *
 * @author xinrong
 */
public class FindOneLost {


    
    public int findLostUsingXOR1(int[] arr) {
        int tp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            tp = tp ^ arr[i];
        }
        return tp;

    }

    public int findLost(int[] arr) {
        int[] hash = new int[100];
        for (int a : arr) {
            a = a % 100;
            hash[a]++;
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] == 0) {
                ans = i + 100 * (arr[0] / 100);
                if (ans < arr[0]) {
                    ans = i + 100 * (arr[arr.length - 1] / 100);
                }
                return ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[99];
        int ai = 0;
        for (int i = 120; i < 219; i++) {
            arr[ai++] = i;
        }
        // int ans = new FindOneLost().findLost(arr);
        int ans = new FindOneLost().findLostUsingXOR1(arr);
        System.out.println(ans);
    }
}
