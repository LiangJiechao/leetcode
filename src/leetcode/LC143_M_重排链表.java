package leetcode;

/**
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 *  L0 → L1 → … → Ln-1 → Ln 
 * 请将其重新排列后变为：
 * L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 输入: head = [1,2,3,4]
 * 输出: [1,4,2,3]
 * <p>
 * 链表的长度范围为 [1, 5 * 10^4]
 *
 * @author xiaoliang
 * @date 2021/11/06 15:17
 **/
public class LC143_M_重排链表 {
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
     * 思路2：
     * 1、快慢指针找到中间节点
     * 2、反转后半段链表
     * 3、合并前半段链表和后半段链表
     */
    public static void reorderList(ListNode head) {
        // 有三个节点以上才交换
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode mid = null;
        // 慢指针找到中间节点
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast.next != null) {
            slow = slow.next;
        }
        mid = slow.next;
        slow.next = null;
        mid = reverse(mid);

        fast = head;
        slow = mid;
        // 指针插空
        merge(fast, slow);
    }

    private static void merge(ListNode fast, ListNode slow) {
        ListNode temp = null;
        while (fast != null && slow != null) {
            temp = slow.next;
            slow.next = fast.next;
            fast.next = slow;
            fast = fast.next.next;
            slow = temp;
        }
    }

    private static ListNode reverse(ListNode head) {
        // 找到最后一个节点了
        if (head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    /**
     * 思路1：递归逆转
     *
     * @param head
     */
    public static void reorderList1(ListNode head) {
        // 有三个节点以上才交换
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode dummy = head;
        process(dummy);
        while (dummy.next != null && dummy.next.next != null) {
            dummy = dummy.next.next;
            process(dummy);
        }
    }

    private static void process(ListNode head) {

        // 有三个节点以上才交换
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        // 找到最后一个节点的前一个节点
        ListNode preLast = head;

        while (preLast.next.next != null) {
            preLast = preLast.next;
        }
        ListNode last = preLast.next;
        preLast.next = null;
        last.next = head.next;
        head.next = last;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        reorderList(head);
    }
}
