package topkelements;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
        // Case 1
        System.out.println(TopKFrequentElements.topKFrequent(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6, 7, 7, 8, 2, 3, 1, 1, 1, 10, 11, 5, 6, 2, 4, 7, 8, 5, 6}, 10));

        // Case 2
        System.out.println(TopKFrequentElements.topKFrequent(new int[]{6, 0, 1, 4, 9, 7, -3, 1, -4, -8, 4, -7, -3, 3, 2, -3, 9, 5, -4, 0}, 6));
    }

    public static List<Integer> topKFrequent(int[] arr, int k) {

        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            int prevVal = freq.getOrDefault(num, 0);
            freq.put(num, prevVal + 1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(freq::get));
        for (Integer key : freq.keySet()) {
            if (minHeap.size() < k) {
                minHeap.add(key);
            } else {
                minHeap.add(key);
                minHeap.poll();
            }
        }
        return new ArrayList<>(minHeap);
    }
}
