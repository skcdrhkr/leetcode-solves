import java.util.Arrays;

/**
 * Problem URL: https://leetcode.com/problems/bag-of-tokens/description
 * Level: Medium
 */


public class BagOfTokens {

    static int res = 0;

    public static void main(String[] args) {
        // Case 1
        System.out.println(BagOfTokens.bagOfTokensScore(new int[]{100}, 50));

        // Case 2
        System.out.println(BagOfTokens.bagOfTokensScore(new int[]{200, 100}, 150));

        // Case 3
        System.out.println(BagOfTokens.bagOfTokensScore(new int[]{100, 200, 300, 400}, 200));

        // Case 4
        System.out.println(BagOfTokens.bagOfTokensScore(new int[]{100, 200, 200, 300, 700}, 200));

    }

    public static int bagOfTokensScore(int[] tokens, int power) {
        res = 0;
        int n = tokens.length;
        if (n == 0) return 0;
        if (n == 1) {
            if (power >= tokens[0])
                return 1;
            else
                return 0;
        }
        Arrays.sort(tokens);
        int first = 0, last = n - 1;
        int score = 0;
        while (first <= last) {
            if (power >= tokens[first]) {
                power -= tokens[first];
                score += 1;
                first += 1;
            } else if (score > 0) {
                power += tokens[last];
                last -= 1;
                score -= 1;
            } else {
                break;
            }
            res = Math.max(res, score);
        }
        return res;
    }
}
