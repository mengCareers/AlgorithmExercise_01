/* 394. Decode String
s = "3[a2[c]]", return "accaccacc".
 * Thought Process:
if [, push
if ], pop
 * 
 */
package Stack;

import java.util.Stack;

/**
 *
 * @author xinrong
 */
public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> cntstack = new Stack<>();
        Stack<String> strstack = new Stack<>();
        char[] c = s.toCharArray();
        int i = 0;
        String str = "";
        while (i < c.length) {
            if (Character.isDigit(c[i])) {
                int cnt = 0;
                while (Character.isDigit(c[i])) {
                    cnt = cnt * 10 + (c[i] - '0');
                    i++;
                }
                cntstack.push(cnt);
            }
            
            else if (c[i] == '[') {
                strstack.push(str);
                str = "";
                i++;
            }
            else if (c[i] == ']') {
                StringBuilder sb = new StringBuilder(strstack.pop());
                int rep = cntstack.pop();
                for (int r = 0; r < rep; r++)
                    sb.append(str);
                str = sb.toString();
                i++;
            }
            else {
                str += c[i];
                i++;
            }
        }
        return str;
    }    
}
