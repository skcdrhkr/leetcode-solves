import java.util.Stack;

/**
 * Problem URL: https://leetcode.com/problems/trapping-rain-water/
 * Level: Hard
 */

public class TrappingRainwater {

    public static void main(String[] args) {
        // Case 1
        System.out.println(TrappingRainwater.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));

        // Case 2
        System.out.println(TrappingRainwater.trap(new int[]{4, 2, 0, 3, 2, 5}));

        // Case 3
        System.out.println(TrappingRainwater.trap(new int[]{6, 4, 3, 2, 5, 7}));

        // Case 4
        System.out.println(TrappingRainwater.trap(new int[]{6, 4, 2, 3, 5, 7, 5, 4, 3, 4}));
    }

    public static int trap(int[] height) {
        int n = height.length;
        if (n < 3)
            return 0;
        int lmxtillnow = 0;
        int rmx = 0;
        int res = 0;
        int cur = n - 2, ind = 1;
        int mnboth;
        Stack<Integer> st = new Stack<>();
        st.push(n - 1);
        while (cur >= 2) {
            if (height[cur] >= height[st.peek()]) {
                st.push(cur);
            }
            cur -= 1;
        }
        while (ind < n) {
            if (height[ind] >= height[lmxtillnow]) {
                lmxtillnow = ind;
                ind += 1;
                continue;
            }
            while (!st.isEmpty() && st.peek() <= ind) {
                st.pop();
            }
            if (st.isEmpty()) break;
            rmx = st.peek();
            mnboth = Math.min(height[lmxtillnow], height[rmx]);
            if (mnboth > height[ind]) {
                res += mnboth - height[ind];
            }
            ind += 1;
        }
        return res;
    }
}