import java.util.*;
import java.util.function.Supplier;

public class GroupOfFarmland {

    static int h, k;

    public static void main(String[] args) {
        // Case 1
        System.out.println(Arrays.deepToString(GroupOfFarmland.findFarmland(new int[][]{{1, 0, 0}, {0, 1, 1}, {0, 1, 1}})));

        // Case 2
        System.out.println(Arrays.deepToString(GroupOfFarmland.findFarmland(new int[][]{{1, 1}, {1, 1}})));

        // Case 3
        System.out.println(Arrays.deepToString(GroupOfFarmland.findFarmland(new int[][]{{0}})));
    }

    public static int[][] findFarmland(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1) {
                    h = i;
                    k = j;
                    dfs(land, i, j, n, m);
                    result.add(new int[]{i, j, h, k});
                }
            }
        }
        return result.toArray(new int[0][]);
    }

    private static void dfs(int[][] land, int x, int y, int n, int m) {
        if (x < 0 || x >= n || y < 0 || y >= m || land[x][y] == 0)
            return;
        h = Math.max(x, h);
        k = Math.max(y, k);
        land[x][y] = 0;
        dfs(land, x + 1, y, n, m);
        dfs(land, x, y + 1, n, m);
    }
}
