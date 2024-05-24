import java.util.ArrayList;
import java.util.List;

public class ArrayForm {

    public static void main(String[] args) {
        // Case 1
        System.out.println(ArrayForm.addToArrayForm(new int[]{1, 2, 0, 0}, 34));

        // Case 2
        System.out.println(ArrayForm.addToArrayForm(new int[]{2, 7, 4}, 181));

        // Case 3
        System.out.println(ArrayForm.addToArrayForm(new int[]{2, 1, 5}, 806));
    }

    public static List<Integer> addToArrayForm(int[] num, int k) {
        int len = num.length;
        List<Integer> result = new ArrayList<>();
        int car = k;
        for (int i = len - 1; i >= 0; i--) {
            int cur = num[i];
            cur += car;
            result.add(0, cur % 10);
            car = cur / 10;
        }
        if (car != 0) {
            while (car > 0) {
                result.add(0, car % 10);
                car /= 10;
            }
        }
        return result;
    }
}
