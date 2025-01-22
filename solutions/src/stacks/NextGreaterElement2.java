package stacks;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement2 {

    public static void main(String[] args) {
        // Case 1
        System.out.println(Arrays.toString(NextGreaterElement2.nextGreaterElements(new int[]{1, 2, 3, 4, 3})));

        // Case 2
        System.out.println(Arrays.toString(NextGreaterElement2.nextGreaterElements(new int[]{4, -1, 3, 5, 12, 57, 13, 52, 4, 14, -4, 39, 10})));
    }

    public static int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[len];

        for (int i = 0; i < len; i++) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                result[st.pop()] = nums[i];
            }
            st.push(i);
        }
        for (int i = 0; i < len; i++) {
            while (!st.isEmpty() && nums[i] > nums[st.peek()]) {
                result[st.pop()] = nums[i];
            }
        }
        while (!st.isEmpty()) {
            result[st.pop()] = -1;
        }
        return result;
    }
}
