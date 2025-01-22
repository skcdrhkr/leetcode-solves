package unionfind;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        // Case 1
        System.out.println(LongestConsecutiveSequence.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));

        // Case 2
        System.out.println(LongestConsecutiveSequence.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }

    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int result = 0, curSeq = 0;
        Arrays.stream(nums).forEach(set::add);
        for (int num : nums) {
            if (set.contains(num - 1)) {
                continue;
            }
            int cur = num;
            curSeq = 0;
            while (set.contains(cur)) {
                cur = cur + 1;
                curSeq++;
            }
            if (result < curSeq) {
                result = curSeq;
            }
        }
        return result;
    }
}
