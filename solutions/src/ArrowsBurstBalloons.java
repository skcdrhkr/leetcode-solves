import java.util.Arrays;

public class ArrowsBurstBalloons {

    public static void main(String[] args) {
        // Case 1
        System.out.println(ArrowsBurstBalloons.findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));

        // Case 2
        System.out.println(ArrowsBurstBalloons.findMinArrowShots(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}));

        // Case 3
        System.out.println(ArrowsBurstBalloons.findMinArrowShots(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}));

        // Case 4
        System.out.println(ArrowsBurstBalloons.findMinArrowShots(new int[][]{{1, 4}, {3, 8}, {10, 12}, {13, 15}, {2, 5}, {6, 7}, {9, 10}, {11, 14}, {4, 16}}));

        // Case 5
        System.out.println(ArrowsBurstBalloons.findMinArrowShots(new int[][]{{1, 4}, {3, 8}, {10, 12}, {13, 15}, {2, 5}, {6, 7}, {9, 10}, {11, 14}}));

        // Case 6
        System.out.println(ArrowsBurstBalloons.findMinArrowShots(new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}}));
    }

    public static int findMinArrowShots(int[][] points) {
        int len = points.length;
        if (len == 1) return 1;
        Arrays.sort(points, (x, y) -> (x[1] > y[1] ? 1 : -1));
        int result = 1;
        int prevEnd = points[0][1];
        for (int i = 1; i < len; i++) {
            if (points[i][0] > prevEnd) {
                prevEnd = points[i][1];
                result++;
            }
        }
        return result;
    }
}
