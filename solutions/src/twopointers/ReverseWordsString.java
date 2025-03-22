/**
 * Educative: https://www.educative.io/courses/grokking-coding-interview/reverse-words-in-a-string
 */

package twopointers;

public class ReverseWordsString {

    public static void main(String[] args) {
        // Case 1
        System.out.println(ReverseWordsString.reverseWords("We love Java "));

        // Case 2
        System.out.println(ReverseWordsString.reverseWords("To be or not to be"));

        // Case 3
        System.out.println(ReverseWordsString.reverseWords("You     are    amazing"));

        // Case 4
        System.out.println(ReverseWordsString.reverseWords("Hello     World"));

        // Case 5
        System.out.println(ReverseWordsString.reverseWords(" Hey"));
    }

    public static String reverseWords(String s) {
        s = s.trim();
        String[] words = s.split("\\s+");
        int first = 0, second = words.length - 1;
        while (first < second) {
            String temp = words[first];
            words[first] = words[second];
            words[second] = temp;
            first += 1;
            second -= 1;
        }
        return String.join(" ", words);
    }
}
