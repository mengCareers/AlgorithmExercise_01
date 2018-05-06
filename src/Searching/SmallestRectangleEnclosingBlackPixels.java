/* 302. Smallest Rectangle Enclosing Black Pixels
 * Thought Process:
 * 
 */
package Searching;

/**
 *
 * @author xinrong
 */
public class SmallestRectangleEnclosingBlackPixels {

    public int minArea(char[][] image, int x, int y) {
        int xmax = 0, xmin = image.length - 1;
        int ymax = 0, ymin = image[0].length - 1;
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                if (image[i][j] == '1') {
                    xmin = Math.min(xmin, i);
                    xmax = Math.max(xmax, i);
                    ymin = Math.min(ymin, j);
                    ymax = Math.max(ymax, j);
                }
            }
        }
        return (ymax - ymin + 1) * (xmax - xmin + 1);
    }
}
