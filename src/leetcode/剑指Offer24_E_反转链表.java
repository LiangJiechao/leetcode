package leetcode;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * @author xiaoliang
 * @date 2021/11/23 17:44
 **/
public class 剑指Offer24_E_反转链表 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 递归写法
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        return process(head);
    }

    private ListNode process(ListNode head) {

        // base case 最后一个节点
        if (head.next == null){
            return head;
        }
        ListNode last = process(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
