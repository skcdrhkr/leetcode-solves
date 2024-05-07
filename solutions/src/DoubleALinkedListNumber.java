import utils.ListNode;

public class DoubleALinkedListNumber {

    public static void main(String[] args) {
        // Case 1
        System.out.println(DoubleALinkedListNumber.doubleIt(ListNode.createList(new int[]{1, 8, 9})));

        // Case 2
        System.out.println(DoubleALinkedListNumber.doubleIt(ListNode.createList(new int[]{9, 9, 9})));
    }

    public static ListNode doubleIt(ListNode head) {
        ListNode prev = null, cur = head;
        while (cur != null) {
            int value = cur.val * 2;
            cur.val = value % 10;
            if (value >= 10) {
                if (prev == null) {
                    ListNode nHead = new ListNode(1);
                    nHead.next = head;
                    head = nHead;
                } else {
                    prev.val = prev.val + 1;
                }
            }
            prev = cur;
            cur = cur.next;
        }
        return head;
    }
}
