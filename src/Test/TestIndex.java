/*
 * Thought Process:
run:

 */
package Test;

/**
 *
 * @author xinrong
 */
public class TestIndex {

    public static void main(String[] args) {

        for (int i = 2; i < 10; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(i + "," + j + "  ");
            }
            System.out.println();
        }
        System.out.println("STOP");
        for (int j = 3; j < 5; j++) {
            for (int i = 1; i < 3; i++) {
                System.out.println(i + " " + j);
            }
        }
        /**
1 3
1 4
2 3
2 4
STOP
1 3
2 3
1 4
2 4
         */

        int n = 4;
        for (int l = 1; l < n; l++) {
            for (int i = 0; i + l < n; i++) {
                int j = i + l;
                //System.out.println(i + " " + j);
            }
        }
        /**
         * 0 1
         * 1 2
         * 2 3
         * 0 2
         * 1 3
         * 0 3
         */
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                System.out.println(i + " " + j);
            }
        }
        /**
         * 2 3
         * 1 2
         * 1 3
         * 0 1
         * 0 2
         * 0 3
         */
    }
}
