/*
 * Thought Process:
 * 
 */
package Sorting;

/**
 *
 * @author xinrong
 */
public class BitmapSort {

    public static void main(String[] args) {
        int[] arr = {3, 31, 1, 153, 2222};

        int[] bitmap = buildChunks(arr, 2222);
        scanChunks(bitmap);

    }

    private static int[] buildChunks(int[] arr, int biggest) {
        int[] chunks;
        if (arr.length % 32 == 0) {
            chunks = new int[biggest / 32];
        } else {
            chunks = new int[biggest / 32 + 1];
        }
        for (int i : arr) {
            chunks[i / 32] = chunks[i / 32] | (1 << (i % 32));
        }
        return chunks;
    }

    private static void scanChunks(int[] chunks) {
        for (int i = 0; i < chunks.length; i++) {
            int bit = 1;
            while (chunks[i] != 0) {
                if ((chunks[i] & 1) == 1) {
                    System.out.println((i * 32) + bit - 1);
                }
                chunks[i] = chunks[i] >>> 1; // if long, 无符号位，/ 2 即可
                bit++;
            }
        }
    }

}
