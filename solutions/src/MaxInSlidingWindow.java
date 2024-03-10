import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

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
        Deque<Integer> deque = new ArrayDeque<>();
        int left = 0, right = 0;
        int m = k >= n ? 1 : n - k + 1;
        int[] result = new int[m];
        while (right < k && right < n) {
            if (deque.isEmpty()) {
                deque.add(right);
            } else if (nums[deque.peekFirst()] < nums[right]) {
                deque.addFirst(right);
            } else {
                while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[right]) {
                    deque.pollLast();
                }
                deque.addLast(right);
            }
            right += 1;
        }
        result[left++] = nums[deque.peekFirst()];
        while (right < n) {
            while (!deque.isEmpty() && deque.peekFirst() < left) {
                deque.pollFirst();
            }
            if (deque.isEmpty()) {
                deque.add(right);
            } else if (nums[deque.peekFirst()] < nums[right]) {
                deque.addFirst(right);
            } else {
                while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[right]) {
                    deque.pollLast();
                }
                deque.addLast(right);
            }
            result[left++] = nums[deque.peekFirst()];
            right++;
        }
        return result;
    }

    static class MonotonicQueue {
        private LinkedList<Integer> list;

        public MonotonicQueue() {
            list = new LinkedList<>();
        }

        public boolean add(int num) {
            while (!list.isEmpty() && list.peekLast() <= num) {
                list.pollLast();
            }
            list.addLast(num);
            return true;
        }
    }
}
