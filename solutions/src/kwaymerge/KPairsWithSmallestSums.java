package kwaymerge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KPairsWithSmallestSums {

    public static void main(String[] args) {
        // Case 1
        System.out.println(KPairsWithSmallestSums.kSmallestPairs(new int[]{1, 2, 300}, new int[]{1, 11, 20, 35, 300}, 300));

        // Case 2
        System.out.println(KPairsWithSmallestSums.kSmallestPairs(new int[]{4, 6}, new int[]{2, 3}, 2));
    }

    public static List<List<Integer>> kSmallestPairs(int[] list1, int[] list2, int target) {
        int len1 = list1.length;
        int len2 = list2.length;
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(x -> x[0] + x[1]));

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                minHeap.add(new int[]{list1[i], list2[j]});
            }
            int[] top = minHeap.poll();
            result.add(List.of(top[0], top[1]));
            target--;
        }
        while (!minHeap.isEmpty() && target > 0) {
            int[] top = minHeap.poll();
            result.add(List.of(top[0], top[1]));
            target--;
        }
        return result;
    }
}
