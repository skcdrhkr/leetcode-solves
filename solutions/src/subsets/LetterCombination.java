package subsets;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombination {

    public static void main(String[] args) {
        // Case 1
        System.out.println(LetterCombination.letterCombinations("2"));

        // Case 2
        System.out.println(LetterCombination.letterCombinations("73"));

        // Case 3
        System.out.println(LetterCombination.letterCombinations("426"));
    }

    public static List<String> letterCombinations(String digits) {

        // Replace this placeholder return statement with your code
        Map<Character, String> map = Map.of(
                '2', "abc",
                '3', "def",
                '4', "ghi",
                '5', "jkl",
                '6', "mno",
                '7', "pqrs",
                '8', "tuv",
                '9', "wxyz"
        );
        List<String> result = new ArrayList<>();
        getAllLetterCombinations(result, digits, 0, new StringBuilder(), map);

        return result;
    }

    private static void getAllLetterCombinations(List<String> result, String digits, int ind, StringBuilder builder, Map<Character, String> map) {
        if (ind == digits.length()) {
            result.add(builder.toString());
            return;
        }
        String cur = map.get(digits.charAt(ind));
        for (char c : cur.toCharArray()) {
            builder.append(c);
            getAllLetterCombinations(result, digits, ind + 1, builder, map);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
