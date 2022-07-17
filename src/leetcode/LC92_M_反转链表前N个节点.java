package leetcode;

/**
 * @author xiaoliang
 * @date 2022/01/14 17:43
 **/
public class LC92_M_反转链表前N个节点 {

    public static class ListNode {
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

    // 后驱节点
    ListNode successor = null;

    // 反转以 head 为起点的 n 个节点，返回新的头结点
    public ListNode reverseN(ListNode head, int n) {

        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
    }



    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (m==1){
            return reverseN(head, n);
        }
        head.next = reverseBetween(head.next,m-1,n-1);
        return head;
    }
}