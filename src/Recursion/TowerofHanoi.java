/*
 * Thought Process:
 * 
 */
package Recursion;

/**
 *
 * @author xinrong
 */
public class TowerofHanoi {
    public static void main(String[] args) {
        new TowerofHanoi().move(4, 'A', 'C', 'B');
    }
    public void move(int numOfDiscs, char from, char to, char inter) {
        // breaking condition
        if (numOfDiscs == 1)
            System.out.println("Moving disc 1 " + " from " + from + " to " + to);
        else {
            // from TO inter
            move(numOfDiscs - 1, from, inter, to);
            System.out.println("Moving disc " + numOfDiscs + " from " + from + " to " + to);
            // inter TO to
            move(numOfDiscs - 1, inter, to, from);
        }
    }
}
