public class LongestSubarrayWithKFrequency {

    public static void main(String[] args) {
        // Case 1
        System.out.println(LongestSubarrayWithKFrequency.maxSubarrayLength(new int[]{1, 2, 3, 1, 2, 3, 1, 2}, 2));

        // Case 2
        System.out.println(LongestSubarrayWithKFrequency.maxSubarrayLength(new int[]{1, 2, 1, 2, 1, 2, 1, 2, 1}, 1));

        // Case 3
        System.out.println(LongestSubarrayWithKFrequency.maxSubarrayLength(new int[]{5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, 4));
    }

    public static int maxSubarrayLength(int[] nums, int k) {
        int len = nums.length;
        int first = 0, second = 0;
        int result = 0, cur;
        int mx = Integer.MIN_VALUE, mn = Integer.MAX_VALUE;

        for (int num : nums) {
            if (mx < num) mx = num;
            if (mn > num) mn = num;
        }

        int[] mp = new int[mx - mn + 1];

        while (second < len) {
            mp[nums[second] - mn] += 1;
            cur = mp[nums[second] - mn];
            if (cur > k) {
                while (mp[nums[second] - mn] > k) {
                    mp[nums[first] - mn] -= 1;
                    first += 1;
                }
            }
            if (result < (second - first + 1)) {
                result = second - first + 1;
            }
            second += 1;
        }
        return result;
    }
}
