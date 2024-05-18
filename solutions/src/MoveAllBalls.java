import java.util.Arrays;

public class MoveAllBalls {

    public static void main(String[] args) {
        // Case 1
        System.out.println(Arrays.toString(MoveAllBalls.minOperations("110")));

        // Case 2
        System.out.println(Arrays.toString(MoveAllBalls.minOperations("001011")));
    }

    public static int[] minOperations(String boxes) {
        int len = boxes.length();
        int[] res = new int[len];
        int count = 0, sum = 0;
        for (int i = 0; i < len; i++) {
            sum += count;
            res[i] = sum;
            if (boxes.charAt(i) == '1') {
                count++;
            }
        }
        count = 0;
        sum = 0;
        for (int i = len - 1; i >= 0; i--) {
            sum += count;
            res[i] += sum;
            if (boxes.charAt(i) == '1') {
                count++;
            }
        }
        return res;
    }
}
