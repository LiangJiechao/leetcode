package leetcode.labuladong.la8reverselist;

/**
 * @author xiaoliang
 * @date 2022/02/25 10:51
 **/
public class La1_LC206_递归反转列表 {

    // 单链表节点的结构
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            // 最后一个节点
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    ListNode reverse2(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        ListNode h = head, q = head.next;

        while (h != null) {
            h.next = p.next;
            p.next = h;
            h = q;
            if (q != null) {
                q = q.next;
            }
        }
        return dummy.next;
    }

}
