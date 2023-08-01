package leetcode.labuladong.la8reverselist;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 进阶：
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * @author xiaoliang
 * @date 2022/03/14 16:33
 **/
public class La4_LC25_H_K个一组翻转链表 {

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

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode a = head, b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) {
                // 这里是不足k个不反转
                return head;
            }
            // if (b==null){
            //     // 这里可以不足k个也反转
            //     return reverseBetween(a,null);
            // }
            b = b.next;
        }
        // 第一次调用返回的就是链表头了
        ListNode newHead = reverseBetween(a, b);
        // a就是链表尾，所以a.next就连上下一个新头
        a.next = reverseKGroup(b, k);
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
