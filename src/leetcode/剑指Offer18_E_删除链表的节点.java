package leetcode;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * 只删除第一个相同的节点
 *
 * @author xiaoliang
 * @date 2021/12/02 17:26
 **/
public class 剑指Offer18_E_删除链表的节点 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {

        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        head.next = deleteNode(head.next, val);
        return head;
    }
}
