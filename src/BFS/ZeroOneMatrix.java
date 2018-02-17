/* 542.01 Matrix
 * Thought Process:
 * for each 1, 
    bfs see if its around exist 0, if not dist ++ 
    see its each around's around
   !    if none of 'its each around's around' valid, dist ++
    That's why level order traversal to solve minimum distance
 */
package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author xinrong
 */
public class ZeroOneMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] res = new ZeroOneMatrix().updateMatrix(matrix);
    }

    public int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] res = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == 0) {
                    continue;
                }
                res[r][c] = updateMatrixBFS(matrix, r, c);
            }
        }
        return res;
    }

    private int updateMatrixBFS(int[][] matrix, int r, int c) {

        Queue<int[]> pending = new LinkedList<>();

        int dist = 1;
        pending.add(new int[]{r, c});
        while (!pending.isEmpty()) {
            int sz = pending.size();
            for (int z = 0; z < sz; z++) {
                int[] t = pending.poll();
                int[][] tadj = new int[4][2];
                tadj[0] = new int[]{t[0] + 1, t[1]};
                tadj[1] = new int[]{t[0] - 1, t[1]};
                tadj[2] = new int[]{t[0], t[1] + 1};
                tadj[3] = new int[]{t[0], t[1] - 1};

                for (int[] ta : tadj) {
                    if (ta[0] < 0 || ta[0] >= matrix.length || ta[1] < 0 || ta[1] >= matrix[0].length) {
                        continue;
                    }
                    if (matrix[ta[0]][ta[1]] == 0) {
                        return dist;
                    }
                    pending.add(ta);
                }
            }
            dist++;
        }
        return dist;
    }
}
