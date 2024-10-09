package unionfind;

import java.util.Arrays;

public class DisjointSet {
    private int[] list;
    private int[] rank;

    public DisjointSet(int n) {
        list = new int[n + 1];
        rank = new int[n + 1];
        Arrays.fill(rank, 1);
        for (int i = 0; i <= n; i++) list[i] = i;
    }

    public int find(int k) {
        if(list[k]!=k) {
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
