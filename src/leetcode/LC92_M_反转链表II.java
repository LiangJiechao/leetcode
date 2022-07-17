package leetcode;

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * <p>
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 *
 * @author xiaoliang
 * @date 2021/11/09 09:32
 **/
public class LC92_M_反转链表II {
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

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        // 定义一个dummyHead, 方便处理
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // 初始化指针
        ListNode g = dummyHead;
        ListNode p = dummyHead.next;

        // 将指针移到相应的位置
        for(int step = 0; step < m - 1; step++) {
            g = g.next; p = p.next;
        }

        // 头插法插入节点
        for (int i = 0; i < n - m; i++) {
            ListNode removed = p.next;
            p.next = p.next.next;

            removed.next = g.next;
            g.next = removed;
        }

        return dummyHead.next;
    }


    public static ListNode reverseBetween1(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }

        ListNode pre = head;
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = null;
        ListNode last = null;
        for (int i = left; i <= right; i++) {
            // 采用头插法
            cur = pre;
            pre = pre.next;
            cur.next = dummy.next;
            dummy.next = cur;
            if(i==left){
                last = cur;
            }
            if(i==right){
                last.next = pre;
            }
        }
        if (left!=1){
            pre = head;
            for (int i = 1; i < left-1; i++) {
                pre = pre.next;
            }
            pre.next = dummy.next;
        }else if (left==1){
            head = dummy.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next  = new ListNode(4);
//        head.next.next.next.next  = new ListNode(5);
        reverseBetween(head,1,2);
    }
}
