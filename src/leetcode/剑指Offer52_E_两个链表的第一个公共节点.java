package leetcode;

/**
 * 输入两个链表，找出它们的第一个公共节点。
 * <p>
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 *
 * @author xiaoliang
 * @date 2021/12/02 17:17
 **/
public class 剑指Offer52_E_两个链表的第一个公共节点 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {

        if (head1 == null | head2 == null) {
            return null;
        }

        int len1 = 0;
        int len2 = 0;
        ListNode first = head1;
        while (first.next != null) {
            len1++;
            first = first.next;
        }
        ListNode second = head2;
        while (second.next != null) {
            len2++;
            second = second.next;
        }

        if (first == second) {
            // 相交
            // 算出差值，已经长短链表
            int sub = Math.abs(len1 - len2);
            ListNode pLong = len1 > len2 ? head1 : head2;
            ListNode pShort = pLong == head1 ? head2 : head1;
            // 长链表先走差值
            while (sub != 0) {
                pLong = pLong.next;
                sub--;
            }
            while (pLong != pShort) {
                pLong = pLong.next;
                pShort = pShort.next;
            }
            return pLong;
        } else {
            // 不相交
            return null;
        }
    }
}
