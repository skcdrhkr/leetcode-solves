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

class DisjointSet {
    private int[] list;
    private int[] rank;

    public DisjointSet(int n) {
        list = new int[n + 1];
        rank = new int[n + 1];
        Arrays.fill(rank, 1);
        for (int i = 0; i <= n; i++) list[i] = i;
    }

    public int find(int k) {
        if (list[k] != k) {
            list[k] = find(list[k]);
        }
        return list[k];
    }

    public void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        if (rank[parentY] > rank[parentX]) {
            list[parentX] = parentY;
            rank[parentY] += rank[parentX];
        } else {
            list[parentY] = parentX;
            rank[parentX] += rank[parentY];
        }
    }
}
