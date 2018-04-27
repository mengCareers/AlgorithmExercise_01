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
        Stack<Integer> leftIndices = new Stack<>();
        Stack<Integer> starIndices = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    leftIndices.push(i);
                    break;
                case ')':
                    if (!leftIndices.empty()) {
                        leftIndices.pop();
                    } else if (!starIndices.empty()) {
                        starIndices.pop();
                    } else {
                        return false;
                    }
                    break;
                default:
                    starIndices.push(i);
                    break;
            }
        }
        while (!leftIndices.empty()) {
            int lefti = leftIndices.pop();
            if (starIndices.empty() || starIndices.pop() < lefti) {
                return false;
            }
        }
        return true;
    }
}
