package leetcode;

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
public class LC19_E_删除链表的倒数第N个结点 {

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
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd3(ListNode head, int n){
        if (head == null || n < 0) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre  = findFromEnd(dummy,n+1);

        pre.next = pre.next.next;
        return dummy.next;
    }

    // 返回链表的倒数第 k 个节点
    private static ListNode findFromEnd(ListNode dummy, int n) {

        ListNode fast=dummy;
        ListNode slow=dummy;

        // 快指针先走 n 步
        while (n>0){
            fast= fast.next;
            n--;
        }
        // 快慢指针一起走
        while (fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null || n < 0) {
            throw new RuntimeException("参数错误");
        }
        ListNode fast = head;
        ListNode slow = head;

        while (n != 0) {
            fast = fast.next;
            n--;
        }
        // fast走到了null，证明删除的是第一个节点
        if (fast == null){
            return head.next;
        }

        // fast再走一步，保证slow走到的是要删除的前一个节点
        fast = fast.next;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 0) {
            throw new RuntimeException("参数错误");
        }
        ListNode fast = head;
        ListNode slow = head;
        // 节点总数
        int total = 0;
        int temp = n;
        while (n != 0) {
            total++;
            fast = fast.next;
            n--;
        }

        ListNode pre =slow;
        while (fast != null) {
            total++;
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }
        // 删除的是第一个节点
        if(total == temp ){
            return head.next;
        }
        // 删除的是中间或最后一个节点
        pre.next = null;
        if (slow.next!=null){
            pre.next = slow.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;

        removeNthFromEnd(node1,1);
    }

}
