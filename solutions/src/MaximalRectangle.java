public class MaximalRectangle {

    public static void main(String[] args) {
        // Case 1
    }

    public static int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] grid = new int[n][m];
        int result;
        for (int i = 0; i < m; i++) {
            grid[0][i] = matrix[0][i] - '0';
        }
        result = largestRectangleArea(grid[0]);
        int area = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] != '0')
                    grid[i][j] = grid[i - 1][j] + (matrix[i][j] - '0');
            }
            area = largestRectangleArea(grid[i]);
            if (area > result) result = area;
        }
        return result;
    }

    private static int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int result = 0, cur;
        int[] stack = new int[len];
        int stackIndex = -1;
        int right;
        for (int i = 0; i < len; i++) {
            if (stackIndex == -1) {
                stackIndex++;
                stack[stackIndex] = i;
            } else {
                cur = heights[i];
                right = i;
                while (stackIndex > -1 && heights[stack[stackIndex]] > cur) {
                    int prev = stackIndex > 0 ? stack[stackIndex - 1] : -1;
                    int top = stack[stackIndex];
                    if (result < (right - prev - 1) * heights[top]) {
                        result = (right - prev - 1) * heights[top];
                    }
                    stackIndex--;
                }
                stackIndex++;
                stack[stackIndex] = i;
            }
        }
        right = len;
        while (stackIndex > -1) {
            int prev = stackIndex > 0 ? stack[stackIndex - 1] : -1;
            int top = stack[stackIndex];
            if (result < (right - prev - 1) * heights[top]) {
                result = (right - prev - 1) * heights[top];
            }
            stackIndex--;
        }
        return result;
    }
}
