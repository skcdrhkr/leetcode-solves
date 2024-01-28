import utils.ListNode;

/**
 * Problem URL: https://leetcode.com/problems/intersection-of-two-linked-lists/description/
 * Level: Easy
 */

public class LinkedListIntersection {

    public static void main(String[] args) {
        // Case 1
        //System.out.println(LinkedListIntersection.getIntersectionNode());
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int asize = 0, bsize = 0;
        ListNode cur = headA, ano = headB;
        if (headA == headB)
            return headA;
        while (cur != null) {
            cur = cur.next;
            asize += 1;
        }
        cur = headB;
        while (cur != null) {
            cur = cur.next;
            bsize += 1;
        }
        if (asize > bsize) {
            cur = headA;
            ano = headB;
            while (bsize < asize) {
                cur = cur.next;
                if (cur == null)
                    return null;
                bsize += 1;
            }
        } else if (bsize > asize) {
            cur = headB;
            ano = headA;
            while (asize < bsize) {
                cur = cur.next;
                if (cur == null)
                    return null;
                asize += 1;
            }
        } else {
            cur = headA;
            ano = headB;
        }

        while (ano != null) {
            if (ano == cur)
                return ano;
            ano = ano.next;
            cur = cur.next;
        }
        return null;
    }
}
