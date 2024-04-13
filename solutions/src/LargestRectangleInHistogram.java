public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        // Case 1
        System.out.println(LargestRectangleInHistogram.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));

        // Case 2
        System.out.println(LargestRectangleInHistogram.largestRectangleArea(new int[]{2, 4}));
    }

    public static int largestRectangleArea(int[] heights) {
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
