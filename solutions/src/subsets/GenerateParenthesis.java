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

        ArrayList<String> result = new ArrayList<String>();
        getAllCombinations(new StringBuilder(), n, 0, result);
        return result;
    }

    private static void getAllCombinations(StringBuilder builder, int n, int open, ArrayList<String> result) {
        if (open < 0) return;
        if (builder.length() == (2 * n)) {
            if (open != 0) return;
            result.add(builder.toString());
            return;
        }
        builder.append("(");
        getAllCombinations(builder, n, open + 1, result);
        builder.deleteCharAt(builder.length() - 1);
        builder.append(")");
        getAllCombinations(builder, n, open - 1, result);
        builder.deleteCharAt(builder.length() - 1);
    }
}
