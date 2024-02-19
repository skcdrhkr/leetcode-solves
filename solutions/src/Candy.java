/**
 * Problem URL: https://leetcode.com/problems/candy/description/
 * Level: Hard
 */

public class Candy {

    public static void main(String[] args) {
        // Case 1
        System.out.println(Candy.candy(new int[]{1, 0, 2}));

        // Case 2
        System.out.println(Candy.candy(new int[]{1, 2, 2}));

        // Case 3
        System.out.println(Candy.candy(new int[]{1, 2, 4, 3, 5, 2, 1, 3}));

        // Case 4
        System.out.println(Candy.candy(new int[]{3, 2, 4, 1, 1, 5, 2, 1, 2}));

        // Case 5
        System.out.println(Candy.candy(new int[]{1, 1, 1, 2, 2, 3, 2, 2, 1, 2, 2}));

        // Case 6
        System.out.println(Candy.candy(new int[]{0, 1, 2, 3, 2, 1}));
    }

    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] candy = new int[n];
        candy[0] = 1;
        int res = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            } else {
                candy[i] = 1;
            }
            res += candy[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                if (candy[i + 1] + 1 > candy[i]) {
                    res -= candy[i];
                    candy[i] = candy[i + 1] + 1;
                    res += candy[i];
                }
            }
        }
        return res;
    }
}
