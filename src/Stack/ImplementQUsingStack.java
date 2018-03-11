/*
 * Thought Process:
 * 
 */
package Stack;

import java.util.Stack;

/**
 *
 * @author xinrong
 */
public class ImplementQUsingStack {

    /**
     * Initialize your data structure here.
     */
    Stack<Integer> s1;
    Stack<Integer> s2;

    public ImplementQUsingStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        if (!s2.empty()) {
            s1.push(s2.pop());
        }
        s1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        while (!s1.empty()) {
            s2.push(s1.pop());
        }
        return s2.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        while (!s1.empty()) {
            s2.push(s1.pop());
        }
        return s2.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return s1.empty() && s2.empty();
    }
}
