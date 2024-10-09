package unionfind;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslandsUF {

    static class DisjointSet {
        public int[] list;
        public int[] rank;

        public DisjointSet(List<List<Character>> grid) {
            int n = grid.size();
            int m = grid.get(0).size();
            int size = n * m + 1;
            list = new int[size + 1];
            rank = new int[size + 1];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid.get(i).get(j) == '1') {
                        list[i * m + j] = (i * m + j);
                    } else {
                        list[i * m + j] = Integer.MAX_VALUE;
                    }
                }
            }
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


    public static void main(String[] args) {
        // Case 1
        char[][] case1 = new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        List<List<Character>> list1 = new ArrayList<>();
        for (char[] temp : case1) {
            ArrayList<Character> cur = new ArrayList<>();
            for (char c : temp) {
                cur.add(c);
            }
            list1.add(cur);
        }
        System.out.println(NumberOfIslandsUF.numIslands(list1));

        // Case 2
        char[][] case2 = new char[][]{{'1', '1', '1', '1', '0'}, {'1', '0', '0', '0', '1'}, {'1', '0', '0', '1', '1'}, {'0', '1', '0', '1', '0'}, {'1', '1', '0', '1', '1'}};
        List<List<Character>> list2 = new ArrayList<>();
        for (char[] temp : case2) {
            ArrayList<Character> cur = new ArrayList<>();
            for (char c : temp) {
                cur.add(c);
            }
            list2.add(cur);
        }
        System.out.println(NumberOfIslandsUF.numIslands(list2));

    }

    public static int numIslands(List<List<Character>> grid) {

        int n = grid.size();
        int m = grid.get(0).size();
        DisjointSet disjointSet = new DisjointSet(grid);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid.get(i).get(j) == '1') {
                    if (j != 0 && grid.get(i).get(j - 1) == '1') {
                        disjointSet.union(i * m + j, i * m + (j - 1));
                    }
                    if (i != 0 && grid.get(i - 1).get(j) == '1') {
                        disjointSet.union(i * m + j, (i - 1) * m + j);
                    }
                }
            }
        }
        int result = 0;
        for (int i = 0; i <= (n * m + 1); i++) {
            if (disjointSet.list[i] == i) result++;
        }
        return result;
    }
}
