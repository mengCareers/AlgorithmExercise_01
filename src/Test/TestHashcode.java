/*
 * Thought Process:
 * 
 */
package Test;

/**
 *
 * @author xinrong
 */
public class TestHashcode {

    public static void main(String[] args) {
        String a = ",,,,";
        // String b = "grace";
        String[] splits  = a.split(",", -1);
       // = a.split(",");
        // System.out.println(a.hashCode());
         System.out.println(splits.length);
        for (String s : splits) {
            System.out.println(s.length() + "~");
        }
        
    }    
}
