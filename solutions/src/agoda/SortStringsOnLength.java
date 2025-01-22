package agoda;

import java.util.Arrays;

public class SortStringsOnLength {
    public static void main(String[] args) {
        String[] arr = new String[]{"ABCDE", "ABCD", "Z", "A", "AB", "AA", "ABC"};
        Arrays.sort(arr, (x, y) -> x.length() == y.length() ? x.compareTo(y) : x.length() - y.length());
        System.out.println(Arrays.toString(arr));
    }
}
