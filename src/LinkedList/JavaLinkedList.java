/*
 * Thought Process:
 * 
 */
package LinkedList;
import java.util.LinkedList;
/**
 *
 * @author xinrong
 */
public class JavaLinkedList {  
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(0, 2);
        ll.addLast(3);
        // 2 3
        System.out.println("1st ele is " + ll.indexOf(2));
        System.out.println(ll.remove(1));        
        System.out.println(ll.size());
        ll.clear();
        System.out.println(ll.size());
    }
}
