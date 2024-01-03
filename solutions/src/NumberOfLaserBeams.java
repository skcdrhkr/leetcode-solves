/**
 * Problem URL: https://leetcode.com/problems/number-of-laser-beams-in-a-bank/description/
 * Level: Medium
 */

public class NumberOfLaserBeams {

    public static void main(String[] args) {
        // Case 1
        System.out.println(NumberOfLaserBeams.numberOfBeams(new String[]{"011001", "000000", "010100", "001000"}));
        // Case 2
        System.out.println(NumberOfLaserBeams.numberOfBeams(new String[]{"000", "111", "000"}));
    }

    public static int numberOfBeams(String[] bank) {
        int curSDCount = 0;
        int prevSDCount = 0;
        int res = 0;
        for (String s : bank) {
            curSDCount = countOnes(s);
            if (curSDCount == 0)
                continue;
            res += (curSDCount * prevSDCount);
            prevSDCount = curSDCount;
        }
        return res;
    }

    public static int countOnes(String cur) {
        int count = 0;
        for (char c : cur.toCharArray()) {
            count += (c - '0');
        }
        return count;
    }
}
