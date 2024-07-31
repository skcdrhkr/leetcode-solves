public class CircularArray {
    public static void main(String[] args) {

        // Case 0
        System.out.println(CircularArray.circularArrayLoop(new int[]{-1, -2, -3, -4, -5, -6}));

        // Case 1
        System.out.println(CircularArray.circularArrayLoop(new int[]{1, -1, 5, 1, 4}));

        // Case 2
        System.out.println(CircularArray.circularArrayLoop(new int[]{2, 1, -1, -2}));

        // Case 3
        System.out.println(CircularArray.circularArrayLoop(new int[]{5, 4, -2, -1, 3}));
    }

    public static boolean circularArrayLoop(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            int fast = i, slow = i;
            boolean post = false;
            if (nums[i] > 0) post = true;
            while (true) {
                slow = nextStep(nums, slow, len);
                if (isNotCycle(nums, slow, post)) break;

                fast = nextStep(nums, fast, len);
                if (isNotCycle(nums, fast, post)) break;

                fast = nextStep(nums, fast, len);
                if (isNotCycle(nums, fast, post)) break;

                if (slow == fast) return true;
            }
        }
        return false;
    }

    private static boolean isNotCycle(int[] nums, int pointer, boolean direction) {
        boolean newDirection = nums[pointer] > 0;
        if (direction != newDirection || nums[pointer] % nums.length == 0)
            return true;
        return false;
    }

    private static int nextStep(int[] nums, int pointer, int size) {
        pointer = (pointer + nums[pointer]) % size;
        if (pointer < 0) pointer += size;
        return pointer;
    }
}
