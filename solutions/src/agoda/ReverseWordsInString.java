package agoda;

public class ReverseWordsInString {
    public static void main(String[] args) {
        // Case 1
        System.out.println(ReverseWordsInString.reverseWords("This is test!!!"));

        // Case 2
        System.out.println(ReverseWordsInString.reverseWords("Hello, Bangkok:)"));

        // Case 3
        System.out.println(ReverseWordsInString.reverseWords("Hurray! Easy Questions"));

        // Case 4
        System.out.println(ReverseWordsInString.reverseWords("Bangkok12:)Has"));

        // Case 5
        System.out.println(ReverseWordsInString.reverseWords("Bangkok"));
    }

    static String reverseWords(String input) {
        if (input == null || input.length() < 2) return input;
        int len = input.length();
        char[] inputChars = input.toCharArray();
        int left = 0, right = 0;

        while (left < len) {
            right = left;
            while (right < len && Character.isLetterOrDigit(inputChars[right])) {
                right++;
            }
            int lastValidIndex = right - 1;
            while (left < lastValidIndex) {
                char temp = inputChars[left];
                inputChars[left] = inputChars[lastValidIndex];
                inputChars[lastValidIndex] = temp;
                left++;
                lastValidIndex--;
            }
            left = right;
            while (left < len && !Character.isLetterOrDigit(inputChars[left])) {
                left++;
            }
        }
        return new String(inputChars);
    }
}
