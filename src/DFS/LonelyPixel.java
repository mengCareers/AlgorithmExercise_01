/* 531. Lonely Pixel I
 * Thought Process:
 * 
 */
package DFS;

/**
 *
 * @author xinrong
 */
public class LonelyPixel {

    public static void main(String[] args) {
        char[][] picture = {
            {'W', 'W', 'B'},
            {'W', 'B', 'W'},
            {'B', 'W', 'W'}};
        int ans = findLonelyPixel(picture);
        System.out.println(ans);
    }

    private final static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static int findLonelyPixel(char[][] picture) {
        int cntLonely = 0;
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B') {
                    if (dfs(i, j, picture, new boolean[picture.length][picture[0].length])) {
                        cntLonely++;
                    }
                }
            }
        }
        return cntLonely;
    }

    private static boolean dfs(int x, int y, char[][] picture, boolean[][] visited) {
        if (x < 0 || y < 0 || x >= picture.length || y >= picture[0].length || visited[x][y]) {
            return false;
        }
        visited[x][y] = true;

        for (int[] direction : directions) {
            int nx = x, ny = y;
            while (nx + direction[0] >= 0 && nx + direction[0] < picture.length && ny + direction[1] >= 0 && ny + direction[1] < picture[0].length && !visited[nx + direction[0]][ny + direction[1]]) {
                nx += direction[0];
                ny += direction[1];
                if (picture[nx][ny] == 'B') {
                    return false;
                }
            }
        }
        return true;
    }
}
