package leetcode;

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
public class LC21_E_合并两个有序链表 {

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
     * 递归法
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        // base case
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        if (l1.val<l2.val){
            l1.next  = mergeTwoLists2(l1.next,l2);
            return l1;
        }else {
            l2.next  = mergeTwoLists2(l1,l2.next);
            return l2;
        }
    }

    /**
     * 类似于归并排序
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        // 类似归并排序中的合并过程
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }

        }
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }

        return dummyHead.next;
    }

}
