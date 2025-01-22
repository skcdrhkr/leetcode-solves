package binarysearch;

public class MaxValueAtGivenIndexInBoundedArray {
    public static void main(String[] args) {
        // Case 1
        //1, 1, 2, 1
        System.out.println(MaxValueAtGivenIndexInBoundedArray.maxValue(4, 2, 6));

        // Case 2
        System.out.println(MaxValueAtGivenIndexInBoundedArray.maxValue(3, 2, 18));

        // Case 3
        System.out.println(MaxValueAtGivenIndexInBoundedArray.maxValue(12, 6, 35));

        // Case 4
        System.out.println(MaxValueAtGivenIndexInBoundedArray.maxValue(6, 1, 10));
    }

    public static int maxValue(int n, int index, int maxSum) {
//7,8,9
        int lo = 1, hi = maxSum, mid;
        int result = 1;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (isValidValue(mid, index, n, maxSum)) {
                result = Math.max(result, mid);
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return result;
    }

    private static boolean isValidValue(int mid, int index, int n, int maxSum) {
        // 6, 7, 8, 9, 10, 1
        // 1, 1, 2, 1
        //todo:
        int leftLen = index;
        int rightLen = n - index - 1;
        long leftSum = 0, rightSum = 0;
        if (leftLen != 0) {
            if (leftLen < mid - 1) {
                int start = mid - leftLen;
                leftSum = ((leftLen + 1) / 2) * (2 * start + leftLen);
            } else {
                leftSum = (mid + 1) * (mid) / 2;
                leftSum += (leftLen - mid + 1);
            }
        }
        if (rightLen != 0) {
            if (rightLen < mid - 1) {
                int start = mid - rightLen;
                rightSum = ((rightLen + 1) / 2) * (2 * start + rightLen);
            } else {
                rightSum = (mid + 1) * (mid) / 2;
                rightSum += (rightLen - mid + 1);
            }
        }
        return maxSum >= (leftSum + rightSum - mid);
    }
}
