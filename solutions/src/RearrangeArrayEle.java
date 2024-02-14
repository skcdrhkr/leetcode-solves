import java.util.Arrays;

/**
 * Problem URL: https://leetcode.com/problems/rearrange-array-elements-by-sign/description
 * Level: Medium
 */

public class RearrangeArrayEle {

    public static void main(String[] args) {
        // Case 1
        System.out.println(Arrays.toString(RearrangeArrayEle.rearrangeArray(new int[]{3, 1, -2, -5, 2, -4})));

        // Case 2
        System.out.println(Arrays.toString(RearrangeArrayEle.rearrangeArray(new int[]{-1, 1})));

        // Case 3
        System.out.println(Arrays.toString(RearrangeArrayEle.rearrangeArray(new int[]{-3, -4, 5, -6, 8, 3, 10, -1})));
    }

    public static int[] rearrangeArray(int[] nums) {
        int pos = 0, neg = 1, ind = 0;
        int n = nums.length;
        int[] res = new int[n];
        while (ind < n) {
            if (nums[ind] > 0) {
                res[pos] = nums[ind];
                pos += 2;
            } else {
                res[neg] = nums[ind];
                neg += 2;
            }
            ind += 1;
        }
        return res;
    }

    public static int[] rearrangeArrayImplicit(int[] nums) {
        int pos = 0, neg = 0, ind = 0, temp = Integer.MAX_VALUE;
        int n = nums.length;
        while (ind < n) {
            if ((ind & 1) == 0) {
                if (temp != Integer.MAX_VALUE) {
                    nums[ind++] = temp;
                    temp = Integer.MAX_VALUE;
                    pos = ind;
                } else {
                    while (nums[pos] < 0 && pos < n) pos++;
                    if (nums[ind] < 0) temp = nums[ind];
                    nums[ind++] = nums[pos++];
                }
            } else {
                if (temp != Integer.MAX_VALUE) {
                    nums[ind++] = temp;
                    temp = Integer.MAX_VALUE;
                    neg = ind;
                } else {
                    while (nums[neg] > 0 && neg < n) neg++;
                    if (nums[ind] > 0) temp = nums[ind];
                    nums[ind++] = nums[neg++];
                }
            }
        }
        return nums;
    }
}
