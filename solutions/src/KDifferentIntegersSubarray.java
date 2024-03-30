import java.util.Arrays;

public class KDifferentIntegersSubarray {

    public static void main(String[] args) {
        // Case 1
        System.out.println(KDifferentIntegersSubarray.subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2));

        // Case 2
        System.out.println(KDifferentIntegersSubarray.subarraysWithKDistinct(new int[]{1, 2, 1, 3, 4}, 3));
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {
        int len = nums.length;
        int[] freq = new int[len + 1];
        int[] index = new int[len + 1];
        int curFreq = 0;
        Arrays.fill(index, -1);
        int result = 0;
        int first = 0, second = 0, leftMostValidIndex = -1;
        while (second < len) {
            freq[nums[second]]++;
            index[nums[second]] = second;
            if (freq[nums[second]] == 1) {
                curFreq++;
            }
            if (curFreq > k) {
                while (curFreq > k) {
                    freq[nums[first]]--;
                    if (freq[nums[first]] == 0) curFreq--;
                    first++;
                }
            }
            if (curFreq == k) {
                leftMostValidIndex = getLeftMostValidIndex(index, first, second);
                result += (leftMostValidIndex - first + 1);
            }
            second += 1;
        }
        return result;
    }

    private static int getLeftMostValidIndex(int[] index, int first, int second) {
        int lmvi = Integer.MAX_VALUE;
        for (int i = 1; i < index.length; i++) {
            if (index[i] >= first && index[i] <= second && index[i] != -1) {
                if (lmvi > index[i]) lmvi = index[i];
            }
        }
        return lmvi;
    }
}
