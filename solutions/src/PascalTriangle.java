import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static void main(String[] args) {
        // Case 1
        System.out.println(PascalTriangle.generate(4));

        // Case 2
        System.out.println(PascalTriangle.generate(2));

        // Case 3
        System.out.println(PascalTriangle.generate(10));
    }

    public static List<List<Integer>> generate(int numRows) {
        int cur = 1;
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.get(0).add(1);
        if (numRows == 1) {
            return result;
        }
        cur += 1;
        while (cur <= numRows) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prev = result.get(result.size() - 1);
            row.add(1);
            for (int i = 1; i < cur - 1; i++) {
                row.add(prev.get(i) + prev.get(i - 1));
            }
            row.add(1);
            result.add(row);
            cur += 1;
        }
        return result;
    }
}
