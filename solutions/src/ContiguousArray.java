import java.util.Arrays;

public class ContiguousArray {

    public static void main(String[] args) {
        // Case 1
        System.out.println(ContiguousArray.findMaxLength(new int[]{0, 1}));

        // Case 2
        System.out.println(ContiguousArray.findMaxLength(new int[]{0, 1, 0}));

        // Case 3
        System.out.println(ContiguousArray.findMaxLength(new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1}));
    }

    public static int findMaxLength(int[] nums) {
        int n = nums.length;
        int zeroes = 0;
        int[] mp = new int[2 * n + 2];
        Arrays.fill(mp, Integer.MIN_VALUE);
        mp[n] = -1;
        int res = 0, num;
        for (int i = 0; i < n; i++) {
            num = nums[i];
            if (num == 0) {
                zeroes++;
            } else {
                zeroes--;
            }
            if (mp[zeroes + n] != Integer.MIN_VALUE) {
                res = Math.max(res, i - mp[zeroes + n]);
            } else {
                mp[zeroes + n] = i;
            }
        }
        return res;
    }
}
