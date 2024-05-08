import java.util.Arrays;

public class RelativeRanks {

    public static void main(String[] args) {
        // Case 1
        System.out.println(Arrays.toString(RelativeRanks.findRelativeRanks(new int[]{5, 4, 3, 2, 1})));

        // Case 2
        System.out.println(Arrays.toString(RelativeRanks.findRelativeRanks(new int[]{10, 3, 8, 9, 4})));
    }

    public static String[] findRelativeRanks(int[] score) {
        int len = score.length;
        Integer[] ind = new Integer[len];

        for (int i = 0; i < len; i++) ind[i] = i;
        Arrays.sort(ind, (x, y) -> (score[y] - score[x]));
        System.out.println(Arrays.toString(ind));
        String[] result = new String[len];
        for (int i = 0; i < len; i++) {
            if (i == 0)
                result[ind[i]] = "Gold Medal";
            else if (i == 1)
                result[ind[i]] = "Silver Medal";
            else if (i == 2)
                result[ind[i]] = "Bronze Medal";
            else {
                result[ind[i]] = String.valueOf(i + 1);
            }
        }
        return result;
    }
}
