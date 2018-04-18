/* BigIntegerMultiply
 * Thought Process:
             1  2  3  4
          *  5  6  7  8
------------------------
              9  8  7  2
          8  6  3  8
      7  4  0  4
 6  1  7  0
------------------------
 7  0  0  6  6  5  2
1234分为 12（高位）和34（低位）；5678分为56（高位）和78（低位）
高位*高位结果：12*56=672
高位*低位+低位*高位：12*78+34*56=936+1094=2840
低位*低位结果：34*78=2652

这里要拼接了。需要说明的是，刚才我们提到两位数分解成一位数相乘的规则：超过一位数，需要进位。同理（这里就不证明了），两位数乘以两位数，结果超过两位数，也要进位。
从低位开始：低两位：2652，26进位，低位保留52；
中间两位，2840+26（低位进位）=2866,28进位，中位保留66；
高位，672+28（进位）=700,7进位，高位保留00。再往上就没有了，现在可以拼接起来：
最高位进位7，高两位00，中位66，低位52，最后结果：7006652。

规律:任意位数（例如N位整数相乘），都可以用这种思想实现：
低位保留N位数字串，多余高位进位；高位要加上低位进位，
如果超过N位，依然只保留N位，高位进位。
如果是M位整数乘以N位整数怎么办？高位补0，凑成一样位数的即可，不赘述。

 * 
 */
package DivideandConquer;

/**
 *
 * @author xinrong
 */
public class BigIntegerMultiply {

    public static void main(String[] args) {
        String res = multiply("0", "81503");
        // String res = addUtil("134", "78");
        System.out.println(res);
    }

    public static final int SIZE = 4;

    public static String multiply(String s1, String s2) {
        String result = multiplyUtil(s1, s2);
        int i = 0;
        for (; i < result.length(); i++) {
            if (result.charAt(i) != '0') {
                break;
            }
        }
        return i == result.length() ? "0" : result.substring(i);
    }

    public static String multiplyUtil(String s1, String s2) {
        int formalLen = Math.max(s1.length(), s2.length());
        if (formalLen <= SIZE) {
            return String.valueOf(Integer.parseInt(s1) * Integer.parseInt(s2));
        }
        s1 = formatLen(s1, formalLen);
        s2 = formatLen(s2, formalLen);
        int sublen = formalLen / 2;
        int restlen = formalLen - sublen;
        String A = s1.substring(0, sublen);
        String B = s1.substring(sublen);
        String C = s2.substring(0, sublen);
        String D = s2.substring(sublen);
        String AC = multiplyUtil(A, C);
        String AD = multiplyUtil(A, D);
        String BC = multiplyUtil(B, C);
        String BD = multiplyUtil(B, D);

        String[] resBD = doCarry(BD, restlen);
        String ADBC = addUtil(AD, BC);
        ADBC = addUtil(ADBC, resBD[1]);

        String[] resADBC = doCarry(ADBC, restlen);
        AC = addUtil(AC, resADBC[1]);

        return AC + resADBC[0] + resBD[0];
    }

    private static String formatLen(String s, int formalLen) {
        while (s.length() < formalLen) {
            s = "0" + s;
        }
        return s;
    }

    private static String[] doCarry(String res, int len) {
        String[] resStr = new String[2];
        if (res.length() > len) {
            resStr[0] = res.substring(res.length() - len);
            resStr[1] = res.substring(0, res.length() - len);

        } else {
            resStr[0] = formatLen(res, len);
            resStr[1] = "0";
        }
        return resStr;
    }

    private static String addUtil(String s1, String s2) {
        if (s1.length() < s2.length()) {
            return addUtil(s2, s1);
        }
        int offset = s1.length() - s2.length();
        StringBuilder sb = new StringBuilder();
        int carry = 0, csum = 0, c1 = 0, c2 = 0, j = 0;
        for (int i = s2.length() - 1; i >= 0; i--) {
            j = i + offset;
            c1 = s1.charAt(j) - '0';
            c2 = s2.charAt(i) - '0';
            csum = c1 + c2 + carry;
            sb.append(csum % 10);
            carry = csum / 10;
        }
        for (int i = offset - 1; i >= 0; i--) {
            c1 = s1.charAt(i) - '0';
            csum = c1 + carry;
            sb.append(csum % 10);
            carry = csum / 10;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

}
