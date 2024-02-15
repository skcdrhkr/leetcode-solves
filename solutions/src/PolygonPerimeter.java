import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Problem URL: https://leetcode.com/problems/find-polygon-with-the-largest-perimeter/description/
 * Level: Medium
 */

public class PolygonPerimeter {

    public static void main(String[] args) {
        // Case 1
        System.out.println(PolygonPerimeter.largestPerimeter(new int[]{5, 5, 5}));

        // Case 2
        System.out.println(PolygonPerimeter.largestPerimeter(new int[]{1, 12, 1, 2, 5, 50, 3}));

        // Case 3
        System.out.println(PolygonPerimeter.largestPerimeter(new int[]{5, 5, 50}));
    }

    public static long largestPerimeter(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long sum = 0;
        for (int num : nums) {
            sum += num;
            pq.add(num);
        }
        int cur;
        while (pq.size() > 2) {
            cur = pq.poll();
            if (cur < sum - cur) {
                return sum;
            }
            sum -= cur;
        }
        return -1;
    }
}
