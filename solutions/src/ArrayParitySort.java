import java.util.Arrays;

public class ArrayParitySort {

    public static void main(String[] args) {
        // Case 1
        System.out.println(Arrays.toString(ArrayParitySort.sortArrayByParity(new int[]{3, 1, 2, 4})));

        // Case 2
        System.out.println(Arrays.toString(ArrayParitySort.sortArrayByParity(new int[]{0})));
    }

    public static int[] sortArrayByParity(int[] nums) {
        int len = nums.length;
        int even = 0, odd = len - 1, temp, cur = 0;
        while (even < odd) {
            if ((nums[cur] & 1) == 0) {
                even++;
                cur++;
            } else {
                temp = nums[odd];
                nums[odd] = nums[cur];
                nums[cur] = temp;
                odd -= 1;
            }
        }
        return nums;
    }
}
