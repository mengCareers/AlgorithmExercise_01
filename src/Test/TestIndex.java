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
        int n = 4;
        for (int l = 1; l < n; l++) {
            for (int i = 0; i + l < n; i++) {
                int j = i + l;
                //System.out.println(i + " " + j);
            }
        }
        /**
0 1
1 2
2 3
0 2
1 3
0 3
         */
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                System.out.println(i + " " + j);
            }
        }
        /**
2 3
1 2
1 3
0 1
0 2
0 3
         */
    }
}
