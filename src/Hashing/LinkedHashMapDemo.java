/*
 * Thought Process:
 * 
 */
package Hashing;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.LinkedHashMap;

/**
 *
 * @author xinrong
 */
public class LinkedHashMapDemo {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();        
        map.put("Two", "Internship in China");
        map.put("One", "Internship in the USA");
        map.put("Three", "Take classes in the USA");
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry en = (Map.Entry) it.next();
            System.out.println(en.getKey() + " : " + en.getValue());
        }
        System.out.println();
        System.out.println("Insertion - ordered");
        Map<String, String> lmap = new LinkedHashMap<String, String>();
        lmap.put("One", "Internship in the USA");
        lmap.put("Two", "Internship in China");
        lmap.put("Three", "Take classes in the USA");
        it = lmap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry en = (Map.Entry) it.next();
            System.out.println(en.getKey() + " : " + en.getValue());
        }
    }
}
