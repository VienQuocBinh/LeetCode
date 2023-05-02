package practice.leetcode.medium;

public class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode init(int[] numbers) {
        ListNode head = new ListNode();
        ListNode node = head;
        for (int i = 0; i < numbers.length; i++) {
            node.val = numbers[i];
            if (i != numbers.length - 1) {
                node.next = new ListNode();
                node = node.next;
            }
        }
        return head;
    }
}
