import java.util.Arrays;

public class TwoCityTravelPlan {

    public static void main(String[] args) {
        // Case 1
        System.out.println(TwoCityTravelPlan.twoCitySchedCost(new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}}));

        // Case 2
        System.out.println(TwoCityTravelPlan.twoCitySchedCost(new int[][]{{259, 770}, {448, 54}, {926, 667}, {184, 139}, {840, 118}, {577, 469}}));

        // Case 3
        System.out.println(TwoCityTravelPlan.twoCitySchedCost(new int[][]{{515, 563}, {451, 713}, {537, 709}, {343, 819}, {855, 779}, {457, 60}, {650, 359}, {631, 42}}));
    }

    public static int twoCitySchedCost(int[][] costs) {
        int n = costs.length / 2;
        int[][] memo = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(memo[i], -1);
        }
        return minCostPlan(costs, 0, 0, 0, memo);
    }

    private static int minCostPlan(int[][] costs, int x, int y, int cur, int[][] memo) {
        if (cur >= costs.length) return 0;
        int n = costs.length / 2;
        if (x == n && y == n)
            return 0;
        if (memo[x][y] != -1)
            return memo[x][y];
        int flyA = Integer.MAX_VALUE, flyB = Integer.MAX_VALUE;
        if (x < n) {
            flyA = minCostPlan(costs, x + 1, y, cur + 1, memo) + costs[cur][0];
        }
        if (y < n) {
            flyB = minCostPlan(costs, x, y + 1, cur + 1, memo) + costs[cur][1];
        }
        memo[x][y] = Math.min(flyA, flyB);
        return memo[x][y];
    }
}
