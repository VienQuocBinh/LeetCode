package practice.leetcode.hard;

import practice.leetcode.ListNode;

public class MergeKSortedLists {
    public static void main(String[] args) {
        int[] n1 = new int[]{1, 4, 5};
        int[] n2 = new int[]{1, 3, 4};
        int[] n3 = new int[]{2, 6};
        ListNode ln1 = ListNode.init(n1);
        ListNode ln2 = ListNode.init(n2);
        ListNode ln3 = ListNode.init(n3);
        ListNode[] lists = new ListNode[]{ln1, ln2, ln3};
        ListNode result = mergeKLists(lists);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return mergeKListsHelper(lists, 0, lists.length - 1);
    }

    /*
    Using divide and conquer to divide a list to "Merge 2 lists" problem
     */
    static ListNode mergeKListsHelper(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start]; // while the list contains only 1 element
        if (start + 1 == end) return merge(lists[start], lists[end]);

        int mid = (start + end) / 2;
        ListNode left = mergeKListsHelper(lists, start, mid);
        ListNode right = mergeKListsHelper(lists, mid + 1, end);

        return merge(left, right);
    }

    /**
     * Merges 2 unsorted lists.
     *
     * @param l1 {@link ListNode}
     * @param l2 {@link ListNode}
     * @return {@link ListNode}
     */
    static ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode current = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        current.next = (l1 != null) ? l1 : l2;
        return head.next;
    }
}
