
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Thought Process:
 * 
 */

/**
 *
 * @author xinrong
 */
public class NewClass {
    

    
    private String secret = "I want to leave here";

    public String getSecret() {
        return secret;
    }
    

    
    private int val;

    
    public NewClass(int val) {
        this.val = val;
    }
    
    int outval = 5;
    
    class InClass extends FindC{
//        val = 3;
        int fc(int[] a) {
            return 2;
        }
    }
     
   InClass ic = new InClass();
   
    
    
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof NewClass)) 
            return false;
        NewClass nc = (NewClass) o;
        return false; // all objects are always not equal
    }
    
    @Override
    public int hashCode() { // all objects share the same hashCode
        int hash = val;
        return hash;
    }
    
    static int selfIncrease(int[] i) {
        return i[0]++;
    }
    
    public static void main(String[] args) throws ClassNotFoundException {
        List<Integer> list = Arrays.asList(1, 3, 5);
        //list.forEach(n -> System.out.print(n + " "));
        list.forEach(System.out::println);
//        Object o = Class.forName("NewClass");
//        System.out.println(o.getClass().getSimpleName());
        int[] i = {1};
        System.out.println("Self : " + selfIncrease(i));
        System.out.println("Self : " + selfIncrease(i));
    }
}
