/* 678. Valid Parenthesis String
 * Thought Process:
 * 
 */
package Backtracking;

import java.util.Stack;

/**
 *
 * @author xinrong
 */
public class ValidParenthesisString {



    public boolean checkValidStringSoso(String s) {
        return checkValid(s, 0, 0);
    }

    private boolean checkValid(String s, int start, int leftExtra) {
        if (leftExtra < 0) {
            return false;
        }
        for (int si = start; si < s.length(); si++) {
            char c = s.charAt(si);
            switch (c) {
                case '(':
                    leftExtra++;
                    break;
                case ')':
                    if (leftExtra <= 0) {
                        return false;
                    }
                    leftExtra--;
                    break;
                default:
                    return checkValid(s, si + 1, leftExtra + 1)
                            || checkValid(s, si + 1, leftExtra - 1)
                            || checkValid(s, si + 1, leftExtra);
            }
        }
        return leftExtra == 0;
    }

    public boolean checkValidStringSlowest(String s) {
        return checkValidSlowest(s, 0, 0);
    }

    private boolean checkValidSlowest(String s, int pos, int leftExtra) {
        if (pos == s.length()) {
            return leftExtra == 0;
        }

        if (leftExtra < 0) {
            return false;
        }

        char c = s.charAt(pos);
        switch (c) {
            case '(':
                return checkValidSlowest(s, pos + 1, leftExtra + 1);
            case ')':
                return checkValidSlowest(s, pos + 1, leftExtra - 1);
            default:
                return checkValidSlowest(s, pos + 1, leftExtra + 1)
                        || checkValidSlowest(s, pos + 1, leftExtra - 1)
                        || checkValidSlowest(s, pos + 1, leftExtra);
        }
    }
}
