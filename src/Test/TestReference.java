/*
 * Thought Process:
 * 
 */
package Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class TestReference {

    public static void main(String[] args) {
        O o = new O("!");
        I i = new I(0);
        List<Integer> list = new ArrayList<>();
        f1(o, i, list);
        System.out.println(o.val);
        System.out.println(i.val);
        System.out.println(list);
    }

    static class I {
        int val;

        public I(int val) {
            this.val = val;
        }
        
    }
    
    static class O {
        String val;

        public O(String val) {
            this.val = val;
        }
        
    }
    
    private static void f1(O o, I i, List<Integer> list) {
        if (o.val.equals("!aaaa"))
            return;
        o.val += "a";
        i.val += 1;
        list.add(1);
        f1(o, i, list);
    }
}
