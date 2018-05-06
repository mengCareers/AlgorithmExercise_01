/* 678. Valid Parenthesis String
Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
An empty string is also valid.
 * 
 */
package Stack;

import java.util.Stack;

/**
 *
 * @author xinrong
 */
public class ValidParenthesisString {

    public boolean checkValidString(String s) {
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    leftStack.push(i);
                    break;
                case ')':
                    if (!leftStack.isEmpty()) {
                        leftStack.pop();
                    } else if (!starStack.isEmpty()) {
                        starStack.pop();
                    } else {
                        return false;
                    }
                    break;
                default:
                    starStack.push(i);
                    break;
            }
        }
        while (!leftStack.isEmpty() && !starStack.isEmpty()) {
            int li = leftStack.pop();
            int si = starStack.pop();
            if (si < li) {
                return false;
            }
        }
        if (!leftStack.isEmpty()) {
            return false;
        }
        return true;
    }
}
