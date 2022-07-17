package leetcode.labuladong.la7singlelinklist;

/**
 * @author xiaoliang
 * @date 2022/02/25 10:33
 **/
public class La5_判断链表是否包含环 {

    public class ListNode {
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

    // 如果链表中含有环，如何计算这个环的起点
    ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;
            // 快慢指针相遇，说明含有环
            if (slow == fast) {
                break;
            }
        }
        // 没环
        if (fast == null || fast.next == null) {
            return null;
        }
        // 说明有环
        // 重新指向头结点
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;
            // 快慢指针相遇，说明含有环
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

}
