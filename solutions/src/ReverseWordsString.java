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

        char[] characters = sentence.toCharArray();
        int n = characters.length;
        int first = 0, second = n - 1;
        reverseString(characters, first, second);
        StringBuilder builder = new StringBuilder();
        while (first < n) {
            while (first < n && characters[first] == ' ') first += 1;
            if (first == n) break;
            second = first;
            while (second < n && characters[second] != ' ') second += 1;
            reverseString(characters, first, second - 1);
            String str = new String(characters, first, second - first);
            if (builder.isEmpty())
                builder.append(str);
            else
                builder.append(" ").append(str);
            first = second;
        }
        return builder.toString();
    }

    private static void reverseString(char[] cs, int first, int second) {
        char temp;
        while (first < second) {
            temp = cs[first];
            cs[first] = cs[second];
            cs[second] = temp;
            first += 1;
            second -= 1;
        }
    }
}
