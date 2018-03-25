/*
 * Thought Process:
 * 
 */
package Test;

/**
 *
 * @author xinrong
 */
public class TestCallStack {

    public void func1() {
        func2();
    }

    public void func2() {
        func3();
    }

    public void func3() {
        Throwable ex = new Throwable(); // to return jvm stack info
        StackTraceElement[] stackElements = ex.getStackTrace();
        System.out.println(stackElements.length);
        for (StackTraceElement ste : stackElements) {
            System.out.println(ste.getMethodName());
        }
    }

    public static void main(String[] args) {
        TestCallStack inst = new TestCallStack();
        inst.func1();
    }

}
