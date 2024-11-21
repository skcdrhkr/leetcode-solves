package kwaymerge;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestNumInMSortedLists {

    public static void main(String[] args) {
        // Case 1
        System.out.println(KthSmallestNumInMSortedLists.kSmallestNumber(List.of(List.of(2, 6, 8), List.of(3, 7, 10)
                , List.of(5, 8, 11)), 5));

        // Case 2
        System.out.println(KthSmallestNumInMSortedLists.kSmallestNumber(List.of(List.of(4, 6), List.of(2, 3), List.of(8, 9)), 10));
    }

    public static int kSmallestNumber(List<List<Integer>> lists, int k) {
        int result = 0, count = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(x -> lists.get(x[0]).get(x[1])));
        for (int i = 0; i < lists.size(); i++) {
            if (!lists.get(i).isEmpty())
                minHeap.add(new int[]{i, 0});
        }
        if (minHeap.isEmpty()) return result;
        while (count < k && !minHeap.isEmpty()) {
            count++;
            int[] top = minHeap.poll();
            result = lists.get(top[0]).get(top[1]);
            if (count == k) break;
            if (lists.get(top[0]).size() > top[1] + 1) {
                int nxtIndex = top[1] + 1;
                minHeap.add(new int[]{top[0], nxtIndex});
            }
        }
        return result;
    }
}
