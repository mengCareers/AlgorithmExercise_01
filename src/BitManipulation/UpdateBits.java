/*
input : n
        m
        i 右数第i位
        j 右数第j位
output: update n such that m is n 从第i位为开始到第j位的子串
e.g. 
n = (1024)10 = (00000000000000000000010000000000)2; 
m =   (21)10 = (00000000000000000000000000010101)2; 
i = 2, j = 6,
res :           00000000000000000000010001010100 = `(1108)10`
 * Thought Process:
       0 | x = x 
    =>   n 从第i位为开始到第j位 置0  | (m << i)
    =>   n & 从第i位为开始到第j位=0其余=1的      | (m << i)
    =>   n & (~(从第i位为开始到第j位=1其余=0的)) | (m << i)
    =>  (~(从第i位为开始到第j位=1其余=0的)) = ~(((-1) << (31 - j) >>> (31 - j + i) << i)
       
 * 
 */
package BitManipulation;

/**
 *
 * @author xinrong
 */
public class UpdateBits {

    public static void main(String[] args) {
        System.out.println(new UpdateBits().updateBits(1024, 21, 2, 6));
    }
    
    public int updateBits(int n, int m, int i, int j) {
       return n & (~((((-1) << (31 - j)) >>> (31 - j + i)) << i)) | (m << i);
    }
}
