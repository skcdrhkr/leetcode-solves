public class ReverseWordsString {

    public static void main(String[] args) {
        // Case 1
        System.out.println(ReverseWordsString.reverseWords("We love Java "));

        // Case 2
        System.out.println(ReverseWordsString.reverseWords("To be or not to be"));

        // Case 3
        System.out.println(ReverseWordsString.reverseWords("You are amazing"));

        // Case 4
        System.out.println(ReverseWordsString.reverseWords("Hello     World"));

        // Case 5
        System.out.println(ReverseWordsString.reverseWords(" Hey"));
    }

    public static String reverseWords(String sentence) {

        // Replace this placeholder return statement with your code
        char[] result = sentence.trim().toCharArray();
        int length = result.length;
        reverse(result, 0, length - 1);
        int first = 0, second = 0;
        StringBuilder builder = new StringBuilder();
        while (second < length) {
            while (second < length && result[second] == ' ') second += 1;
            first = second;
            while (second < length && result[second] != ' ') second += 1;
            reverse(result, first, second - 1);
            builder.append(result, first, second - first);
            if (second < length) builder.append(' ');
        }
        return builder.toString();
    }

    public static void reverse(char[] arr, int lo, int hi) {
        char temp;
        while (lo < hi) {
            temp = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = temp;
            lo++;
            hi--;
        }
    }
}
