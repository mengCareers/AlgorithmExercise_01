/* 678.Valid Parenthesis String
input : s
output: true if valid
 * Thought Process:
() valid
* as ( or ) or empty
 * 
 */
package String;

import java.util.Stack;

/**
 *
 * @author xinrong
 */
public class ValidParenthesisString {

    public boolean checkValidString(String s) {

        return check(s, 0, 0);

    }

    private boolean check(String s, int start, int cnt) {
        if (cnt < 0) {
            return false;
        }
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                cnt++;
            } else if (c == ')') {
                if (cnt <= 0) {
                    return false;
                }
                cnt--;
            } else if (c == '*') {
                return check(s, i + 1, cnt + 1)
                        || check(s, i + 1, cnt - 1)
                        || check(s, i + 1, cnt);
            }
        }
        return cnt == 0;
    }
}
