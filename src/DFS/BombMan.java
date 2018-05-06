/* 361. Bomb Enemy
Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), 
return the maximum enemies you can kill using one bomb.
The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
Note that you can only put the bomb at an empty cell.
 * 
 */
package DFS;

/**
 *
 * @author xinrong
 */
public class BombMan {

    public static void main(String[] args) {
        char[][] graph = {
            {'0', 'E', '0', '0'},
            {'E', '0', 'W', 'E'},
            {'0', 'E', '0', '0'}};
        int ans = maxKilledEnemies_v3(graph);
        System.out.println(ans);
    }

    // ============================== v3 ==============================
    public static int maxKilledEnemies_v3(char[][] graph) {
        int maxVal = 0;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (graph[i][j] == '0') {
                    int val = dfsForward(graph, i, j);
                    maxVal = Math.max(maxVal, val);
                }
            }
        }
        return maxVal;
    }

    private static int dfsForward(char[][] graph, int x, int y) {
        int val = 0;
        int xcopy = x;
        int ycopy = y;

        while (x <= graph.length - 1) {
            if (graph[x][y] == 'W') {
                break;
            }
            if (graph[x][y] == 'E') {
                val++;
            }
            x++;
        }
        x = xcopy;

        while (x >= 0) {
            if (graph[x][y] == 'W') {
                break;
            }
            if (graph[x][y] == 'E') {
                val++;
            }
            x--;
        }
        x = xcopy;

        while (y <= graph[0].length - 1) {
            if (graph[x][y] == 'W') {
                break;
            }
            if (graph[x][y] == 'E') {
                val++;
            }
            y++;
        }
        y = ycopy;

        while (y >= 0) {
            if (graph[x][y] == 'W') {
                break;
            }
            if (graph[x][y] == 'E') {
                val++;
            }
            y--;
        }

        return val;
    }

    // ============================== v2 ==============================
    public int maxKilledEnemies_v2(char[][] graph) {
        int maxVal = 0;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (graph[i][j] == '0') {
                    boolean[][] visited = new boolean[graph.length][graph[0].length];

                    int val = dfs(graph, i, j, visited, '.');
                    // System.out.println('-------');
                    maxVal = Math.max(maxVal, val);
                }
            }
        }
        return maxVal;
    }

    private static int dfs(char[][] graph, int x, int y, boolean[][] visited, char orient) {
        if (x < 0 || x > graph.length - 1 || y < 0 || y > graph[0].length - 1 || visited[x][y] || graph[x][y] == 'W') {
            return 0;
        }
        int val = 0;
        if (graph[x][y] == 'E') {
            val++;
        }
        visited[x][y] = true;
        if (orient == '.') {
            return dfs(graph, x + 1, y, visited, 's')
                    + dfs(graph, x - 1, y, visited, 'n')
                    + dfs(graph, x, y + 1, visited, 'e')
                    + dfs(graph, x, y - 1, visited, 'w');
        } else if (orient == 's') {
            return val + dfs(graph, x + 1, y, visited, orient);
        } else if (orient == 'n') {
            return val + dfs(graph, x - 1, y, visited, orient);
        } else if (orient == 'e') {
            return val + dfs(graph, x, y + 1, visited, orient);
        } else if (orient == 'w') {
            return val + dfs(graph, x, y - 1, visited, orient);
        }
        visited[x][y] = false;
        return val;
    }

    // ============================== v1 ==============================
    public static int maxKilledEnemies_v1(char[][] graph) {
        int maxVal = 0;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (graph[i][j] == '0') {
                    boolean[][] visited = new boolean[graph.length][graph[0].length];
                    Cnt cnt = new Cnt(0);
                    dfs(graph, i, j, visited, cnt, '.');
                    // System.out.println('-------');
                    maxVal = Math.max(maxVal, cnt.val);
                }
            }
        }
        return maxVal;
    }

    static class Cnt {

        int val;

        public Cnt(int val) {
            this.val = val;
        }
    }

    private static void dfs(char[][] graph, int x, int y, boolean[][] visited, Cnt cnt, char orient) {
        if (x < 0 || x > graph.length - 1 || y < 0 || y > graph[0].length - 1 || visited[x][y] || graph[x][y] == 'W') {
            return;
        }
        // System.out.println(x + ', ' + y);
        if (graph[x][y] == 'E') {
            cnt.val++;
            // System.out.println('kill');
        }
        visited[x][y] = true;
        if (orient == '.') {
            dfs(graph, x + 1, y, visited, cnt, 's');
            dfs(graph, x - 1, y, visited, cnt, 'n');
            dfs(graph, x, y + 1, visited, cnt, 'e');
            dfs(graph, x, y - 1, visited, cnt, 'w');
        } else if (orient == 's') {
            dfs(graph, x + 1, y, visited, cnt, orient);
        } else if (orient == 'n') {
            dfs(graph, x - 1, y, visited, cnt, orient);
        } else if (orient == 'e') {
            dfs(graph, x, y + 1, visited, cnt, orient);
        } else if (orient == 'w') {
            dfs(graph, x, y - 1, visited, cnt, orient);
        }
        visited[x][y] = false;
    }
}
