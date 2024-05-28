import java.util.ArrayList;

public class CircularGame {

    public static void main(String[] args) {
        // Case 1
        System.out.println(CircularGame.findTheWinner(5, 2));

        // Case 2
        System.out.println(CircularGame.findTheWinner(6, 5));
    }

    public static int findTheWinner(int n, int k) {
        ArrayList<Integer> lst = new ArrayList<>();
        for (Integer i = 1; i <= n; i++) {
            lst.add(i);
        }
        int c = 0;
        while (lst.size() > 1) {
            c = (c + k - 1) % n;
            lst.remove(c);
            n--;
        }
        return lst.get(0);
    }
}
