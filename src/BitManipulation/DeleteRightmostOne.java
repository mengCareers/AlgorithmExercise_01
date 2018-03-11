/* x & (x - 1) = x DeleteRightmostOne
e.g. x = 12 = 1100
    x-1= 11 = 1011
    1100 & 1011 = 1000 = 1100(12) DeleteRightmostOne
 * Thought Process:
 * 
 */
package BitManipulation;

/**
 *
 * @author xinrong
 */
public class DeleteRightmostOne {

    public static void main(String[] args) {
        System.out.println(new DeleteRightmostOne().count1s(0));
    }

    /**
     * 如果要将整数A转换为B，需要改变多少个bit位
     * @param a
     * @param b
     * @return 
     */
    public int bitSwapRequired(int a, int b) {
        //= A和B有多少个BIT位不相同 = cnt1s(a ^ b)
        return count1s(a ^ b);
    }

    /**
     * 计算在一个 32 位的整数的二进制表式中有多少个 1
     * @param n
     * @return
     */
    public int count1s(int n) {
        int cnt = 0;
        while (n != 0) {
            n = deleteRightmostOne(n);
            //if (n != 0)
            cnt++;
        }
        return cnt;
    }

    /**
     * 用 O(1) 时间检测整数 n 是否是 2 的幂次 return true if n is power of 2
     *
     * @param n
     * @return
     */
    public boolean isPowerOf2(int n) {
        // n > 0 && n 二进制只有一个 1
        if (n <= 0) {
            return false;
        }
        // if 二进制只有一个 1, DeleteRightmostOne, should 00000000
        return deleteRightmostOne(n) == 0;
    }

    private int deleteRightmostOne(int x) {
        return x & (x - 1);
    }
}
