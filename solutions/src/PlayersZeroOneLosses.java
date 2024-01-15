/**
 * Problem URL: https://leetcode.com/problems/find-players-with-zero-or-one-losses/description
 * Level: Medium
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayersZeroOneLosses {

    public static void main(String[] args) {
        // Case 1
        System.out.println(PlayersZeroOneLosses.findWinners(new int[][]{{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}}));

        // Case 2
        System.out.println(PlayersZeroOneLosses.findWinners(new int[][]{{2, 3}, {1, 3}, {5, 4}, {6, 4}}));
    }

    public static List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> res = new ArrayList<>();
        int n = matches.length;
        int[] hash = new int[100001];
        int mx = -1;
        int mn = Integer.MAX_VALUE;
        Arrays.fill(hash, Integer.MIN_VALUE);
        for (int i = 0; i < n; i++) {
            if (hash[matches[i][0]] == Integer.MIN_VALUE) {
                hash[matches[i][0]] = 0;
            }
            if (hash[matches[i][1]] == Integer.MIN_VALUE) {
                hash[matches[i][1]] = -1;
            } else {
                hash[matches[i][1]] -= 1;
            }
            mx = Math.max(matches[i][0], Math.max(mx, matches[i][1]));
            mn = Math.min(matches[i][0], Math.min(mn, matches[i][1]));
        }
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());
        for (int i = 1; i <= mx; i++) {
            if (hash[i] == 0) {
                res.get(0).add(i);
            } else if (hash[i] == -1) {
                res.get(1).add(i);
            }
        }
        return res;
    }
}
