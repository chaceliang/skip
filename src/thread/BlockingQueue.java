package thread;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chace on 6/4/14.
 */
public class BlockingQueue {

    private Queue queue = new LinkedList();

    public synchronized Object dequeue() {
        Object msg = null;
        while (queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                return msg;
            }
        }
        msg = queue.remove();
        return msg;
    }

    public synchronized void enqueue(Object o) {
        queue.add(o);
        notify();
    }
}

class Consumer1 implements Runnable {

    private BlockingQueue queue = null;

    public void process(Object msg) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            doStuff();
        }
    }

    public void doStuff() {
        Object msg = queue.dequeue();
        process(msg);
    }
}

class Producer1 implements Runnable {

    private BlockingQueue queue = null;

    @Override
    public void run() {

    }

    public void doSomething(Object msg) {
        queue.enqueue(msg);
    }
}
