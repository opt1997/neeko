import common.ListNode;

// 206. 反转链表 https://leetcode.cn/problems/reverse-linked-list/
public class LeetCode206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next==null) {
            return head;
        }
        ListNode end = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return end;
    }
}
