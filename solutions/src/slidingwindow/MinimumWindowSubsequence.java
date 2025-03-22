/**
 * Educative: https://www.educative.io/courses/grokking-coding-interview/minimum-window-subsequence
 */

package slidingwindow;

public class MinimumWindowSubsequence {

    public static void main(String[] args) {
        // Case 1
        System.out.println(MinimumWindowSubsequence.minWindow("abcdbebe", "bbe"));

        // Case 2
        System.out.println(MinimumWindowSubsequence.minWindow("afgegrwgwga", "aa"));

        // Case 3
        System.out.println(MinimumWindowSubsequence.minWindow("michmznaitnjdnjkdsnmichmznait", "michmznait"));

        // Case 4
        System.out.println(MinimumWindowSubsequence.minWindow("fgrqsqsnodwmxzkzxwqegkndaa", "kzed"));

        // Case 5
        System.out.println(MinimumWindowSubsequence.minWindow("aabcaakcmdcmc", "aacm"));

        // Case 6
        System.out.println(MinimumWindowSubsequence.minWindow("WUwjEoVvSyKnWdFYWidUbdsJfIXZabqgIpJKWZkiBEaJVljEgfigOVpTJObAyCktxmJEXzndTCJRxFZwWKgauoKbavkubGJhgFGKhdEUuIOhOawfFiFLBLVywszRgXfRGqlLUrZnVcRgbdCUXlmyMfYqoZWPtZVyTjPERlwhwytQluPynsigDRZSyvwMCQCEHaylhhLjODKZMUToKEbTJnOgDdhFkIUZFkrnJLdAaWacMelNYEJOGHeNJkwwKohVmGcsLvbbqJqeePOMjEuxVyYhwcVTcebtaXddOHhBhElRMbXvhxJsSdTLkDrpsfZKyoSiZAZQWqdkjerNGXEuDwcoJvaAdYFPYyWdmYrBscnpbwUhMNauDhTDDMLVGyMwESpNixjPYJfCPAshDkDdTrVSmuYHcddtjCubqBVnBwslMGgxUpgrAvpxpWYUHMRzMERFMkkfIJFXFNlakmzMhRPdTKOEgLtroClJxmOaKcwlzNjUNaiXENROsPgUQVKwfJiIkPleIbFeBgNOmtsbGLRxckwEEJuAyemKqkRmVGPVYzeViMZYaOwjkcHoyARNuGDFxJGjQKjHgEHPRnpGYhmSkIbzCDrqcAwcceUfjVByKBgMgGfcFwoOcFdYUjCjrtHZDUdsWqYQwkSNCCAqiqIDbkuMhQDWdcZVrYQgjaPjwVHtYKCIVGMsgytOwDSQwuftMUEgDRymaPYbbHtuxQWbALbSUzWvQsaZHahhHfSqFGsNkKHGHtvyPeFtMiCXUZPRATRKfpgBSbinfRrzVHAMhdRzLgjNCymgnHpxuExZftapyXQqgnucAuWeBVtMtwcJHHXlpQCUpqJLcpDaTPBjjDUANVrpLEfPriWJtWxwdlmBfoYpprPkriOUnzetUINsuHKNgMdOXouauqHHEjzvKvogVZthEncSFiKMIGrKxgMqswcDNnzuKBwmHHuZQBlKBHbrulOaHbbRgXJbSPvrRIQSktvslnMIawBt", "BQW"));
    }

    public static String minWindow(String s, String t) {
        int lens = s.length();
        int lent = t.length();
        int minL = Integer.MAX_VALUE;
        int minLeft = 0, minRight = 0;
        int left, right = 0;
        int index = 0;
        while (right < lens) {
            if (s.charAt(right) == t.charAt(index)) {
                index++;
                if (index == lent) {

                    index = lent - 1;
                    left = right;
                    while (left >= 0) {
                        if (s.charAt(left) == t.charAt(index)) {
                            index -= 1;
                        }
                        if (index == -1) break;
                        left -= 1;
                    }

                    if (minL > (right - left + 1)) {
                        minL = right - left + 1;
                        minLeft = left;
                        minRight = right;
                    }
                    index = 0;
                    right = left;
                }
            }
            right++;
        }
        if(minL==Integer.MAX_VALUE) return "";
        return s.substring(minLeft, minRight + 1);
    }
}
