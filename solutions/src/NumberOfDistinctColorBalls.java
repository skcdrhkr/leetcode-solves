import java.util.Arrays;
import java.util.HashMap;

public class NumberOfDistinctColorBalls {

    public static void main(String[] args) {
        // Case 1
        System.out.println(Arrays.toString(NumberOfDistinctColorBalls.queryResults(4, new int[][]{{1, 4}, {2, 5}, {1, 3}, {3, 4}})));

        // Case 2
        System.out.println(Arrays.toString(NumberOfDistinctColorBalls.queryResults(4, new int[][]{{0, 1}, {1, 2}, {2, 2}, {3, 4}, {4, 5}})));
    }

    public static int[] queryResults(int limit, int[][] queries) {
        int len = queries.length;
        HashMap<Integer, Integer> colors = new HashMap<>();
        int[] res = new int[len];
        HashMap<Integer, Integer> balls = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];
            if (!balls.containsKey(ball)) {
                balls.put(ball, color);
                if (!colors.containsKey(color)) {
                    colors.put(color, 1);
                } else {
                    colors.put(color, colors.get(color) + 1);
                }
            } else {
                int curCount = colors.get(balls.get(ball));
                if (curCount == 1) colors.remove(balls.get(ball));
                else {
                    colors.put(balls.get(ball), curCount - 1);
                }
                balls.put(ball, color);
                if (!colors.containsKey(color)) {
                    colors.put(color, 1);
                } else {
                    colors.put(color, colors.get(color) + 1);
                }
            }
            res[i] = colors.keySet().size();
        }
        return res;
    }
}
