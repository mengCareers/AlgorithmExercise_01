/*
 * Thought Process:
 * 
 */

/**
 *
 * @author xinrong
 */
public class TestSplit {
    public static void main(String[] args) {
        String a = "8820	2.5833333333333335";
        String[] b = a.split("\\s+");
        for (String bs : b)
            System.out.println(bs + ", ");
    }
}
