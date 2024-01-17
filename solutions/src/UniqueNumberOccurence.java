import java.util.Arrays;

/**
 * Problem URL: https://leetcode.com/problems/unique-number-of-occurrences/description/
 * Level: Easy
 */

public class UniqueNumberOccurence {

    public static void main(String[] args) {
        // Case 1
        System.out.println(UniqueNumberOccurence.uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));

        // Case 2
        System.out.println(UniqueNumberOccurence.uniqueOccurrences(new int[]{1, 2}));

        // Case 3
        System.out.println(UniqueNumberOccurence.uniqueOccurrences(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}));
    }

    public static boolean uniqueOccurrences(int[] arr) {
        int n = arr.length;
        if (n == 1)
            return true;
        int[] freq = new int[2001];
        boolean[] check = new boolean[1001];
        for (int j : arr) {
            freq[j + 1000] += 1;
        }
        for (int j : arr) {
            int count = freq[j + 1000];
            freq[j + 1000] = 0;
            if (count > 0) {
                if (check[count])
                    return false;
                check[count] = true;
            }
        }
        return true;
    }

    public static boolean uniqueOccurrences2(int[] arr) {
        int n = arr.length;
        if (n == 1)
            return true;
        Arrays.sort(arr);
        boolean[] freq = new boolean[1001];
        int cur = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {
                cur++;
            } else {
                if (freq[cur])
                    return false;
                freq[cur] = true;
                cur = 1;
            }
        }
        return !freq[cur];
    }
}
