/*
 * Thought Process:
Iterators give sequential access to elements of collections.
 * 
 */
package Design;

import datastructure.MyCollection;
import java.util.Iterator;

/**
 *
 * @author xinrong
 * @param <E>
 */
public class FilteredIterator<E> implements Iterator<E> {

    public static void main(String[] args) {
        String[] arr = {"G", "R", "A", "C", "E"};
        MyCollection<String> stringCollection = new MyCollection<>(arr);
        Iterator iter = stringCollection.iterator();
        Filter filter = new Filter() {
            @Override
            public boolean apply(Object o) {
                return String.valueOf(o).equals("R");
            }
        };
        FilteredIterator fi = new FilteredIterator<>(iter, filter);
        while (fi.hasNext()) {
            System.out.println(fi.next());
        }
    }

    private final Iterator<E> iterator;
    private final Filter<E> filter;
    private boolean hasNext = true;
    private E next;

    public FilteredIterator(Iterator<E> iterator, Filter<E> filter) {
        this.iterator = iterator;
        if (filter == null) {
            this.filter = new AcceptAllFilter<>();
        } else {
            this.filter = filter;
        }
        this.findNext();
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public E next() {
        E returnVal = next;
        findNext();
        return returnVal;
    }

    private void findNext() {
        while (iterator.hasNext()) {
            next = iterator.next();
            if (filter.apply(next)) {
                return;
            }
        }
        next = null;
        hasNext = false;
    }

    private class AcceptAllFilter<T> implements Filter<T> {

        @Override
        public boolean apply(T type) {
            return true;
        }

    }
}
