package graphs;

import java.util.HashSet;
import java.util.Set;

public class UniqueIslands {
    public static void main(String args[]) {
        // Case 1
        System.out.println(UniqueIslands.getUniqueIslands(new int[][]{{1, 1, 1, 1, 0, 0},
                {1, 1, 0, 0, 0, 1},
                {0, 0, 1, 1, 0, 1},
                {1, 1, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 1},
                {1, 0, 1, 1, 0, 0}}));

        // Case 2
        System.out.println(UniqueIslands.getUniqueIslands(new int[][]{{1, 1, 0, 0, 0}
                , {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}}));

        // Case 3
        System.out.println(UniqueIslands.getUniqueIslands(new int[][]{{1, 1, 0, 1, 1}, {1, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {1, 1, 0, 1, 1}}));

    }

    public static int getUniqueIslands(int[][] grid) {
        int n = grid.length;
        if (n < 1) return 0;
        int m = grid[0].length;

        Set<String> shapes = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder curShape = new StringBuilder();
                    performDFS(grid, i, j, n, m, curShape, 0);
                    shapes.add(curShape.toString());
                }
            }
        }
        return shapes.size();
    }

    private static void performDFS(int[][] grid, int i, int j, int n, int m, StringBuilder curShape, int node) {
        curShape.append(node);
        grid[i][j] = 0;
        int[] xs = {0, 0, 1, -1};
        int[] ys = {1, -1, 0, 0};
        for (int k = 0; k < 4; k++) {
            int p = i + xs[k];
            int q = j + ys[k];
            if (p >= 0 && p < n && q >= 0 && q < m && grid[p][q] == 1) {
                performDFS(grid, p, q, n, m, curShape, k + 1);
            }
        }
    }
}
