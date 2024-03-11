/**
 * Problem URL: https://leetcode.com/problems/custom-sort-string/description
 * Level: Medium
 */


public class CustomSortString {

    public static void main(String[] args) {
        // Case 1
        System.out.println(CustomSortString.customSortString("cba", "abcd"));

        // Case 2
        System.out.println(CustomSortString.customSortString("bcafg", "abcd"));
    }

    public static String customSortString(String order, String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            int idx = order.charAt(i) - 'a';
            for (int j = 0; j < freq[idx]; j++) {
                builder.append((char) (idx + 'a'));
            }
            freq[idx] = 0;
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < freq[i]; j++) {
                builder.append((char) (i + 'a'));
            }
        }
        return builder.toString();
    }
}
