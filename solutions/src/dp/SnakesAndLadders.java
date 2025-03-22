package dp;

import java.util.PriorityQueue;

public class SnakesAndLadders {

    public static void main(String[] args) {
        // Case 1
        System.out.println(SnakesAndLadders.snakesAndLadders(new int[][]{{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}}));

        // Case 2
        System.out.println(SnakesAndLadders.snakesAndLadders(new int[][]{{-1, -1}, {-1, 3}}));
    }

    public static int snakesAndLadders(int[][] board) {
        int len = board.length;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int direction = 1;
        int[][] dp = new int[len][len];
        dp[len - 1][0] = 0;
        heap.add(0);
        int block = 0;
        while (block < len) {
            block++;
        }
        return 0;
    }
}
