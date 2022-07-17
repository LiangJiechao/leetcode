package leetcode.labuladong.la7singlelinklist;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * @author xiaoliang
 * @date 2021/10/28 20:40
 **/
public class La1_LC21_E_合并两个有序链表 {

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
     * 类似于归并排序
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode dummy = new ListNode(-1);
        ListNode dummyHead = dummy;
        ListNode p1 = l1, p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                dummy.next = p1;
                p1 = p1.next;
            } else {
                dummy.next = p2;
                p2 = p2.next;
            }
            dummy = dummy.next;
        }
        if (p1 != null) {
            dummy.next = p1;
        }
        if (p2 != null) {
            dummy.next = p2;
        }

        return dummyHead.next;
    }

}
