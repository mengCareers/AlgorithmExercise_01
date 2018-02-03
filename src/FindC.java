/*
 * Thought Process:
 * 
 */

/**
 *
 * @author xinrong
 */
public class FindC {
    
    int fc(int[] a) {
        int c = a[0];
        int cnt = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] != c)
                cnt--;
            else
                cnt++;
            if (cnt == 0) {
                c = a[i];
                cnt = 1;
            }
        }
        return cnt;
    }
    
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 3, 3, 2, 2, 1, 1};
        int ans = new FindC().fc(a);
        System.out.println(ans);
        // if ans > 1, majority is c
    }
}
