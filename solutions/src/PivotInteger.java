public class PivotInteger {

    static int[] hash = new int[1001];

    static {
        int sum = 0;
        for (int i = 0; i <= 1000; i++) {
            sum += i;
            hash[i] = sum;
        }
    }

    public static void main(String[] args) {
        // Case 1
        System.out.println(PivotInteger.pivotInteger(8));

        // Case 2
        System.out.println(PivotInteger.pivotInteger(1));

        // Case 3
        System.out.println(PivotInteger.pivotInteger(49));
    }

    public static int pivotInteger(int n) {
        int lo = 1, hi = n;
        int mid = hi;
        while (mid >= lo) {
            if (hash[mid] == hash[hi] - hash[mid - 1]) return mid;
            if (hash[mid] < hash[hi] - hash[mid - 1]) {
                break;
            }
            mid -= 1;
        }
        return -1;
    }
}
