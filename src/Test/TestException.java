package Test;

/*
 * Thought Process:
 * 
 */

/**
 *
 * @author xinrong
 */
public class TestException {
    public static void main(String[] args) {
        try {
            badMethod();
            System.out.println("A");
        } catch (Exception e){
            System.out.println("B");
        }
    }

    private static void badMethod() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
