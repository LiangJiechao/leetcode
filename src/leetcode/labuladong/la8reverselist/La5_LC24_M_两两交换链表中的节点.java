package leetcode.labuladong.la8reverselist;

/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * <p>
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 *
 * @author liangjiechao
 * @date 2022/10/08 17:15
 **/
public class La5_LC24_M_两两交换链表中的节点 {


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

    public La5_LC24_M_两两交换链表中的节点() {
    }

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode theNext = head.next.next;
        ListNode newHead = head.next;
        newHead.next = head;
        head.next = swapPairs(theNext);

        return newHead;
    }

}
