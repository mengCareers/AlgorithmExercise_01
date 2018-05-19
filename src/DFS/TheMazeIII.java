/* 499.The Maze III
input : maze[][], ball[], hole[]
ball can go u d l r, not stop rolling until hitting a wall
if stops, can choose next direction
hole in maze, may drop the ball
output: moving directions to get shortest moving distance from ball to hole
 * Thought Process:
 * dfs
start : ball
choices:ball have 4 choices, to go until the [edge],
end   : hole
keep track of the shortest distance as well as the moving directions
 * Hint : 
Why don't we use BFS to get shortest distance?
What is start? ball's position
Correct.
What are nodes in queue? all positions reachable
                        for cur, it can reach 4 end (until wall or edge), that is cur's neighbours
 * GET :
We aim to find the path passing the shortest distance. So objects in BFS queue should be PathElements, i.e., cells in maze.
We restrict the order of orientations during initialization to ensure the final answer is lexicographically smallest.
For each cell, it can at most be visited 4 times for there are 4 orientations. So boolean[][][] visited is three-dimensional.
The start PathElement should be any one of the 4 cells around the ball if it the cell is valid. So we add the 4 start PathElements first.
During BFS, we move on following the original orientation. 
If we can't go forward any more (i.e., meet edge or wall), we turn to the other 3 orientations. 
We keep track of the orientation and path on the fly, whenever we meet the hole, we return current path, that's also why we set attributes orientation and moves to class PathElement.
 */
package DFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author xinrong
 */
public class TheMazeIII {

    public static void main(String[] args) {
        TheMazeIII inst = new TheMazeIII();
        int[][] maze = {
            {0, 0, 0, 0, 0},
            {1, 1, 0, 0, 1},
            {0, 0, 0, 0, 0},
            {0, 1, 0, 0, 1},
            {0, 1, 0, 0, 0}};
        int[] ball = {4, 3};
        int[] hole = {0, 1};
        inst.findShortestWay(maze, ball, hole);
    }

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        Queue<PathElement> path = new LinkedList<>();
        char[] orientations = {'d', 'l', 'r', 'u'};
        int[][] directions = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
        boolean[][][] visited = new boolean[maze.length][maze[0].length][4];
        for (int i = 0; i < 4; i++) {
            int nx = ball[0] + directions[i][0];
            int ny = ball[1] + directions[i][1];
            if (0 <= nx && nx < maze.length && 0 <= ny && ny < maze[0].length && maze[nx][ny] == 0) {
                path.add(new PathElement(nx, ny, i, "" + orientations[i]));
                visited[nx][ny][i] = true;
            }
        }

        while (!path.isEmpty()) {
            PathElement cur = path.poll();
            if (cur.row == hole[0] && cur.col == hole[1]) {
                return cur.moves;
            }
            int nx = cur.row + directions[cur.orientation][0];
            int ny = cur.col + directions[cur.orientation][1];
            if (0 <= nx && nx < maze.length && 0 <= ny && ny < maze[0].length && maze[nx][ny] == 0) {
                if (!visited[nx][ny][cur.orientation]) {
                    path.add(new PathElement(nx, ny, cur.orientation, cur.moves));
                    visited[cur.row][cur.col][cur.orientation] = true;
                }
            } else {
                for (int i = 0; i < 4; i++) {
                    if (i != cur.orientation) {
                        nx = cur.row + directions[i][0];
                        ny = cur.col + directions[i][1];
                        if (0 <= nx && nx < maze.length && 0 <= ny && ny < maze[0].length && maze[nx][ny] == 0) {
                            if (!visited[nx][ny][i]) {
                                path.add(new PathElement(nx, ny, i, cur.moves + orientations[i]));
                                visited[nx][ny][i] = true;
                            }
                        }
                    }
                }
            }
        }
        return "impossible";
    }

    class PathElement {

        int row;
        int col;
        int orientation;
        String moves;

        public PathElement(int row, int col, int orientation, String moves) {
            this.row = row;
            this.col = col;
            this.orientation = orientation;
            this.moves = moves;
        }

    }

}
