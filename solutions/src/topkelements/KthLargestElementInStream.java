package topkelements;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElementInStream {
    public static void main(String[] args) {
        // Case 1
        KthLargest topKHeap = new KthLargest(2, new int[]{3, 4, 5});
        System.out.println(topKHeap.add(40));
        System.out.println(topKHeap.add(50));
        System.out.println(topKHeap.add(30));
        System.out.println(topKHeap.add(60));
    }
}

class KthLargest {
    // constructor to initialize topKHeap and add values in it
    PriorityQueue<Integer> pq;
    int topK;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        topK = k;
        for (int num : nums) {
            if (pq.isEmpty() || pq.size() < k) {
                pq.add(num);
            } else {
                if (num > pq.peek()) {
                    pq.add(num);
                    pq.poll();
                }
            }
        }
    }

    // adds element in the topKHeap
    public int add(int val) {
        if (pq.isEmpty() || pq.size() < topK) {
            pq.add(val);
        } else {
            if (val > pq.peek()) {
                pq.add(val);
                pq.poll();
            }
        }
        return pq.peek();
    }
}