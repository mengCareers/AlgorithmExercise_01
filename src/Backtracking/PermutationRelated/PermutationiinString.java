/*
Given two strings s1 and s2, 
write a function to return true if s2 contains the permutation of s1. 
In other words, one of the first string's permutations is the substring of the second string.

 * Thought Process:
BF: for each s1 permutation, see if s2 contains s1
e.g.
 * 
 */
package Backtracking.PermutationRelated;

/**
 *
 * @author xinrong
 */
public class PermutationiinString {

    
    
    /** TLE
 *                             _ooOoo_
 *                            o8888888o
 *                            88" . "88
 *                            (| -_- |)
 *                            O\  =  /O
 *                         ____/`---'\____
 *                       .'  \\|     |//  `.
 *                      /  \\|||  :  |||//  \
 *                     /  _||||| -:- |||||-  \
 *                     |   | \\\  -  /// |   |
 *                     | \_|  ''\---/''  |   |
 *                     \  .-\__  `-`  ___/-. /
 *                   ___`. .'  /--.--\  `. . __
 *                ."" '<  `.___\_<|>_/___.'  >'"".
 *               | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 *               \  \ `-.   \_ __\ /__ _/   .-` /  /
 *          ======`-.____`-.___\_____/___.-`____.-'======
 *                             `=---='
 */
    
    public boolean checkInclusion(String s1, String s2) {

        if (s2.contains(s1)) {
            return true;
        }

        char[] chs = s1.toCharArray();
        char[] oriChs = chs.clone();

        String curPer = "";
        while (!curPer.equals(oriChs)) {
            nextPermutation(chs);
            curPer = new String(chs);
            if (s2.contains(curPer)) {
                return true;
            }
        }
        return false;
    }

    public void nextPermutation(char[] chs) {
        int pivot = -1;
        for (int i = chs.length - 1; i > 0; i--) {
            if (chs[i - 1] < chs[i]) {
                pivot = i - 1;
                for (int j = chs.length - 1; j > pivot; j--) {
                    if (chs[j] > chs[pivot]) {
                        swap(j, pivot, chs);
                        break;
                    }
                }
                break;
            }

        }
        reverse(pivot + 1, chs.length - 1, chs);
    }

    private void swap(int i, int j, char[] chs) {
        char tp = chs[i];
        chs[i] = chs[j];
        chs[j] = tp;
    }

    private void reverse(int start, int end, char[] chs) {
        while (start < end) {
            swap(start, end, chs);
            start++;
            end--;
        }
    }

}
