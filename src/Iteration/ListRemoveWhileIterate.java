/*
 * Thought Process:
 * 
 */
package Iteration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class ListRemoveWhileIterate {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("bb");
        list.add("cc");
        // removeFOR(list);  // aa, bb, cc, BECAUSE System.arraycopy(elementData, index+1, elementData, index, numMoved);  
        // removeFOREACH(list); // ConcurrentModificationException BECAUSE  modCount++; if (modCount != expectedModCount) throw new ConcurrentModificationException();  
        removeFOREACHGood(list);
        System.out.println(list);
    }

    private static void removeFOREACH(List<String> list) {
        for (String s : list) {
            if (s.equals("bb")) {
                list.remove(s);
            }
        }
    }

    private static void removeFOR(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("bb")) {
                list.remove(i);
            }
        }
    }

    private static void removeFOREACHGood(List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (s.equals("bb")) {
                it.remove();
            }
        }
    }
}
