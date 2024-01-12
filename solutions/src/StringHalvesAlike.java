/**
 * Problem URL: https://leetcode.com/problems/determine-if-string-halves-are-alike/description
 * Level: Easy
 */

public class StringHalvesAlike {

    public static void main(String[] args) {
        // Case 1
        System.out.println(StringHalvesAlike.halvesAreAlike("book"));

        // Case 2
        System.out.println(StringHalvesAlike.halvesAreAlike("textbook"));
    }

    public static boolean halvesAreAlike(String s) {
        int i = 0, j = s.length() - 1;
        int counta = 0, countb = 0;
        while (i < j) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                counta++;
            }
            c = s.charAt(j);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                countb++;
            }
            i += 1;
            j -= 1;
        }
        return counta == countb;
    }
}
