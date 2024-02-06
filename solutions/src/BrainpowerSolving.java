/**
 * Problem URL: https://leetcode.com/problems/solving-questions-with-brainpower/description
 * Level: Medium
 */
public class BrainpowerSolving {

    public static void main(String[] args) {
        // Case 1
        System.out.println(BrainpowerSolving.mostPoints(new int[][]{{3, 2}, {4, 3}, {4, 4}, {2, 5}}));

        // Case 2
        System.out.println(BrainpowerSolving.mostPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}}));
    }

    public static long mostPoints(int[][] quest) {
        int n = quest.length;
        if (n == 1)
            return quest[0][0];
        long[] sv = new long[n];
        sv[n - 1] = quest[n - 1][0];
        long slct, nslct;
        for (int i = n - 2; i >= 0; i--) {
            slct = (i + 1) >= n ? 0 : sv[i + 1];
            nslct = (i + 1 + quest[i][1]) >= n ? 0 : sv[i + 1 + quest[i][1]];
            sv[i] = Math.max(slct, quest[i][0] + nslct);
        }
        return sv[0];
    }

    private static long mostPointsRecur(int[][] quest, int i, long[] sv) {
        if (i >= quest.length)
            return 0;
        if (sv[i] != 0)
            return sv[i];
        sv[i] = Math.max(mostPointsRecur(quest, i + 1, sv), quest[i][0] + mostPointsRecur(quest, i + 1 + quest[i][1], sv));
        return sv[i];
    }
}
