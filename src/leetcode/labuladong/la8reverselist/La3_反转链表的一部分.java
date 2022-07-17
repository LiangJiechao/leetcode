package leetcode.labuladong.la8reverselist;

/**
 * 思想好
 *
 * @author xiaoliang
 * @date 2022/02/25 11:18
 **/
public class La3_反转链表的一部分 {

    // 单链表节点的结构
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static ListNode reverseBetween(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            // 相当于反转前 n 个元素
            return reverseN(head, n);
        }

        /*如果 m != 1 怎么办？如果我们把 head 的索引视为 1，那么我们是想从第 m 个元素开始反转对吧；
        如果把 head.next 的索引视为 1 呢？那么相对于 head.next，反转的区间应该是从第 m - 1 个元素开始的*/
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    static ListNode reverseBetween2(ListNode head, int m, int n) {

        ListNode p = head;
        ListNode q = head;
        // 前进到反转的起点触发 base case
        for (int i = 1; i < m-1; i++) {
            q = q.next;
        }
        for (int i = 1; i < m; i++) {
            p = p.next;
        }

        q.next =  reverseN(p, n - m);
        return head;
    }

    static ListNode successor = null;

    // 将链表的前 n 个节点反转
    static ListNode reverseN(ListNode head, int n) {
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

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        reverseBetween2(head, 2, 4);
    }
}
