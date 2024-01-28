/**
 * Problem URL: https://leetcode.com/problems/delete-and-earn/description/
 * Level: Medium
 */

public class DeleteEarn {

    public static void main(String[] args) {
        // Case 1
        System.out.println(DeleteEarn.deleteAndEarn(new int[]{3, 4, 2}));

        // Case 2
        System.out.println(DeleteEarn.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
    }

    public static int deleteAndEarn(int[] nums) {
        int[] freq = new int[10001];
        int mx = -1;
        int n = nums.length;
        if (n == 1)
            return nums[0];
        for (int num : nums) {
            freq[num] += 1;
            if (num > mx)
                mx = num;
        }
        int first = 0, second = 0, temp;
        for (int k = mx; k > 0; k--) {
            temp = Math.max(freq[k] * k + first, second);
            first = second;
            second = temp;
        }
        return second;
    }
}
