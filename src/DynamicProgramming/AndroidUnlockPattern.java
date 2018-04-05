/*
at least m keys 
at most n keys
pattern all keys passed
tp:
m1
list all patterns passed
if contains keys m to n steps print
m2
at most n keys - at most m - 1 keys = at least m keys
dp[i] = at most keys
    
 * Get:
can knight
for each # of key valid, call the method once, if steps S, will we S level state space tree
if valid needs to check visited[] and .. with last one
 * 
 */
package DynamicProgramming;

/**
 *
 * @author xinrong
 */
public class AndroidUnlockPattern {

    public int numberOfPatterns(int m, int n) {
        boolean[] visited = new boolean[9];
        int res = 0;
        for (int l = m; l <= n; l++) {
            res += getPatterns(-1, l, visited);
            for (int i = 0; i < 9; i++) {
                visited[i] = false;
            }
        }
        return res;
    }

    private static int getPatterns(int last, int len, boolean[] visited) {
        if (len == 0) {
            return 1;
        }
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            if (isValid(last, i, visited)) {
                visited[i] = true;
                sum += getPatterns(i, len - 1, visited);
                visited[i] = false;
            }
        }
        return sum;
    }

    private static boolean isValid(int last, int i, boolean[] visited) {
        if (visited[i]) {
            return false;
        }
        if (last == -1) {
            return true;
        }
        // true if knight or adj
        if ((i + last) % 2 == 1) {
            return true;
        }
        int mid = (i + last) / 2;
        if (mid == 4) {
            return visited[mid];
        }
        // true if diag
        if ((i % 3 != last % 3) && (i / 3 != last / 3)) {
            return true;
        }
        return visited[mid];
    }
}