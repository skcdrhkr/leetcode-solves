package heaps;

import java.util.*;

public class SlidingWindowMedian {

    public static void main(String[] args) {
        // Case 1
        System.out.println(Arrays.toString(SlidingWindowMedian.medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));

        // Case 2
        System.out.println(Arrays.toString(SlidingWindowMedian.medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 5)));

        // Case 3
        System.out.println(Arrays.toString(SlidingWindowMedian.medianSlidingWindow(new int[]{2147483647, -14756, 21474, -2147483646, -2147483647, -5555, 9999, 78967}, 8)));
    }

    public static double[] medianSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        MedianOfStream medianOfStream = new MedianOfStream();
        int left = 0, right = 0;
        while (right < k) {
            medianOfStream.insertNum(nums[right++]);
        }
        double[] result = new double[len - k + 1];
        result[0] = medianOfStream.getMedian();
        while (right < len) {
            medianOfStream.insertNum(nums[right++]);
            medianOfStream.removeNum(nums[left++]);
            result[left] = medianOfStream.getMedian();
        }
        return result;
    }

    public static double[] medianSlidingWindowEducative(int[] nums, int k) {
        List<Double> medians = new ArrayList<Double>();

        HashMap<Integer, Integer> outgoingNum = new HashMap<>();

        PriorityQueue<Integer> smallList = new PriorityQueue<>(Collections.reverseOrder());

        PriorityQueue<Integer> largeList = new PriorityQueue<>();

        for (int i = 0; i < k; i++)
            smallList.offer(nums[i]);

        for (int i = 0; i < k / 2; i++)
            largeList.offer(smallList.poll());

        int balance = 0;

        int i = k;
        while (true) {
            if ((k & 1) == 1)
                medians.add((double) (smallList.peek()));
            else
                medians.add((double) ((long) smallList.peek() + (long) largeList.peek()) * 0.5);

            if (i >= nums.length)
                break;

            int outNum = nums[i - k];

            int inNum = nums[i];
            i++;

            if (outNum <= smallList.peek())
                balance -= 1;
            else
                balance += 1;

            if (outgoingNum.containsKey(outNum))
                outgoingNum.put(outNum, outgoingNum.get(outNum) + 1);
            else
                outgoingNum.put(outNum, 1);

            if (smallList.size() > 0 && inNum <= smallList.peek()) {
                balance += 1;
                smallList.offer(inNum);
            } else {
                balance -= 1;
                largeList.offer(inNum);
            }

            if (balance < 0)
                smallList.offer(largeList.poll());
            else if (balance > 0)
                largeList.offer(smallList.poll());

            balance = 0;

            while (smallList.size() > 0 && outgoingNum.containsKey(smallList.peek()) && outgoingNum.get(smallList.peek()) > 0)
                outgoingNum.put(smallList.peek(), outgoingNum.get(smallList.poll()) - 1);

            while (largeList.size() > 0 && outgoingNum.containsKey(largeList.peek()) && outgoingNum.get(largeList.peek()) > 0)
                outgoingNum.put(largeList.peek(), outgoingNum.get(largeList.poll()) - 1);
        }

        double[] arr = medians.stream().mapToDouble(Double::doubleValue).toArray();
        return arr;
    }

    static class MedianOfStream {
        PriorityQueue<Integer> minHeap;
        PriorityQueue<Integer> maxHeap;

        public MedianOfStream() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        }

        public void insertNum(int num) {
            if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
        }

        public double getMedian() {
            if (maxHeap.size() == minHeap.size()) {
                return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
            }
            return maxHeap.peek();
        }

        public void removeNum(int num) {

            if (num <= maxHeap.peek()) {
                maxHeap.remove(num);
            } else minHeap.remove(num);

            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
        }
    }
}
