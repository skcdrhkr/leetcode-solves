import utils.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Problem URL: https://leetcode.com/problems/merge-k-sorted-lists/description/?
 * Level: Hard
 */

public class MergeKSortedLists {

    public static void main(String[] args) {
        // Case 1
        ListNode[] lists = new ListNode[]{ListNode.createList(new int[]{1, 4, 5}), ListNode.createList(new int[]{1, 3, 4}), ListNode.createList(new int[]{2, 6})};
        System.out.println(MergeKSortedLists.mergeKLists(lists));

        System.out.println(MergeKSortedLists.mergeKLists(new ListNode[]{}));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) return null;
        if (n == 1) return lists[0];
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }
        ListNode nHead = new ListNode(0);
        ListNode cur = nHead, top;
        while (!pq.isEmpty()) {
            top = pq.poll();
            cur.next = top;
            if (top.next != null) pq.add(top.next);
            cur = top;
        }
        return nHead.next;
    }
}
