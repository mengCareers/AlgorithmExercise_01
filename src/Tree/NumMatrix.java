/*RangeSumQuery2D_Mutable
 * Thought Process:
 * 
 */
package Tree;

/**
 *
 * @author xinrong
 */
public class NumMatrix {
    int[][] matrix;
    int[][] es;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        this.matrix = matrix;
        int sz = matrix[0].length;
        es = new int[matrix.length][sz + 1];
        initializeEs(es, this.matrix);
    }

    private static void initializeEs(int[][] es, int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 1; j < es[0].length; j++) {
                update(j, mat[i][j - 1], es[i]);
            }
        }
    }

    public void update(int row, int col, int val) {
        int oriVal = matrix[row][col];
        int updatedVal = val - oriVal;
        this.matrix[row][col] = val;
        update(col + 1, updatedVal, es[row]);
    }

    private static void update(int i, int v, int[] e) {
        while (i < e.length) {
            e[i] += v;
            i = i + rightmostOne(i);
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            int[] e = es[i];
            sum += rangeSum(col1 + 1, col2 + 1, e);
        }
        return sum;
    }

    private static int rightmostOne(int num) {
        return num & (-num);
    }

    private static int rangeSum(int i, int[] e) {
        int sum = 0;
        while (i > 0) {
            sum += e[i];
            i = i - rightmostOne(i);
        }
        return sum;
    }

    private static int rangeSum(int st, int en, int[] e) {
        return rangeSum(en, e) - rangeSum(st - 1, e);
    }
}
