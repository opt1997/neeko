
// 876. 链表的中间结点 https://leetcode.cn/problems/middle-of-the-linked-list/

public class LeetCode876 {
    public ListNode middleNode(ListNode head) {
        ListNode low = head, fast = head;
        while (fast != null && fast.next != null) {
            low = low.next;
            fast = fast.next.next;
        }
        return low;
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





