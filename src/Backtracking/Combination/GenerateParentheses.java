/* 22. Generate Parentheses
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * Thought Process:
 * 
 */
package Backtracking.Combination;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author xinrong
 */
public class GenerateParentheses {
    
    public static void main(String[] args) {
        new GenerateParentheses().generateParenthesis(2);
    }

    public List<String> generateParenthesis(int n) {
        List<String> allRes = new ArrayList<>();
        // getCombUtil(n * 2, 0, "", allRes);
        System.out.println("WISE : ");
        getCombUtil("", allRes, 0, 0, n);
        System.out.println("NAIVE : ");
        getCombUtil("", allRes, n, n);
        return allRes;
    }

    private void getCombUtil(String curRes, List<String> allRes, int leftNum, int rightNum, int n) {
        // System.out.println("leftNum : " + leftNum + ", rightNum : " + rightNum);
        if (leftNum == n && rightNum == n) {
            System.out.println(curRes);
            allRes.add(curRes);
        } else {
            if (leftNum < n) {
                getCombUtil(curRes + "(", allRes, leftNum + 1, rightNum, n);
            }
            if (rightNum < leftNum) {
                getCombUtil(curRes + ")", allRes, leftNum, rightNum + 1, n);
            }
        }
    }

    private void getCombUtil(String curRes, List<String> allRes, int leftTarget, int rightTarget) {
        if (leftTarget == 0 && rightTarget == 0) {
            System.out.println(curRes);
            if (isValid(curRes)) {
                allRes.add(curRes);
            }
        } else {
            if (leftTarget > 0) {
                getCombUtil(curRes + "(", allRes, leftTarget - 1, rightTarget);
            }
            if (rightTarget > 0) {
                getCombUtil(curRes + ")", allRes, leftTarget, rightTarget - 1);
            }
        }
    }

    private void getCombUtil(int target, int lvl, String curRes, List<String> allRes) {
        if (lvl == target) {
            if (isValid(curRes)) {
                allRes.add(curRes);
            }
        } else {
            getCombUtil(target, lvl + 1, curRes + "(", allRes);
            getCombUtil(target, lvl + 1, curRes + ")", allRes);
        }
    }

    private boolean isValid(String curRes) {
        Stack<Character> stack = new Stack<>();
        for (char ch : curRes.toCharArray()) {
            if (ch == '(') {
                stack.push(')');
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pop() != ch) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
