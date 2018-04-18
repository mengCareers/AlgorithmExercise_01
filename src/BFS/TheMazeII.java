/*505. The Maze II
shortest distance from start to destination
 * Thought Process:
2-D dijkstra
 * 
 */
package BFS;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *
 * @author xinrong
 */
public class TheMazeII {

    private final static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] minDist = new int[maze.length][maze[0].length];
        for (int[] row : minDist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        minDist[start[0]][start[1]] = 0;
        dijkstra(minDist, start, maze);
        return minDist[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : minDist[destination[0]][destination[1]];
    }

    private static void dijkstra(int[][] minDist, int[] start, int[][] maze) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{start[0], start[1], 0});
        while (!pq.isEmpty()) {
            int[] minVer = pq.poll();
//            if (minDist[minVer[0]][minVer[1]] < minVer[2]) {
//                continue;
//            }

            for (int[] dir : directions) {
                int nx = minVer[0];
                int ny = minVer[1];
                int curDist = 0;
                while (nx + dir[0] >= 0 && ny + dir[1] >= 0 && nx + dir[0] < minDist.length && ny + dir[1] < minDist[0].length && maze[nx + dir[0]][ny + dir[1]] == 0) {
                    nx += dir[0];
                    ny += dir[1];
                    curDist++;
                }
                if (minDist[minVer[0]][minVer[1]] != Integer.MAX_VALUE && minDist[nx][ny] > minDist[minVer[0]][minVer[1]] + curDist) {
                    minDist[nx][ny] = minDist[minVer[0]][minVer[1]] + curDist;
                    pq.offer(new int[]{nx, ny, minDist[nx][ny]});
                }
            }
        }
    }

    public int shortestDistanceTLE(int[][] maze, int[] start, int[] destination) {
        if (start[1] >= maze[0].length || destination[1] >= maze[0].length) {
            return -1;
        }
        int[][] minDist = new int[maze.length][maze[0].length];
        boolean[][] inSet = new boolean[maze.length][maze[0].length];
        for (int[] row : minDist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        minDist[start[0]][start[1]] = 0;
        dijkstraTLE(minDist, inSet, maze);
        return minDist[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : minDist[destination[0]][destination[1]];
    }

    private static void dijkstraTLE(int[][] minDist, boolean[][] inSet, int[][] maze) {
        while (true) {
            int[] minVer = getMinDistVertex(minDist, inSet);
            if (minVer[0] < 0) {
                break;
            }
            inSet[minVer[0]][minVer[1]] = true;
            for (int[] dir : directions) {
                int nx = minVer[0];
                int ny = minVer[1];
                int curDist = 0;
                while (nx + dir[0] >= 0 && ny + dir[1] >= 0 && nx + dir[0] < minDist.length && ny + dir[1] < minDist[0].length && maze[nx + dir[0]][ny + dir[1]] == 0) {
                    nx += dir[0];
                    ny += dir[1];
                    curDist++;
                }
                if (!inSet[nx][ny] && minDist[minVer[0]][minVer[1]] != Integer.MAX_VALUE && minDist[nx][ny] > minDist[minVer[0]][minVer[1]] + curDist) {
                    minDist[nx][ny] = minDist[minVer[0]][minVer[1]] + curDist;
                }
            }
        }
    }

    private static int[] getMinDistVertex(int[][] minDist, boolean[][] inSet) {
        int[] minVer = {-1, -1};
        int minimumDist = Integer.MAX_VALUE;
        for (int i = 0; i < minDist.length; i++) {
            for (int j = 0; j < minDist[0].length; j++) {
                if (!inSet[i][j] && minDist[i][j] <= minimumDist) {
                    minimumDist = minDist[i][j];
                    minVer = new int[]{i, j};
                }
            }
        }
        return minVer;
    }
}
