package leetcode.labuladong.la7singlelinklist;

/**
 * 如果链表⻓度为偶数，也就是说中点有两个的时候，这个解法返回的节点是靠后的那个节点
 *
 * @author xiaoliang
 * @date 2022/02/25 10:30
 **/
public class La4_单链表的中点 {

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

    // 如果链表⻓度为偶数，也就是说中点有两个的时候，这个解法返回的节点是靠后的那个节点
    ListNode middleNode(ListNode head) {

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
