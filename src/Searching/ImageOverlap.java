/* 835.Image Overlap
input : A, B matrix
output: largest possible overlap after we translate A
        sliding it left, right, up, down any number of units
 * Thought Process:
 * GET:
if we brute force, 2N horizontal sliding, 2N vertical sliding, N^2 to count overlap area
                   O(N^4)
Acceptable for n <= 30
Expand A from n x n to 3n x 3n, that's the maximum unique
 * GET : 
We aim to translate A to the point such that A and B share the maximum overlap.

Instead of sliding A,
we can build a plus graph, put A in the middle of the graph, and move B to all possible situations that form a overlap and keep track of the maximum overlap on the fly.
e.g. A is as below :
xx
xx
B is as below :
yy
yy
Initially, Aplus graph is as below:
0000
0xx0
0xx0
0000
B's start position in Aplus is as below:
yy00
yyx0
0xx0
0000

 */
package Searching;

/**
 *
 * @author xinrong
 */
public class ImageOverlap {

    public int largestOverlap(int[][] A, int[][] B) {
        int lenA = A.length;
        int[][] Aplus = new int[lenA * 3 - 2][lenA * 3 - 2];
        for (int i = lenA - 1; i < lenA + lenA - 1; i++) {
            for (int j = lenA - 1; j < lenA + lenA - 1; j++) {
                Aplus[i][j] = A[i - lenA + 1][j - lenA + 1];
            }
        }
        int maxOverlap = 0;
        for (int i = 0; i < lenA + lenA - 1; i++) {
            for (int j = 0; j < lenA + lenA - 1; j++) {
                maxOverlap = Math.max(maxOverlap, getOverlap(i, j, Aplus, B));
            }
        }
        return maxOverlap;
    }

    private int getOverlap(int x, int y, int[][] Aplus, int[][] B) {
        int overlap = 0;
        for (int i = 0; i < B.length; i++) {
            if (i + x < 0) {
                break;
            }
            for (int j = 0; j < B[0].length; j++) {
                if (j + y < 0) {
                    break;
                }
                if (B[i][j] == 1 && Aplus[i + x][j + y] == 1) {
                    overlap++;
                }
            }
        }
        return overlap;
    }

}
