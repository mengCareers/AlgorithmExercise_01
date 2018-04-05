/*
Given a string S, 
we can transform every letter individually to be lowercase or uppercase to create another string.  
Return a list of all possible strings we could create.
Examples:
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"
Output: ["3z4", "3Z4"]

Input: S = "12345"
Output: ["12345"]
 * Thought Process:
collect all chs, permute, and insert ori numbers
e.g.
    a        A
  b   B    b    B
 * 
 */
package Backtracking.PermutationRelated;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class LetterCasePermutation {

    public List<String> letterCasePermutation(String S) {
        List<String> allRes = new ArrayList<>();
        char[] chs = S.toCharArray();
        permute("", chs, allRes, 0);
        // permuteIte("", chs, allRes, 0);
        return allRes;
    }

    static int execTime = 0;

    private void permute(String curRes, char[] chs, List<String> allRes, int start) {
        if (curRes.length() == chs.length) {

            System.out.println(curRes);
            allRes.add(curRes);
            return;
        }

//        execTime++;
//        System.out.println("exec : " + execTime);
        System.out.println(curRes);

        if (start < chs.length) {
            permute(curRes + chs[start], chs, allRes, start + 1);
            if ('a' <= chs[start] && chs[start] <= 'z') {
                permute(curRes + Character.toUpperCase(chs[start]), chs, allRes, start + 1);
            } else if ('A' <= chs[start] && chs[start] <= 'Z') {
                permute(curRes + Character.toLowerCase(chs[start]), chs, allRes, start + 1);
            }
        }
    }

    private void permuteIte(String curRes, char[] chs, List<String> allRes, int start) {
        if (curRes.length() == chs.length) {
            allRes.add(curRes);
            return;
        }

//        execTime++;
//        System.out.println("exec : " + execTime);
        System.out.println(curRes);

        for (int i = start; i < chs.length; i++) {
            permute(curRes + chs[i], chs, allRes, i + 1);
            if ('a' <= chs[i] && chs[i] <= 'z') {
                permuteIte(curRes + Character.toUpperCase(chs[i]), chs, allRes, i + 1);
            } else if ('A' <= chs[i] && chs[i] <= 'Z') {
                permuteIte(curRes + Character.toLowerCase(chs[i]), chs, allRes, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        String S = "a1b2";
        List<String> ans = new LetterCasePermutation().letterCasePermutation(S);
        System.out.println(ans);
    }

//                            _ooOoo_  
//                           o8888888o  
//                           88" . "88  
//                           (| -_- |)  
//                            O\ = /O  
//                        ____/`---'\____  
//                      .   ' \\| |// `.  
//                       / \\||| : |||// \  
//                     / _||||| -:- |||||- \  
//                       | | \\\ - /// | |  
//                     | \_| ''\---/'' | |  
//                      \ .-\__ `-` ___/-. /  
//                   ___`. .' /--.--\ `. . __  
//                ."" '< `.___\_<|>_/___.' >'"".  
//               | | : `- \`.;`\ _ /`;.`/ - ` : | |  
//                 \ \ `-. \_ __\ /__ _/ .-` / /  
//         ======`-.____`-.___\_____/___.-`____.-'======  
//                            `=---='  
//  
    public List<String> NAIVE_letterCasePermutation(String S) {
        char[] chs = S.toCharArray();
        List<Integer> chIdx = new ArrayList<>();

        for (int i = 0; i < chs.length; i++) {

            if (Character.isDigit(chs[i])) {
                continue;
            }
            chIdx.add(i);
        }
        List<String> allRes = new ArrayList<>();
        if (chIdx.size() == 0) {
            allRes.add(S);
            return allRes;
        }
        permute("", S, allRes, chIdx, 0);
        return allRes;
    }

    private void permute(String curRes, String S, List<String> allRes, List<Integer> chIdx, int start) {
        if (curRes.length() == chIdx.size()) {
            StringBuilder sb = new StringBuilder();
            int si = 0;
            int ci = 0;
            while (ci < chIdx.size()) {
                while (si < chIdx.get(ci)) {
                    sb.append(S.charAt(si++));
                }
                sb.append(curRes.charAt(ci++));
                si++;
            }
            while (si < S.length()) {
                sb.append(S.charAt(si++));
            }
            allRes.add(sb.toString());
            return;
        }

        if (start < chIdx.size()) {
            permute(curRes + Character.toUpperCase(S.charAt(chIdx.get(start))), S, allRes, chIdx, start + 1);
            permute(curRes + Character.toLowerCase(S.charAt(chIdx.get(start))), S, allRes, chIdx, start + 1);
        }
    }

}
