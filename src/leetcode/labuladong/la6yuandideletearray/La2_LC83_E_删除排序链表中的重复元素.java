package leetcode.labuladong.la6yuandideletearray;

/**
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 * @author xiaoliang
 * @date 2022/02/24 22:32
 **/
public class La2_LC83_E_删除排序链表中的重复元素 {
    public class ListNode {
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

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        // 1->1->2->3->3->null
        ListNode slow = head, fast = head;
        while (fast != null) {
            if (slow.val != fast.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        // 断开与后⾯重复元素的连接
        slow.next = null;
        return head;
    }

}
