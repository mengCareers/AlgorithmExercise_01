/*
490. The Maze
input : maze of 0 and 1, start, destination
output: 
 * Thought Process:
 * GET :
2 Ways to check visited : boolean array OR set
 */
package DFS;

/**
 *
 * @author xinrong
 */
public class TheMaze {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        return dfs(new boolean[maze.length][maze[0].length], maze, start, destination);
    }

    boolean dfs(boolean[][] visited, int[][] maze, int[] cur, int[] destination) {
        int x = cur[0];
        int y = cur[1];
        if (visited[x][y]) {
            return false;
        }
        if (x == destination[0] && y == destination[1]) {
            return true;
        }
        visited[x][y] = true;
        int upx = x, downx = x;
        int lefty = y, righty = y;
        while (downx + 1 < maze.length && maze[downx + 1][y] == 0) {
            downx++;
        }
        if (dfs(visited, maze, new int[]{downx, y}, destination)) {
            return true;
        }
        while (upx - 1 >= 0 && maze[upx - 1][y] == 0) {
            upx--;
        }
        if (dfs(visited, maze, new int[]{upx, y}, destination)) {
            return true;
        }
        while (righty + 1 < maze[0].length && maze[x][righty + 1] == 0) {
            righty++;
        }
        if (dfs(visited, maze, new int[]{x, righty}, destination)) {
            return true;
        }
        while (lefty - 1 >= 0 && maze[x][lefty - 1] == 0) {
            lefty--;
        }
        if (dfs(visited, maze, new int[]{x, lefty}, destination)) {
            return true;
        }
        return false;
    }
}
