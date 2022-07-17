package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 * 返回同样按升序排列的结果链表。
 * <p>
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 *
 * @author xiaoliang
 * @date 2021/11/11 11:44
 **/
public class LC82_M_删除排序链表中的重复元素II {
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

    /**
     * 思路2：创建dummy节点，连接上 原链，
     * 然后pre,cur指针 如果cur与pre相等，则一直往前走
     * dummy只连接那些没重复的节点
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                cur = cur.next;
            } else {
                pre.next = cur;
                cur = cur.next;
                pre = pre.next;
                if (cur.next != null) {
                    // 不是最后一个节点
                    pre.next = null;
                }
            }
        }

        return dummy.next;
    }

    /**
     * 思路：一次遍历：先记录要删除的元素；
     * 第二次遍历：删除元素
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode l1 = head;
        Set<Integer> set = new HashSet<>();
        Set<Integer> same = new HashSet<>();
        // 一次遍历：先记录要删除的元素；
        while (l1 != null) {
            if (!set.add(l1.val)) {
                same.add(l1.val);
            }
            l1 = l1.next;
        }

        l1 = head;
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        while (l1 != null) {
            if (!same.contains(l1.val)) {
                p.next = l1;
                p = p.next;
                l1 = l1.next;
                p.next = null;
            } else {
                l1 = l1.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        deleteDuplicates(head);

    }

}
