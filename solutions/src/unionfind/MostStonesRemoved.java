package unionfind;

import java.util.Arrays;

public class MostStonesRemoved {

    static class DisjointSet {
        public int[] parent;
        public int[] rank;

        public DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
            Arrays.fill(rank, 1);
        }

        public int find(int k) {
            if (parent[k] != k) {
                parent[k] = find(parent[k]);
            }
            return parent[k];
        }

        public void union(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);
            if(parentX==parentY)return;
            if (rank[parentX] > rank[parentY]) {
                parent[parentY] = parentX;
                rank[parentX] += rank[parentY];
            } else {
                parent[parentX] = parentY;
                rank[parentY] += rank[parentX];
            }
        }
    }

    public static void main(String[] args) {

        // Case 0
        System.out.println(MostStonesRemoved.removeStones(new int[][]{{0, 1}, {1, 2}, {1, 3}, {3, 3}, {2, 3}, {0, 2}}));

        // Case 1
        System.out.println(MostStonesRemoved.removeStones(new int[][]{{0, 0}, {0, 1}, {1, 2}, {1, 3}, {2, 1}, {2, 3}}));

        // Case 2
        System.out.println(MostStonesRemoved.removeStones(new int[][]{{0, 1}, {1, 0}, {1, 3}, {2, 1}, {2, 2}, {3, 0}, {4, 4}}));

        // Case 3
        System.out.println(MostStonesRemoved.removeStones(new int[][]{{1, 1}, {2, 0}, {2, 2}, {2, 7}, {3, 2}, {3, 5}, {5, 5}, {6, 10}, {7, 2}, {7, 3}}));
    }

    public static int removeStones(int[][] stones) {

        // Replace this placeholder return statement with your code
        int len = stones.length;
        DisjointSet disjointSet = new DisjointSet(20001);
        for (int i = 0; i < len; i++) {
            disjointSet.union(stones[i][0], stones[i][1] + 10001);

        }
        int groups = 0;
        for (int i = 0; i < 20001; i++) {
            if (disjointSet.rank[i] > 1 && disjointSet.parent[i] == i) groups += 1;
        }
        return len - groups;
    }
}
