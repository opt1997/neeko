
// 203. 移除链表元素 https://leetcode.cn/problems/remove-linked-list-elements/

import common.ListNode;

public class LeetCode203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        if (head.val == val) {
            head = removeElements(head.next, val);
        } else {
            head.next = removeElements(head.next, val);
        }
        return head;
    }

}
