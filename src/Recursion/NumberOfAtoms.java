/* 726.
input : formula
output: count of all elements as a string in the following form :
        H2O, i.e., the first name, followed by its count (if > 1),
                                   followed by 2nd name..
 * Thought Process:
e.g. K4(ON(SO3)2)2
K4(O1N1(S1O3)2)2



STACK
K4  O2 N2  S4 O12 
O12 S4 N2 O2 K4
S4 N2 O14 K4
K4 N2 O14 S4 
in sorted order

Instead of recursion, we can simulate the call stack by using a stack of counts directly
does it mean that, all stack related, can be replaced by recursion

parse that parses the formula from index i,
 * 
 */
package Recursion;

import java.util.Stack;

/**
 *
 * @author xinrong
 */
public class NumberOfAtoms {
    
    

    public static void main(String[] args) {
        NumberOfAtoms inst = new NumberOfAtoms();
        String str = inst.countOfAtoms("K4(ON(SO3)2)2");
        System.out.println(str);
    }

    public String countOfAtoms(String formula) {
        // change K4(ON(SO3)2)2 to K4(O1N1(S1O3)2)2
        StringBuilder sbFormula = new StringBuilder();
        char[] chFormula = formula.toCharArray();
        int i = 0;
        for (; i < chFormula.length - 1; i++) {
            sbFormula.append(chFormula[i]);
            if (chFormula[i] != '(' && chFormula[i] != ')') {
                if (chFormula[i + 1] >= 'a' && chFormula[i + 1] <= 'z' || Character.isDigit(chFormula[i + 1])) {
                } else {
                    if (!Character.isDigit(chFormula[i])) {
                        sbFormula.append("1");
                    }
                }
            }
        }
        sbFormula.append(chFormula[i]);
        Stack<String> stack = new Stack<>();
        // put K4(O1N1(S1O3)2)2 into Stack
        int left = 0;
        int ptrChStart = 0, ptrNum = 0, curNum = 0;
        while (ptrNum < sbFormula.length()) {
            curNum = 0;
            if (sbFormula.charAt(ptrNum) == '(') {
                left++;
            }
            while (Character.isDigit(sbFormula.charAt(ptrNum))) {
                curNum = curNum * 10 + sbFormula.charAt(ptrNum);
                ptrNum++;
            }
            StrNum strnum = new StrNum(sbFormula.substring(ptrChStart, ptrNum), curNum);
            stack.push();
        }
        return sbFormula.toString();
    }

    class StrNum {

        String str;
        int num;

        public StrNum(String str, int num) {
            this.str = str;
            this.num = num;
        }
    }
}
