import java.util.Arrays;

public class ProductArrayExceptSelf {

    public static void main(String[] args) {
        // Case 1
        System.out.println(Arrays.toString(ProductArrayExceptSelf.productExceptSelf(new int[]{1, 2, 3, 4})));

        // Case 2
        System.out.println(Arrays.toString(ProductArrayExceptSelf.productExceptSelf(new int[]{-1, 1, 0, -3, 3})));

        // Case 3
        System.out.println(Arrays.toString(ProductArrayExceptSelf.productExceptSelf(new int[]{-4, 5, 2, -4, 4, 2, -3})));
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int lprod = 1, rprod = 1;
        result[0] = lprod;
        for (int i = 1; i < n; i++) {
            lprod = lprod * nums[i - 1];
            result[i] = lprod;
        }
        for (int i = n - 2; i >= 0; i--) {
            rprod = rprod * nums[i + 1];
            result[i] = rprod * result[i];
        }
        return result;
    }
}
