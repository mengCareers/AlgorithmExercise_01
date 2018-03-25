/*
n's
ones complement : ~n
n's
twos complement : ~n + 1 = -n
 * Thought Process:
 * 
 */
package BitManipulation;

/**
 *
 * @author xinrong
 */
public class BitLec {

    public static void main(String[] args) {
        BitLec inst = new BitLec();
        // inst.setPosOne(12, 3);
        // int ans = inst.cntOnes(12);
        int ans = inst.cntDif(12, 8);
        System.out.println(ans);
    }

    /**
     * 
     * @param n
     * @param pos pos th (from right)
     * @return 
     */
    public boolean isPosSetOne(int n, int pos) {
        if ((n & (1 << (pos - 1))) > 0) {
            return true;
        }
        return false;
    }

    /**
     * n : *****1*** 
     * mask:111110111 <= ~000001000 
     * n = n & mask @param n @param
     * pos
     *
     */
    public int setPosOne(int n, int pos) {
        n = (~(1 << (pos - 1))) & n;
        return n;
    }

    /** M1
     * n :  *****1101**
     *           S  E
     * mask:00000111100 <= 00000001111, 1111 <= ( 111 << 1 + 1 ..)
     * n = n & mask
     * @param n
     * @param S index
     * @param E index
     *  M2
     * mask:00000111111 n = n & mask
     *      11111111100 n = n & mask
     */
    public int keepStoE(int n, int S, int E) {
        int len = S - E;
        int mask = 1;
        for (int i = 0; i < len; i++) {
            mask = (mask << 1) + 1;
        }
        mask = mask << E;
        n = n & mask;
        return n;
    }
    
    /** M1
     * n :  *****1101**
     *           S  E
     * mask:11111000011 <= ~00000111100, 1111 <= ( 111 << 1 + 1 ..)
     * n = n & mask
     * @param n
     * @param S
     * @param E 
     */
    public int clearStoE(int n, int S, int E) {
        int len = S - E;
        int mask = 1;
        for (int i = 0; i < len; i++) {
            mask = (mask << 1) + 1;
        }
        mask = ~(mask << E);
        n = n & mask;
        return n;
    }

    /**
     * n    :1101010
     * n - 1:1101001
     * n =   1101000
     * n = n & (n - 1)
     * @param n 
     */
    public int resetLastOnetoZero(int n) {
        n = n & (n - 1);
        return n;
    }
    
    public int cntOnes(int n) {
        int cnt = 0;
        while (n != 0) {
            n = resetLastOnetoZero(n);
            cnt++;
        }
        return cnt;
    } 
    
    /**
     * 
     * @param n
     * @return true if the only 1 is in the first <= power of 2
     */
    public boolean isPowerofTwo (int n) {
        return (n & (n - 1)) == 0;
    }
    
    /**
     * XOR
     * cntOnes
     * @param n1
     * @param n2
     * @return 
     */
    public int cntDif(int n1, int n2) {
        int difn = n1 ^ n2;
        return cntOnes(difn);
    }
    
    /**
     * 
     * @param n
     * @return true if n is equal to reverse of n
     */
    public boolean isPalindrome(int n) {
        return reverse(n) == n;
    }
    
    /**
     * 1101 
     * 1011
     * @param n
     * @return 
     */
    private int reverse(int n) {
        int res = 0;
        int t = 0;
        while (n > 0) {
            res += n & 1; 
            res = res << 1; 
            n  = n >> 1;
        }
        return res;
    }
    
    /**
     * assume 4 bytes : 5555
     * @param n
     * @return 
     */
    public int swapOddEven(int n) {
        // get even values | mask 5 (0101)
        int evens = n & (5555);
        // << 1 = A
        evens = evens << 1;
        // get odd values | mask 10 (1010)
        int odds = n & (10101010);
        // >> 1 = B
        odds = odds >> 1;
        // A plus B 
        return odds | evens;
    }

    /**
     * n    :10110110
     *         S  E
     * mask :
     *       01000000   -1
     *       00111111
     *      
     * mask :11000011
     * 
     * @param n
     * @param s
     * @param R len = s - e + 1
     * @return 
     */
    public int replaceStoEwithR(int n, int s, int e, int R) {
        // clear S to E <= S + len(R)
        int tn = clearStoEUtil(n, s, e);
        // R << E
        R = R << e;
        // | them
        return tn | R;
    }
    
    private int clearStoEUtil(int n, int s, int e) {
        int mask = 1 << s;
        mask = mask - 1;
        int mask2 = ~((1 << e) - 1);
        return mask & mask2;
    }
    
   
}
