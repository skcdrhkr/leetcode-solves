import utils.ListNode;

public class RemoveNodesFromLinkedList {

    public static void main(String[] args) {
        // Case 1
        System.out.println(RemoveNodesFromLinkedList.removeNodes(ListNode.createList(new int[]{5, 2, 13, 3, 8})));

        // Case 2
        System.out.println(RemoveNodesFromLinkedList.removeNodes(ListNode.createList(new int[]{1, 1, 1, 1})));

        // Case 3
        System.out.println(RemoveNodesFromLinkedList.removeNodes(ListNode.createList(new int[]{3, 5, 1, 2, 7, 3, 5, 8, 4})));
    }

    public static ListNode removeNodes(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode rev = reverse(head);

        int prevValue = rev.val;
        ListNode cur = rev.next, prev = rev;
        while (cur != null) {
            if (cur.val < prevValue) {
                prev.next = cur.next;
            } else {
                prev = cur;
                prevValue = prev.val;
            }
            cur = cur.next;
        }
        return reverse(rev);
    }

    private static ListNode reverse(ListNode head) {
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
