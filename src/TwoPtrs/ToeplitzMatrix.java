/*
 * Thought Process:
 * 
 */
package TwoPtrs;

/**
 *
 * @author xinrong
 */
public class ToeplitzMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}};
        isToeplitzMatrixs(matrix);
    }

    private static boolean isToeplitzMatrixs(int[][] matrix) {
        for (int i = matrix.length - 1; i >= 1; i--) {
            for (int j = matrix[0].length - 1; j >= 1; j--) {
                System.out.println(i + " " + j);
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
