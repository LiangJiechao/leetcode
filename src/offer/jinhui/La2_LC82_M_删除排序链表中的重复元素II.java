package offer.jinhui;

/**
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * <p>
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 *
 * @author xiaoliang
 * @date 2022/04/24 16:57
 **/
public class La2_LC82_M_删除排序链表中的重复元素II {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-200);
        dummy.next = head;
        ListNode cur = dummy;

        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int val = cur.next.val;
                while (cur.next != null && cur.next.val == val) {
                    cur.next = cur.next.next;
                }

            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}