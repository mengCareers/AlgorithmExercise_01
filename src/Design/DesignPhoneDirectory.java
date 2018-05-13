/* 379. Design Phone Directory
Design a Phone Directory which supports the following operations : 
get : pro
 * Thought Process:
 * get(), then check(i) will be false
 */
package Design;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author xinrong
 */
public class DesignPhoneDirectory {

    Queue<Integer> available;
    Set<Integer> unused;

    public DesignPhoneDirectory(int maxNumbers) {
        available = new LinkedList<>();
        unused = new HashSet<>();
        for (int i = 0; i < maxNumbers; i++) {
            available.add(i);
            unused.add(i);
        }
    }

    public int get() {
        if (available.isEmpty()) {
            return -1;
        }
        unused.remove(available.peek());
        return available.poll();
    }

    public boolean check(int number) {
        if (unused.contains(number)) {
            return true;
        }
        return false;
    }

    public void release(int number) {
        if (!unused.contains(number)) {
            unused.add(number);
            available.add(number);
        }
    }
}
