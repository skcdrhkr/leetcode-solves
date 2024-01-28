import java.util.List;

/**
 * Problem URL: https://leetcode.com/problems/triangle/description/
 * Level: Medium
 */

public class Triangle {

    // This will fail as List.of() returns a immutable list
    public static void main(String[] args) {
        // Case 1
        System.out.println(Triangle.minimumTotal(List.of(List.of(2), List.of(3, 4), List.of(6, 5, 7), List.of(4, 1, 8, 3))));

        // Case 2
        System.out.println(Triangle.minimumTotal(List.of(List.of(-10))));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size(), temp;
        if (n == 1)
            return triangle.get(0).get(0);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            List<Integer> cur = triangle.get(i - 1);
            int sz = triangle.get(i).size();
            for (int j = 0; j < sz; j++) {
                temp = triangle.get(i).get(j);
                if (j == 0) {
                    triangle.get(i).set(j, cur.get(j) + temp);
                } else if (j == sz - 1) {
                    triangle.get(i).set(j, cur.get(j - 1) + temp);
                } else {
                    triangle.get(i).set(j, Math.min(cur.get(j), cur.get(j - 1)) + temp);
                }
                if (i == n - 1 && triangle.get(i).get(j) < min) {
                    min = triangle.get(i).get(j);
                }
            }
        }
        return min;
    }
}
