import java.util.Arrays;
import java.util.PriorityQueue;

public class KthSmallestPrimeFraction {

    public static void main(String[] args) {
        // Case 1
        System.out.println(Arrays.toString(KthSmallestPrimeFraction.kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3)));

        // Case 2
        System.out.println(Arrays.toString(KthSmallestPrimeFraction.kthSmallestPrimeFraction(new int[]{1, 7}, 1)));

        // Case 3
        System.out.println(Arrays.toString(KthSmallestPrimeFraction.kthSmallestPrimeFraction(new int[]{1, 3, 5, 7, 11, 17}, 5)));

        // Case 4
        System.out.println(Arrays.toString(KthSmallestPrimeFraction.kthSmallestPrimeFraction(new int[]{1, 2, 11, 37, 83, 89}, 11)));
    }

    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int len = arr.length;
        PriorityQueue<int[]> heap = new PriorityQueue<>((x, y) -> (x[1] * y[0] - x[0] * y[1]));

        for (int i = 0; i < len; i++) {
            for (int j = len - 1; j > i; j--) {
                heap.add(new int[]{arr[i], arr[j]});
                if (heap.size() > k) {
                    heap.poll();
                }
            }
        }
        return heap.peek();
    }
}
