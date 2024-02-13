import java.util.Arrays;

public class FirstPalindrome {

    public static void main(String[] args) {
        // Case 1
        System.out.println(FirstPalindrome.firstPalindrome(new String[]{"abc", "car", "ada", "racecar", "cool"}));

        // Case 2
        System.out.println(FirstPalindrome.firstPalindrome(new String[]{"notapalindrome", "racecar"}));

        // Case 3
        System.out.println(FirstPalindrome.firstPalindrome(new String[]{"def", "ghi"}));
    }

    public static String firstPalindrome(String[] words) {
        return Arrays.stream(words).filter(x -> x.contentEquals(
                new StringBuilder(x).reverse()
        )).findFirst().orElse("");
    }
}
