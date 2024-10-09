package unionfind;

import java.util.Arrays;

public class RedundantConnection {

    public static void main(String[] args) {

        // Case 0
        System.out.println(Arrays.toString(RedundantConnection.findRedundantConnection(new int[][]{{3, 4}, {1, 2}, {2, 4}, {3, 5}, {2, 5}})));

        // Case 1
        System.out.println(Arrays.toString(RedundantConnection.findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}})));

        // Case 2
        System.out.println(Arrays.toString(RedundantConnection.findRedundantConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}})));
    }

    public static int[] findRedundantConnection(int[][] edges) {
        DisjointSet disjointSet = new DisjointSet(1000);
        int[] result = new int[2];
        for (int[] cur : edges) {
            int x = cur[0];
            int y = cur[1];
            if (disjointSet.find(x) == disjointSet.find(y)) {
                result = cur;
            } else {
                disjointSet.union(x, y);
            }
        }
        return result;
    }
}
