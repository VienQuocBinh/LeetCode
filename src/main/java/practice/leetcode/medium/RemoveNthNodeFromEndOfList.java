package practice.leetcode.medium;

import practice.leetcode.ListNode;

import static practice.leetcode.ListNode.init;

/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.

Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:
Input: head = [1], n = 1
Output: []

Example 3:
Input: head = [1,2], n = 1
Output: [1]
 */
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        int n = 2;
        ListNode head = init(nums);
        ListNode result = removeNthFromEnd(head, n);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
    }

    /*
    Thay vì duyệt từ đầu đến cuối và trở lại n lần để xóa nth node thì phương pháp sau chỉ cần 1 lần duyệt.
    Idea: Lật ngược mảng bằng cách duyệt chậm n node để xóa node ở nth
    1. Tạo 2 node (early, late) đều trỏ vào vùng nhớ head (mảng được cho), hành động này xem như tạo 2 mảng tạm.
    2. Duyệt qua n node của mảng 1 (early đang đứng tại nth mảng 1)
    3. Duyệt hết mảng early và late (late duyệt từ đầu).
    4. Khi duyệt hết early cũng là lúc đến node cần xóa tính từ cuối n node
    5. Xóa node đó bằng cách trỏ late sang node tiếp theo.
     */
    static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode early = head, late = head;
        for (int i = 0; i < n; i++) {
            early = early.next;
        }
        if (early == null) {
            assert head != null;
            return head.next;
        }
        while (early.next != null) {
            early = early.next;
            late = late.next;
        }
        late.next = late.next.next; // remove nth node
        return head;
    }
}