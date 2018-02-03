package datastructure;
import java.util.Scanner;

/*

 */

/**
 *
 * @author xinrong
 */
public class SinglyLinkedList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedList list = new LinkedList();
        System.out.println("Singly Linked List Test\n");          
        char ch;
        do {
            System.out.println("\nSingly Linked List Operations\n");
            System.out.println("1. insert at begining");
            System.out.println("2. insert at end");
            System.out.println("3. insert at position");
            System.out.println("4. delete at position");
            System.out.println("5. check empty");
            System.out.println("6. get size");            
            int choice = scan.nextInt();
            switch (choice) {
            case 1 : 
                System.out.println("Enter integer element to insert");
                list.insertAtStart( scan.nextInt() );                     
                break;                          
            case 2 : 
                System.out.println("Enter integer element to insert");
                list.insertAtEnd( scan.nextInt() );                     
                break;                         
            case 3 : 
                System.out.println("Enter integer element to insert");
                int num = scan.nextInt() ;
                System.out.println("Enter position");
                int pos = scan.nextInt() ;
                if (pos <= 1 || pos > list.getSize() )
                    System.out.println("Invalid position\n");
                else
                    list.insertAtPos(num, pos);
                break;                                          
            case 4 : 
                System.out.println("Enter position");
                int p = scan.nextInt() ;
                if (p < 1 || p > list.getSize() )
                    System.out.println("Invalid position\n");
                else
                    list.deleteAtPos(p);
                break;
            case 5 : 
                System.out.println("Empty status = "+ list.isEmpty());
                break;                   
            case 6 : 
                System.out.println("Size = "+ list.getSize() +" \n");
                break;                         
             default : 
                System.out.println("Wrong Entry \n ");
                break;  
            }
            list.display();
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
        } while (ch == 'Y'|| ch == 'y'); 
    }
}

class LinkedList {
    Node start;
    Node end;
    int size;
    
    public LinkedList() {
        start = null;
        end = null;
        size = 0;
    }
    
    public boolean isEmpty() {
        return start == null;
    }
    
    public int getSize() {
        return size;
    }
    
    public void insertAtStart(int val) {
        Node newn = new Node(val, null);
        size++;
        
        if (start == null) {
            start = newn;
            end = start;
        } else {
            newn.setLink(start);
            start = newn;
        }
    }
    
    public void insertAtEnd(int val) {
        Node newn = new Node(val, null);
        size++;
        
        if (start == null) {
            start = newn;
            end = start;
        } else {
            end.setLink(newn);;
            end = newn;
        }
    }
    
    // insert val into 第 pos 位
    public void insertAtPos(int val, int pos) {
        Node newn = new Node (val, null);
        Node ptr = start;
        pos = pos - 1;
        // make ptr point to pos - 1
        
        for (int i = 1; i < size; i++) {
            if (i == pos) {
                // ptr -> newn -> tmp
                //pos-1           pos
                Node tmp = ptr.getLink();
                ptr.setLink(newn);
                newn.setLink(tmp);
                break;
            }
            ptr = ptr.getLink();
        }
        size++;
    }
    
    public void deleteAtPos(int pos) {
        if (pos == 1) {
            start = start.getLink();
            size--;
            return;
        }
        if (pos == size) {
            Node s = start;
            Node t = start;//t(cur end) s(prev end)
            while (s != end) {
                t = s;
                s = s.getLink();
            }
            end = t;
            end.setLink(null); ///
            size--;
            return;
        }
        Node ptr = start;
        pos = pos - 1;
        for (int i = 1; i < size - 1; i++) {
            if (i == pos) {
                //pos-1 pos
                // ptr  tmp -> tmp
                Node tmp = ptr.getLink();
                tmp = tmp.getLink();
                ptr.setLink(tmp);
                break;
            }
            ptr = ptr.getLink();
        }
        size--;
    }
    
    public void display() {
        System.out.print("\nSingly Linked List = ");
        if (size == 0) {
            System.out.print("empty\n");
            return;
        }
        if (start.getLink() == null) {
            System.out.println(start.getData());
            return;
        }
        Node ptr = start;
        System.out.print(start.getData() + "->");
        ptr = start.getLink();
        while (ptr.getLink() != null) {
            System.out.print(ptr.getData() + "->");
            ptr = ptr.getLink();
        }
        System.out.print(ptr.getData() + "\n");
    }
}

class Node {
    Node link;
    int data;
    
    public Node() {
        link = null;
        data = 0;
    }
    
    public Node (int d, Node n) {
        link = n;
        data = d;
    }
    
    public void setLink(Node n) {
        link = n;
    }
    
    public void setData(int d) {
        data = d;
    }
    
    public Node getLink() {
        return link;
    }
    
    public int getData() {
        return data;
    }
}


