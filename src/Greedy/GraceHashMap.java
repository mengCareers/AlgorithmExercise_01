package Greedy;

/*
 *  Q: implement hashmap
 *  Thought Process: 
 *  Get:
abs - absolute value
 */

/**
 *
 * @author xinrong
 */
public class GraceHashMap {
    private int arrSize = 256;
    private Node[] arr = new Node[arrSize];
    
    public GraceHashMap(){}
    public GraceHashMap(int initSize) {
        this.arrSize = initSize;
    }

    //insert node to arr at hash index
    public void put(String key, String value) {
        int hash = Math.abs(key.hashCode() % arrSize);
        Node entry = new Node(key, value);
        if (arr[hash] == null) {
            arr[hash] = entry;
        } else { // collision - place node at end of linkedlist
            Node curr = arr[hash];
            while (curr.getNext() != null) {
                if (curr.getKey().equals(entry.getKey())) {
                    curr.setValue(entry.getValue());
                    return;
                }   
                curr = curr.getNext();
            }
            curr.setNext(entry);
        }
    }
    
    //get    node.val at hash index
    public String get(String key) {
        int hash = Math.abs(key.hashCode() % arrSize);
        Node n = arr[hash];
        while (n != null) {
            if (n.getKey().equals(key)) return n.getValue();
            n = n.getNext();
        }
        return null;
    }   
    
}

class Node {
    private String key;
    private String value;
    private Node next;
    
    public Node() {}
    public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    
    public String getKey() {
            return key;
        }
    public void setKey(String key) {
        this.key = key;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
}
