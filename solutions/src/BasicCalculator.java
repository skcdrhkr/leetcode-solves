import java.util.Stack;

public class BasicCalculator {

    public static void main(String[] args) {

        // Case 0
        System.out.println(BasicCalculator.calculator("1 + 1"));

        // Case 1
        System.out.println(BasicCalculator.calculator("(8 + 100) + (13 - 8 - (2 + 1))"));

        // Case 2
        System.out.println(BasicCalculator.calculator("12 - (6 + 2) + 5"));

        // Case 3
        System.out.println(BasicCalculator.calculator("(1+(4+5+2)-3)+(6+8)"));
    }

    public static int calculator(String expression) {
        int res = 0;
        int len = expression.length();
        Stack<String> stack = new Stack<>();



        return res;
    }
}
