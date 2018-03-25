
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/*
 * Thought Process:
 * 
 */
/**
 *
 * @author xinrong
 */
public class TestTrivial {

    public static void main(String[] args) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println(-10 >> 2);
        System.out.println(-10 >>> 2);

//        // REFLECTION MODIFY PRIVATE
//        NewClass test = new NewClass();
//        Class<?> cls = NewClass.class;
//        Field fi = cls.getDeclaredField("secret");
//        fi.setAccessible(true);
//        System.out.println(fi.get(test)); // Returns the value of the field represented by this Field, on the specified object. 
//        fi.set(test, "I will stay with you");
//        System.out.println(fi.get(test));
//        // SPLIT \\s+
//        String a = "8820	2.5833333333333335";
//        String[] b = a.split("\\s+");
//        for (String bs : b)
//            System.out.println(bs + ", ");
//        // Integer REASSIGN
//        Integer s = 3;
//        s = 2;
//        System.out.println(s);
//        // hOW HASH SET AVOID DUP
//        NewClass nc1 = new NewClass(1); // nc1 hashcode 1
//        NewClass nc2 = new NewClass(1); // nc2 hashcode 1      
//        Set<NewClass> set = new HashSet<NewClass>();
//        set.add(nc1);
//        System.out.println("sz = " + set.size());
//        set.add(nc2);
//        // they point to the same index in hashtable
//        // we check if nc1.equals(nc2), not, so we add it
//        System.out.println("sz = " + set.size());
    }
}
