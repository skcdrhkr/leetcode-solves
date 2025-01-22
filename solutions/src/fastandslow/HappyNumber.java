package fastandslow;

public class HappyNumber {

    public static void main(String[] args) {
        // Case 1
        System.out.println(HappyNumber.isHappyNumber(2147483646));

        // Case 2
        System.out.println(HappyNumber.isHappyNumber(8));

        // Case 3
        System.out.println(HappyNumber.isHappyNumber(19));
    }

    public static boolean isHappyNumber(int n) {

        // Replace this placeholder return statement with your code
        int slow = n, fast = n;
        do {
            if (slow == 1 || fast == 1) return true;
            slow = sumOfDigits(slow);
            fast = sumOfDigits(sumOfDigits(fast));
        } while (slow != fast);
        return false;
    }

    private static int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += (digit * digit);
            n /= 10;
        }
        return sum;
    }
}
