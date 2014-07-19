package thread;

import java.lang.Thread;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by chace on 6/24/14.
 */
public class BlockingQueueExample {

    public static void main(String[] args) throws Exception {
        BlockingQueue queue = new ArrayBlockingQueue(1024);
        ProducerBQ producer = new ProducerBQ(queue);
        ConsumerBQ consumer = new ConsumerBQ(queue);
        new Thread(producer).start();
        new Thread(consumer).start();

        Thread.sleep(4000);
    }
}

class ProducerBQ implements Runnable {

    protected BlockingQueue queue = null;

    public ProducerBQ(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            queue.add("1");
            Thread.sleep(1000);
            queue.put("2");
            Thread.sleep(1000);
            queue.put("3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ConsumerBQ implements Runnable {

    protected BlockingQueue queue = null;

    public ConsumerBQ(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
