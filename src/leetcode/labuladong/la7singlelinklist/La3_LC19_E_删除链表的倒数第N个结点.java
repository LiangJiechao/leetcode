package leetcode.labuladong.la7singlelinklist;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 进阶：你能尝试使用一趟扫描实现吗？
 * <p>
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * <p>
 * 输入：head = [1], n = 1
 * 输出：[]
 * <p>
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *
 * @author xiaoliang
 * @date 2021/10/22 16:53
 **/
public class La3_LC19_E_删除链表的倒数第N个结点 {

    static class ListNode {
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
     * 添加dummy头节点，可以处理边界情况
     * 思路：找到要删除节点的上一个节点，然后进行删除
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 0) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode p = dummy;

        ListNode fromEnd = findFromEnd(p, n + 1);

        fromEnd.next = fromEnd.next.next;
//        fromEnd.next.next = null;  1->null  删除1时
        return dummy.next;
    }

    // 返回链表的倒数第 k 个节点的前一个
    private static ListNode findFromEnd(ListNode head, int n) {

        ListNode slow = head, fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

}
