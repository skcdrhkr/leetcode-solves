package subsets;

import java.util.ArrayList;

public class Permutations {

    public static void main(String[] args) {
        // Case 1
        System.out.println(Permutations.permuteWord("ab"));

        // Case 2
        System.out.println(Permutations.permuteWord("bad"));
    }

    public static ArrayList<String> permuteWord(String word) {

        // Replace this placeholder return statement with your code
        char[] characters = word.toCharArray();
        ArrayList<String> result = new ArrayList<>();
        getAllPermutations(characters, result, 0);

        return result;
    }

    private static void getAllPermutations(char[] characters, ArrayList<String> result, int ind) {
        if (ind == characters.length - 1) {
            result.add(new String(characters));
            return;
        }
        for (int j = ind; j < characters.length; j++) {
            char temp = characters[ind];
            characters[ind] = characters[j];
            characters[j] = temp;
            getAllPermutations(characters, result, ind + 1);
            temp = characters[ind];
            characters[ind] = characters[j];
            characters[j] = temp;
        }
    }
}
