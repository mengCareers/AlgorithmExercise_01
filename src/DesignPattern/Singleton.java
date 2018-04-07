/*
 * Thought Process:
 * constructor private
 * static getInstance() because you can't initialize a object to call getInstance()
 */
package DesignPattern;

/**
 *
 * @author xinrong
 */
public class Singleton {
    // Thread Safe Lazy Initialization
    // When one thread is executing a synchronized method for an object, 
    // all other threads that invoke synchronized methods for the same object block (suspend execution) until the first thread is done with the object.
    private static Singleton inst = null;
    private Singleton() {
        
    }
    public static synchronized Singleton getInstance() {
        if (inst == null)
            inst = new Singleton();
        return inst;
    }
    /* Lazy Initialization
    // creates the instance in the global access method
    // But it is not Thread Safe
    private static Singleton inst = null;
    private Singleton() {
        
    }
    public static Singleton getInstance() {
        if (inst == null)
            inst = new Singleton();
        return inst;
    }
    */
}
