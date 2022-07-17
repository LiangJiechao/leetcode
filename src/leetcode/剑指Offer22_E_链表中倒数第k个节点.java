package leetcode;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 *
 * @author xiaoliang
 * @date 2021/11/05 10:59
 **/
public class 剑指Offer22_E_链表中倒数第k个节点 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < k; i++) {
            if (fast!=null){
                fast = fast.next;
            }else {
                return null;
            }
        }

        while (fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;

    }
}
