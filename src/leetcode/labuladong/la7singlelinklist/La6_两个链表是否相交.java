package leetcode.labuladong.la7singlelinklist;

/**
 * 输⼊两个链表的头结点 headA 和 headB，这两个链表可能存在相交。
 * 如果相交，你的算法应该返回相交的那个节点；如果没相交，则返回 null。
 *
 * @author xiaoliang
 * @date 2022/02/25 10:39
 **/
public class La6_两个链表是否相交 {

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

    /**
     * 思路：
     * 让p1走完链1时，接着走链2
     * 让p2走完链2时，接着走链1
     *
     * @param headA
     * @param headB
     * @return
     */
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != p2) {
            // p1 走一步，如果走到A链表的末尾，转到B链表
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }

            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }
}
