
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
    public static void main(String[] args) throws ClassNotFoundException {
        List<Integer> list = Arrays.asList(1, 3, 5);
        //list.forEach(n -> System.out.print(n + " "));
        list.forEach(System.out::println);
//        Object o = Class.forName("NewClass");
//        System.out.println(o.getClass().getSimpleName());
    }
}
