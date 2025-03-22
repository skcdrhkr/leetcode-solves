package slidingwindow;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Problem URL: https://leetcode.com/problems/sliding-window-maximum/
 * Level: Hard
 */

public class MaxInSlidingWindow {

    public static void main(String[] args) {
        // Case 1
        System.out.println(Arrays.toString(MaxInSlidingWindow.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));

        // Case 2
        System.out.println(Arrays.toString(MaxInSlidingWindow.maxSlidingWindow(new int[]{1}, 1)));

        // Case 3
        System.out.println(Arrays.toString(MaxInSlidingWindow.maxSlidingWindow(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 3)));

        // Case 4
        System.out.println(Arrays.toString(MaxInSlidingWindow.maxSlidingWindow(new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, 4)));

        // Case 5
        System.out.println(Arrays.toString(MaxInSlidingWindow.maxSlidingWindow(new int[]{10, 6, 9, -3, 23, -1, 34, 56, 67, -1, -4, -8, -2, 9, 10, 34, 67}, 3)));

        // Case 6
        System.out.println(Arrays.toString(MaxInSlidingWindow.maxSlidingWindow(new int[]{9, 5, 3, 1, 6, 3}, 2)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        MonotonicDeque md = new MonotonicDeque();
        int first = 0, second = 0;
        while (second < k && second < n) {
            md.add(second++, nums);
        }
        if (second == n) {
            int[] res = new int[1];
            res[0] = nums[md.getMax()];
            return res;
        }
        int[] res = new int[n - k + 1];
        while (second < n) {
            res[first++] = nums[md.getMax()];
            if (md.getMax()<first) {
                md.remove();
            }
            md.add(second, nums);
            second += 1;
        }
        res[first] = nums[md.getMax()];
        return res;
    }

    static class MonotonicDeque {
        public Deque<Integer> queue;

        public MonotonicDeque() {
            this.queue = new ArrayDeque<>();
        }

        public void add(int ind, int[] nums) {
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[ind]) {
                queue.pollLast();
            }
            queue.addLast(ind);
        }

        public void remove() {
            if (!queue.isEmpty())
                queue.pollFirst();
        }

        public int getMax() {
            return queue.peekFirst();
        }
    }

}
