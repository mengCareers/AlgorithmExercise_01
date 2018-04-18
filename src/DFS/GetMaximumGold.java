/*
0 means obstacle so no one can step on it and positive integer means the amount of gold. 
Find the maximum amount of gold you can collect. (You can start from any point you want.)
 * Thought Process:
 * 
 */
package DFS;

import java.util.HashSet;

/**
 *
 * @author xinrong
 */
public class GetMaximumGold {

    public static int getMaxGold(int[][] maze) {
        if (maze.length == 0) {
            return 0;
        }
        int maxGold = 0;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] > 0) {
                    int gold = dfsUtil(i, j, maze, new boolean[maze.length][maze[0].length]);
                    maxGold = Math.max(maxGold, gold);
                }
            }
        }
        return maxGold;
    }

    private static int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {1, -1}};

    private static int dfsUtil(int x, int y, int[][] maze, boolean[][] visited) {
        if (x < 0 || y < 0 || x > maze.length - 1 || y > maze[0].length - 1 || maze[x][y] == 0 || visited[x][y]) {
            return 0;
        }

        int maxVal = 0;
        visited[x][y] = true;
        for (int[] di : direction) {
            maxVal = Math.max(maxVal, dfsUtil(x + di[0], y + di[1], maze, visited));
        }
        visited[x][y] = false;
        return maxVal + maze[x][y];
    }
}
