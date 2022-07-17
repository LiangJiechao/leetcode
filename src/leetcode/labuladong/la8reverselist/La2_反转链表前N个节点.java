package leetcode.labuladong.la8reverselist;

/**
 * 将链表的前 n 个节点反转（n <= 链表⻓度）
 *
 * @author xiaoliang
 * @date 2022/02/25 11:11
 **/
public class La2_反转链表前N个节点 {
    // 单链表节点的结构
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    ListNode successor = null;

    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        // 让反转之后的 head 节点和后⾯的节点连起来
        head.next = successor;
        return last;

    }

    ListNode reverseN2(ListNode head, int n) {
        ListNode a = head, b = head;

        for (int i = 0; i < n; i++) {
            b = b.next;
        }

        ListNode newHead = reverseBetween(a, b);
        a.next = b;
        return newHead;
    }

    private ListNode reverseBetween(ListNode a, ListNode b) {
        if (a.next == b) {
            return a;
        }

        ListNode last = reverseBetween(a.next, b);

        a.next.next = a;
        a.next = null;
        return last;
    }

}
