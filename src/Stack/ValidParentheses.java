/*20. Valid Parentheses
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
determine if the input string is valid.
 * Thought Process:
 * 
 */
package Stack;

import java.util.Stack;

/**
 *
 * @author xinrong
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else {
                if (stack.empty()) {
                    return false;
                }
                if (stack.pop() != c) {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
