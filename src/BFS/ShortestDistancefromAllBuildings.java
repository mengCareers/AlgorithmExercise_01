/* 317. Shortest Distance from All Buildings
metDist[x][y] is the Shortest Distance from All Buildings at (x,y)
metOnes[x][y] is # of '1's (x, y) can reach.

Imagine that we start at each '1', and search around in level-order BFS way, update when grid[x][y] = 0
Finally, we for (x, y) such that metOnes[x][y] should reach aim, we find the one with smallest metDist[x][y] among them
 */
package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author xinrong
 */
public class ShortestDistancefromAllBuildings {

    private static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int shortestDistance(int[][] grid) {
        int[][] metOnes = new int[grid.length][grid[0].length];
        int[][] metDist = new int[grid.length][grid[0].length];

        int minDist = Integer.MAX_VALUE;
        int totalOnes = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    totalOnes++;
                    bfs(grid, metDist, metOnes, i, j);
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (metOnes[i][j] == totalOnes && metDist[i][j] > 0) {
                    minDist = Math.min(minDist, metDist[i][j]);
                }
            }
        }
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }

    private static void bfs(int[][] grid, int[][] metDist, int[][] metOnes, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[i][j] = true;
        int dist = 1;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int k = 0; k < sz; k++) {
                int[] pos = q.poll();
                int x = pos[0];
                int y = pos[1];
                for (int[] dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length && !visited[nx][ny] && grid[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        metDist[nx][ny] += dist;
                        metOnes[nx][ny]++;
                        q.add(new int[]{nx, ny});

                    }
                }
            }
            dist++;
        }
    }
}
