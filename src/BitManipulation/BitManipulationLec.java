/*
-1的二进制表示是32位1
0 | x = x;
1 & x = x;
0 & x = 0;
1 | x = 1;
^ 不进位加法
>>> 负数变正数
 * Thought Process:
 * 
 */
package BitManipulation;

/**
 *
 * @author xinrong
 */
public class BitManipulationLec {

    public static void main(String[] args) {
        basic();
    }

    private static void basic() {
        int a = 10; // 00001010      
        int b = 38; // 00100110

        // [二目]
        // a & b = 00000010 = 2;
        System.out.println(a & b);
        // a | b = 00101110 = 46
        System.out.println(a | b);
        // ^ 不进位加法
        // a ^ b = 00101100 = 44
        System.out.println(a ^ b);

        // [单目]
        // ~ a 首位正负颠倒
        System.out.println(~10);
        System.out.println(~-10);

        // <<
        // 00001010
        // a << 1 = 00010100 = 20 = 10 * 2的1次方 比乘法快
        // a << 2 = 00101000 = 40 = 10 * 2的2次方 比乘法快
        System.out.println(a << 3);
        // >>
        // 00001010
        // a >> 1 = 00000101 = 5 = 10 / 2的1次方
        // a >> 2 = 00000010 = 2 = 10 / 2的2次方
        System.out.println(b >> 3);
        // >>> 逻辑右移 负数变正数 正数变正数
        //111000111111000111111000111111000111 >> 1 = [1]11100011111100011111100011111100011
        //111000111111000111111000111111000111>>> 1 = [0]11100011111100011111100011111100011 default0补足 
        System.out.println(-10 >> 2);
        System.out.println(-10 >>> 2);
        
        
    }
}
