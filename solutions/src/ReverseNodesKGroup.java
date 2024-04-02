import utils.ListNode;

public class ReverseNodesKGroup {

    public static void main(String[] args) {
        // Case 1
        System.out.println(ReverseNodesKGroup.reverseKGroup(ListNode.createList(new int[]{1, 2, 3, 4, 5}), 2));

        // Case 2
        System.out.println(ReverseNodesKGroup.reverseKGroup(ListNode.createList(new int[]{1, 2, 3, 4, 5}), 3));

        // Case 3
        System.out.println(ReverseNodesKGroup.reverseKGroup(ListNode.createList(new int[]{1, 2, 3, 4, 5}), 1));

        // Case 4
        System.out.println(ReverseNodesKGroup.reverseKGroup(ListNode.createList(new int[]{1, 2, 3, 4, 5}), 4));

        // Case 5
        System.out.println(ReverseNodesKGroup.reverseKGroup(ListNode.createList(new int[]{1, 2, 3, 4, 5}), 5));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur, reversed, nxtList, prevList = null, travers = head;
        ListNode nHead = head;
        while (travers != null) {
            cur = travers;
            int index = 1;
            while (index < k) {
                cur = cur.next;
                if (cur == null) break;
                index++;
            }
            if (index != k) break;
            nxtList = cur.next;
            cur.next = null;
            reversed = reverseGroup(travers);
            if (prevList != null) {
                prevList.next = reversed;
            } else {
                nHead = reversed;
            }
            prevList = travers;
            travers = nxtList;
        }
        prevList.next = travers;
        return nHead;
    }

    private static ListNode reverseGroup(ListNode head) {
        ListNode prev = null, nxt;
        while (head != null) {
            nxt = head.next;
            head.next = prev;
            prev = head;
            head = nxt;
        }
        return prev;
    }
}
