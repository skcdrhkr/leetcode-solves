package topkelements;

import java.util.PriorityQueue;

public class KthLargestElementInArray {

    public static void main(String[] args) {
        // Case 1
        System.out.println(KthLargestElementInArray.findKthLargest(new int[]{5, 2, 9, -3, 7}, 1));

        // Case 2
        System.out.println(KthLargestElementInArray.findKthLargest(new int[]{10000, -10000, 5000, 8000, -9000}, 4));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}
