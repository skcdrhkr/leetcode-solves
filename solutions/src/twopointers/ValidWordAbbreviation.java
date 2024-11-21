/**
 * Educative: https://www.educative.io/courses/grokking-coding-interview/valid-word-abbreviation
 */

package twopointers;

public class ValidWordAbbreviation {

    public static void main(String[] args) {
        // Case 1
        System.out.println(ValidWordAbbreviation.validWordAbbreviation("s", "s11"));

        // Case 2
        System.out.println(ValidWordAbbreviation.validWordAbbreviation("whsfrmkvubvzhlnuubu", "wh13232l1"));

        // Case 3
        System.out.println(ValidWordAbbreviation.validWordAbbreviation("subsequences", "3sequ3es"));
    }

    public static boolean validWordAbbreviation(String word, String abbr) {

        int first = 0, second = 0, num = 0;
        while (second < abbr.length()) {
            if (Character.isDigit(abbr.charAt(second))) {
                if (abbr.charAt(second) == '0')
                    return false;
                num = 0;
                while (second < abbr.length() && Character.isDigit(abbr.charAt(second))) {
                    num = num * 10 + (abbr.charAt(second) - '0');
                    second++;
                }
                first += num;
            } else {
                if (first >= word.length() || word.charAt(first) != abbr.charAt(second)) {
                    return false;
                }
                first++;
                second++;
            }
        }
        return first == word.length() && second == abbr.length();
    }
}
