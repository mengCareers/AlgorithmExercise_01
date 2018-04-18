/*
 * Thought Process:
 * 
 */
package datastructure;

import java.util.Iterator;

/**
 *
 * @author xinrong
 */
class PeekingIterator implements Iterator<Integer> {

    Integer next = null;
    Iterator<Integer> iterator = null;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        if (iterator.hasNext()) {
            next = iterator.next();
        }
    }

    public Integer peek() {
        return next;
    }

    @Override
    public Integer next() {
        Integer result = this.next;
        next = iterator.hasNext() ? iterator.next() : null;
        return result;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}
