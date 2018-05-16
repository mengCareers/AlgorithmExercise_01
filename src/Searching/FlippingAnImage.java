/* 832.Flipping an Image
input : A, binary matrix
            flip horizontally then invert it
output: te resulting image
e.g.
1 1 0
1 0 1
0 0 0
flip :
0 1 1
1 0 1
0 0 0
invert :
1 0 0
0 1 0
1 1 1
 * Thought Process:
flip - swap columns, swap cells
invert :
1 -> 0 
0 -> 1
x = 1 - x
 * 
 */
package Searching;

/**
 *
 * @author xinrong
 */
public class FlippingAnImage {

    public int[][] flipAndInvertImage(int[][] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        int rows = A.length, cols = A[0].length;
        int[][] resultingImage = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resultingImage[i][j] = 1 - A[i][cols - 1 - j];
            }
        }
        return resultingImage;
    }
}
