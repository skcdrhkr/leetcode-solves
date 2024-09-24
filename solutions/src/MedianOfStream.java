import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfStream {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianOfStream() {
        // Write your code here
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void insertNum(int num) {
        if (minHeap.isEmpty()) {
            minHeap.add(num);
            return;
        }
        // Write your code here
        if (maxHeap.size() == minHeap.size()) {
            if (num >= maxHeap.peek()) {
                minHeap.add(num);
            } else {
                minHeap.add(maxHeap.poll());
                maxHeap.add(num);
            }
        } else {
            if (num <= minHeap.peek()) {
                maxHeap.add(num);
            } else {
                maxHeap.add(minHeap.poll());
                minHeap.add(num);
            }
        }
    }

    public double findMedian() {
        // Replace this placeholder return statement with your code
        if (maxHeap.size() == minHeap.size()) {
            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        } else {
            return (double) minHeap.peek();
        }
    }
}
