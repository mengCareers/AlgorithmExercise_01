/*
泛型 ： 参数化类型，所操作的数据类型被指定为一个参数
类型参数只能代表引用型类型，不能是原始类型
类型通配符一般是使用?代替具体的类型参数
T只是名字上的意义而已T---type,E----Element, K----key, V----value 
如果是？定义的，就是普通的Object或者其子类，List 同 List<?> 是一样的。 
 * Thought Process:
 * 
 */
package datastructure;

import java.util.Iterator;

/**
 *
 * @author xinrong
 */
public class MyCollection<T> implements Iterable<T> {

    T[] values;

    public MyCollection(T[] values) {
        this.values = values;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator {

        int nxtPos = 0;

        @Override
        public boolean hasNext() {
            if (nxtPos < values.length) {
                return true;
            }
            System.out.println("here");
            return false;
        }

        @Override
        public Object next() {
            if (hasNext()) {
                return values[nxtPos++];
            }
            System.out.println("here");
            return null;
        }

    }

    public static void main(String[] args) {
        String[] arr = {"G", "R", "A", "C", "E"};
        MyCollection<String> stringCollection = new MyCollection<>(arr);

        for (String str : stringCollection) {
            System.out.println(str);
        }
        Iterator iter = stringCollection.iterator();
        while (iter.hasNext()) {
            System.out.println("next is " + iter.next());
        }
    }

}
