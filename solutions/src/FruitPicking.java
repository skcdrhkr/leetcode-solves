public class FruitPicking {

    public static void main(String[] args) {
        // Case 1
        System.out.println(FruitPicking.totalFruit(new int[]{1, 2, 1}));

        // Case 2
        System.out.println(FruitPicking.totalFruit(new int[]{0, 1, 2, 2}));

        // Case 3
        System.out.println(FruitPicking.totalFruit(new int[]{1, 2, 3, 2, 2}));

        // Case 4
        System.out.println(FruitPicking.totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
    }

    public static int totalFruit(int[] fruits) {
        int len = fruits.length;
        if (len <= 2) return len;
        int left = 0, right = 0;
        int mx = 0;
        int first = -1, second = -1;
        while (right < len) {
            if (first == -1) {
                first = right;
            } else if (second == -1) {
                if (fruits[right] != fruits[first]) {
                    second = right;
                } else {
                    first = right;
                }
            } else if (fruits[right] == fruits[first]) {
                first = right;
            } else if (fruits[right] == fruits[second]) {
                second = right;
            } else {
                if (first < second) {
                    left = first + 1;
                    first = right;
                } else {
                    left = second + 1;
                    second = right;
                }

            }
            if (mx < (right - left + 1)) {
                mx = (right - left + 1);
            }
            right++;
        }
        return mx;
    }
}
