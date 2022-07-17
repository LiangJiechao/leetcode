package b;

/**
 * @author xiaoliang
 * @version 1.0
 * @description: 输入一个链表，输出该链表中倒数第k个结点
 * @date 2021/6/24 20:15
 */
public class FindKthToTail {
    public static ListNode findKthToTail(ListNode head, int k) {
        ListNode p = head;
        ListNode q = head;
        for (int i = 0; i < k; i++) {
            if (q != null) {
                q = q.next;
            }
        }
        while (q != null) {
            p = p.next;
            q = q.next;
        }

        return p;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode kth = FindKthToTail.findKthToTail(head, 1);
    }
}
