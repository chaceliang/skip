package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by chace on 6/11/14.
 */
public class StreamMedian {

    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    private int numOfElements;

    public StreamMedian() {
        this.minHeap = new PriorityQueue<Integer>(1000, new MinHeapComparator());
        this.maxHeap = new PriorityQueue<Integer>(1000, new MaxHeapComparator());
        this.numOfElements = 0;
    }

    public void addNumberToStream(Integer num) {
        this.maxHeap.add(num);
        if (this.numOfElements % 2 == 0) {
            if (this.minHeap.isEmpty()) {
                this.numOfElements++;
                return;
            } else if (this.maxHeap.peek() > this.minHeap.peek()) {
                Integer maxHeapRoot = this.maxHeap.poll();
                Integer minHeapRoot = this.minHeap.poll();
                this.maxHeap.add(minHeapRoot);
                this.minHeap.add(maxHeapRoot);
            }
        } else {
            this.minHeap.add(maxHeap.poll());
        }
        this.numOfElements++;
    }

    public Double getMedian() {
        if (this.numOfElements % 2 == 0) {
            return (this.maxHeap.peek() + this.minHeap.peek()) / 2.0;
        } else {
            return new Double(this.maxHeap.peek());
        }
    }

    public static void main(String[] args) {
        StreamMedian streamMedian = new StreamMedian();

        streamMedian.addNumberToStream(1);
        System.out.println(streamMedian.getMedian()); // should be 1

        streamMedian.addNumberToStream(5);
        streamMedian.addNumberToStream(10);
        streamMedian.addNumberToStream(12);
        streamMedian.addNumberToStream(2);
        System.out.println(streamMedian.getMedian()); // should be 5

        streamMedian.addNumberToStream(3);
        streamMedian.addNumberToStream(8);
        streamMedian.addNumberToStream(9);
        System.out.println(streamMedian.getMedian()); // should be 6.5
    }
}


class MaxHeapComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}

class MinHeapComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 - o2;
    }
}