package subsets;

import java.util.ArrayList;

public class GenerateParenthesis {

    public static void main(String[] args) {
        // Case 1
        System.out.println(GenerateParenthesis.generateCombinations(1));

        // Case 2
        System.out.println(GenerateParenthesis.generateCombinations(3));

        // Case 3
        System.out.println(GenerateParenthesis.generateCombinations(4));
    }

    public static ArrayList<String> generateCombinations(int n) {

        // Replace this placeholder return statement with your code
        ArrayList<String> result = new ArrayList<>();
        getAllParenthesisCombinations(n, 0, new StringBuilder(), result);
        return result;
    }

    // (, (),()(),
    private static void getAllParenthesisCombinations(int n, int open, StringBuilder builder, ArrayList<String> result) {
        if (open < 0) return;
        if (builder.length() == 2 * n) {
            if (open == 0)
                result.add(builder.toString());
            return;
        }
        getAllParenthesisCombinations(n, open + 1, builder.append("("), result);
        builder.deleteCharAt(builder.length() - 1);
        getAllParenthesisCombinations(n, open - 1, builder.append(")"), result);
        builder.deleteCharAt(builder.length() - 1);
    }
}
