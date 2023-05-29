package practice.leetcode.medium;

import practice.leetcode.ListNode;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        int[] n1 = new int[]{1, 2, 3, 4};
        ListNode head = ListNode.init(n1);
        ListNode result = swapPairs(head);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    static ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode();
        dummy.next = head; // use dummy to handle head swap
        ListNode current = dummy;

        while (current.next != null && current.next.next != null) {

            ListNode first = current.next;
            ListNode second = current.next.next;
            // Swap 2 adjacent nodes
            current.next = second;
            first.next = second.next;
            second.next = first;

            current = current.next.next;
        }

        return dummy;
    }
}
