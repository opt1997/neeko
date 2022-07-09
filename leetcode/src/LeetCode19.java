
// 19. 删除链表的倒数第N个结点 https://leetcode.cn/problems/remove-nth-node-from-end-of-list/

public class LeetCode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode h = new ListNode(0, head);
        head = h;
        ListNode fast = head;
        ListNode low = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            low = low.next;
        }
        low.next = low.next.next;
        return head;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
