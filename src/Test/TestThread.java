package Test;

/*
 * Thought Process:
 * 
 */

/**
 *
 * @author xinrong
 */
public class TestThread implements Runnable{
    private Thread t;
    private String threadName;

    public TestThread(String threadName) {
        this.threadName = threadName;
    }
    
    

    @Override
    public void run() {
       
        while (true)
            System.out.print(threadName);
    }
    
    public void start() {
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
    
    public static void main(String[] args) {
        TestThread t1 = new TestThread("A");
        
        TestThread t2 = new TestThread("B");
        
        t2.start();
        t1.start();
    }
    
}
