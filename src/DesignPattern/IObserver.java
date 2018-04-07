/*

观察者模式
 ╭─────────────╮  Fire Event  ╭──────────────╮
 │             │─────────────>│              │
 │   Subject   │              │   Observer   │
 │             │<─────────────│              │
 ╰─────────────╯  Subscribe   ╰──────────────╯


发布订阅模式
 ╭─────────────╮                 ╭───────────────╮   Fire Event   ╭──────────────╮
 │             │  Publish Event  │               │───────────────>│              │
 │  Publisher  │────────────────>│ Event Channel │                │  Subscriber  │
 │             │                 │               │<───────────────│              │
 ╰─────────────╯                 ╰───────────────╯    Subscribe   ╰──────────────╯

这个主题对象在自身状态变化时，会通知所有订阅者对象，使它们能够自动更新自己的状态。

 * Thought Process:
 * 
 */
package DesignPattern;

/**
 *
 * @author xinrong
 */
class Subject implements ISubject {

    @Override
    public void addObserver(IObserver observer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteObserver(IObserver observer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notifyAllObservers(String msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
interface ISubject {
    public void addObserver(IObserver observer);
    public void deleteObserver(IObserver observer);
    public void notifyAllObservers(String msg);
}

public interface IObserver {
    public void updateMsg(String msg);
}

class Observer implements IObserver{

    @Override
    public void updateMsg(String msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
