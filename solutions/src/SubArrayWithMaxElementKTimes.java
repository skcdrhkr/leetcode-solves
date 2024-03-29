public class SubArrayWithMaxElementKTimes {

    public static void main(String[] args) {
        // Case 1
        System.out.println(SubArrayWithMaxElementKTimes.countSubarrays(new int[]{1, 3, 2, 3, 3}, 2));

        // Case 2
        System.out.println(SubArrayWithMaxElementKTimes.countSubarrays(new int[]{1, 4, 2, 1}, 3));

        // Case 3
        System.out.println(SubArrayWithMaxElementKTimes.countSubarrays(new int[]{4, 3, 7, 10, 2, 10, 1, 6, 10, 7, 10, 10, 9, 8, 3}, 3));
    }

    public static long countSubarrays(int[] nums, int k) {
        int len = nums.length;
        int first = 0, second = 0, mx = -1, freq = 0;
        long result = 0;
        for (int num : nums) {
            if (mx < num) mx = num;
        }
        while (second < len) {
            if (nums[second] == mx) freq++;
            while (freq>=k) {
                if(nums[first]==mx) freq--;
                first+=1;
            }
            result+=first;
            second++;
        }
        return result;
    }
}
