/*
490. The Maze
input : maze of 0 and 1, start, destination
output: 
 * Thought Process:
 * GET :
2 Ways to check visited : boolean array OR set
 */
package DFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author xinrong
 */
public class TheMaze {

    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private boolean bfs(boolean[][] visited, int[][] maze, int[] start, int[] destination) {
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(start[0], start[1]));
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            Position cur = queue.poll();
            visited[cur.x][cur.y] = true;
            if (cur.x == destination[0] && cur.y == destination[1]) {
                return true;
            }
            for (int[] direction : directions) {
                int nx = cur.x;
                int ny = cur.y;
                while (nx + direction[0] >= 0 && nx + direction[0] < maze.length && ny + direction[1] >= 0 && ny + direction[1] < maze[0].length && maze[nx + direction[0]][ny + direction[1]] == 0) {
                    nx += direction[0];
                    ny += direction[1];
                }
                if (!visited[nx][ny]) {
                    Position neighbour = new Position(nx, ny);
                    queue.add(neighbour);
                }
            }
        }
        return false;
    }

    class Position {

        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        TheMaze inst = new TheMaze();
        int[][] maze = {
            {0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0},
            {1, 1, 0, 1, 1},
            {0, 0, 0, 0, 0}};
        int[] start = {0, 4};
        int[] end = {1, 2};
        inst.hasPath(maze, start, end);
    }

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        return bfs(new boolean[maze.length][maze[0].length], maze, start, destination);
        // return dfs(new boolean[maze.length][maze[0].length], maze, start, destination);
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
