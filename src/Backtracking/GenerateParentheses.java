/* 22.Generate Parentheses
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 * Get:
 * rather than construct resources, we simply pass aim sz
 * to make it valid
 * we add to result set only if valid, rather than use intermediate data structure
 */
package Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author xinrong
 */
public class GenerateParentheses {

    private void generateParenthesisUtil(String par, int curheight, int sz) {
        if (curheight == sz) {
            System.out.println("par check : " + par);
            if (isValid(par)) {
                result.add(par);
            }
        } else {
            System.out.println("par : " + par);
            generateParenthesisUtil(par + '(', curheight + 1, sz);
            System.out.println("back : " + par);
            generateParenthesisUtil(par + ')', curheight + 1, sz);
        }
    }

    List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
//        List<String> resource = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            resource.add("(");
//            resource.add(")");
//        }
//        generateParenthesisUtil("", 0, resource);
//        List<String> validResult = new ArrayList<>();
//        for (String res : result) {
//
//            if (isValid(res)) {
//                validResult.add(res);
//            }
//        }
        generateParenthesisUtil("", 0, 2 * n);
        return result;
    }

    private void generateParenthesisUtil(String par, int curheight, List<String> resource) {
        if (curheight == resource.size()) {
            result.add(par);
        } else {
            for (int i = curheight; i < resource.size(); i++) {
                // par = par + resource.get(i);
                generateParenthesisUtil(par + resource.get(i), curheight + 1, resource);
                // par = par.substring(0, par.length() - 1);
            }
        }
    }

    private boolean isValid(String res) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < res.length(); i++) {
            if (res.charAt(i) == '(') {
                stack.push(')');
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pop() == '(') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        GenerateParentheses inst = new GenerateParentheses();
        List<String> result = inst.generateParenthesis(2);
        System.out.println(result);
    }
}
