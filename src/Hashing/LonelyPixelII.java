/* 533. Lonely Pixel II
Given a picture consisting of black and white pixels, and a positive integer N, 
find the number of black pixels located at some specific row R and column C 
that align with all the following rules:
    Row R and column C both contain exactly N black pixels
    For all rows that have a black pixel at column C, 
        they should be exactly the same as row R
 * Get:
We look for candidate rows first. A candidate row shoud satisfy :

the row has N 'B's
same row appear N times in total
We use HashMap rowToFreq to keep results for these requirements.

However, not all 'B' in the candidate row is a valid result pixel. It is valid only if it occurs exactly N times in the column.
We use int[] cntBPerCol to keep results for this requirement.
 * 
 */
package Hashing;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author xinrong
 */
public class LonelyPixelII {

    public static int findBlackPixel(char[][] picture, int N) {
        int cntBlackPixel = 0;
        Map<String, Integer> rowToFreq = new HashMap<>();
        int[] cntBPerCol = new int[picture[0].length];

        for (char[] row : picture) {
            int cntB = 0;
            for (int i = 0; i < row.length; i++) {
                if (row[i] == 'B') {
                    cntB++;
                    cntBPerCol[i]++;
                }
            }
            if (cntB == N) {
                String candidateRow = new String(row);
                rowToFreq.put(candidateRow, rowToFreq.getOrDefault(candidateRow, 0) + 1);
            }
        }

        for (String row : rowToFreq.keySet()) {
            if (rowToFreq.get(row) == N) {
                for (int i = 0; i < row.length(); i++) {
                    if (row.charAt(i) == 'B' && cntBPerCol[i] == N) {
                        cntBlackPixel += N;
                    }
                }
            }
        }
        
        return cntBlackPixel;
    }

}
