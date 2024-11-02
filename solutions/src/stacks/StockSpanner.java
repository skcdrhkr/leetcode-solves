package stacks;

import java.util.Stack;

public class StockSpanner {

    public static void main(String[] args) {
        // Case 1
        StockSpanner spanner = new StockSpanner();
        System.out.println(spanner.next(100));
        System.out.println(spanner.next(80));
        System.out.println(spanner.next(60));
        System.out.println(spanner.next(70));
        System.out.println(spanner.next(60));
        System.out.println(spanner.next(75));
        System.out.println(spanner.next(80));
    }

    Stack<int[]> st;
    int index;

    public StockSpanner() {
        st = new Stack<>();
        index = 0;
    }

    public int next(int price) {
        index += 1;
        while (!st.isEmpty() && (st.peek()[0]) <= price) {
            st.pop();
        }
        if (st.isEmpty()) {
            st.push(new int[]{price, index});
            return index;
        } else {
            int prev = st.peek()[1];
            st.push(new int[]{price, index});
            return index - prev;
        }
    }
}
