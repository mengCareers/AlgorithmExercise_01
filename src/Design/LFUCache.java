/* Less Frequently Used Cache {
   get(k)   : return val or -1
   put(k, v): set or insert (if reach capacity, delete lfu . lru)
 * Thought Process:
 * Which ds should we use? 
A:  DoublyLinkedList link LinkedHashSet and access next freq in O(1)
    LinkedHashSet for each freq to keep track of the nodes belonging to it 
    HashMap access val  by key O(1)
    HashMap access node(head in its LinkedHashSet) by key O(1)
   
 */
package Design;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
/**
 *
 * @author xinrong
 */
public class LFUCache {
    private int cap;
    private Node head;
    private Map<Integer, Integer> vmap; 
    private Map<Integer, Node> nmap;
    
    public LFUCache(int capacity) {
        cap = capacity;
        vmap = new HashMap<>();
        nmap = new HashMap<>();
    }
    
    public int get(int key) {
        if (vmap.containsKey(key)) {
            increaseFreq(key);
            return vmap.get(key);
        }
        return -1;
    }
    
    private void increaseFreq(int k) {
        Node node = nmap.get(k);
        node.kset.remove(k);
        if (node.next == null) {
            node.next = new Node(node.freq + 1);
            node.next.prev = node;
            node.next.kset.add(k);
        } else if (node.next.freq == node.freq + 1) {
            node.next.kset.add(k);
        } else {
            // node tmp node.nxt
            Node tmp = new Node(node.freq + 1);
            tmp.kset.add(k);
            tmp.prev = node;
            tmp.next = node.next;
            node.next.prev = tmp;
            node.next = tmp;
        }
        nmap.put(k, node.next);
        if (node.kset.size() == 0)
            remove(node);
    }
    
    private void remove(Node node) {
        if (node.prev == null)
            head = node.next;
        else 
            node.prev.next = node.next;
        if (node.next != null)
            node.next.prev = node.prev;
    }
    
    public void put(int key, int value) {
        if (cap == 0)
            return;
        if (vmap.containsKey(key)) 
            vmap.put(key, value);
        else {
            if (vmap.size() < cap)
                vmap.put(key, value);
            else {
                removeOne();
                vmap.put(key, value);
            }
            addToHead(key);
        }
        increaseFreq(key);
    }
    
    private void addToHead(int k) {
        if (head == null) {
            head = new Node(0);
            head.kset.add(k);
        } else if (head.freq > 0) {
            Node node = new Node(0);
            node.kset.add(k);
            node.next = head;
            head.prev = node;
            head = node;
        } else {
            head.kset.add(k);
        }
        nmap.put(k, head);
    }
    
    private void removeOne() {
        if (head == null)
            return;
        int one = 0;
        for (int n : head.kset) {
            one = n;
            break;
        }
        head.kset.remove(one);
        if(head.kset.size() == 0)
            remove(head);
        nmap.remove(one);
        vmap.remove(one);
    }
    
    class Node {
        int freq = 0;
        Set<Integer> kset;
        Node prev;
        Node next;
        public Node(int freq){
            this.freq = freq;
            kset = new LinkedHashSet<>();
            prev = next = null;
        }
    }
}
