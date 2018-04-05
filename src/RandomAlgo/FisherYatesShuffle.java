/*
 * Thought Process:
 * 
 */
package RandomAlgo;

import java.util.Random;

/**
 *
 * @author xinrong
 */
public class FisherYatesShuffle {

    public static void main(String[] args) {
        int[] solutionArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        FisherYatesShuffle.shuffleArr(solutionArray);
        for (int i = 0; i < solutionArray.length; i++) {
            System.out.print(solutionArray[i] + " ");
        }
        System.out.println();
    }

    static void shuffleArr(int[] arr) {
        Random rd = new Random();

        for (int i = arr.length - 1; i > 0; i--) {
            int rdn = rd.nextInt(i);
            swap(rdn, i, arr);
        }

    }

    static void swap(int i, int j, int[] arr) {
        int tp = arr[i];
        arr[i] = arr[j];
        arr[j] = tp;
    }
}
