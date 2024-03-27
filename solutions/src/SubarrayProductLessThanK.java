public class SubarrayProductLessThanK {

    public static void main(String[] args) {
        // Case 1
        System.out.println(SubarrayProductLessThanK.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));

        // Case 2
        System.out.println(SubarrayProductLessThanK.numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0));

        // Case 3
        System.out.println(SubarrayProductLessThanK.numSubarrayProductLessThanK(new int[]{2, 3, 2, 1, 3, 4, 1}, 12));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int len = nums.length;
        int first = 0, second = 0;
        int product = 1;
        int result = 0, size;
        while (first < len) {
            while (second < len && product < k) {
                product *= nums[second];
                second++;
            }
            if (second > first) {
                if (product >= k)
                    result += second - first - 1;
                else
                    result += second - first;
                product /= nums[first];
            } else {
                second = first + 1;
            }
            first++;
        }
        return result;
    }
}
