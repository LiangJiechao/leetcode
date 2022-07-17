package b;

/**
 * @author xiaoliang
 * @version 1.0
 * @description: 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，
 * 并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * @date 2021/6/19 17:32
 */
public class AddTwoListNumbers {

    public static ListNode addTwoListNumbers(ListNode l1, ListNode l2) {
        //设置头节点
        ListNode dummyHead = new ListNode(0);
        ListNode p1 = l1;
        ListNode p2 = l2;
        //curr 来进行加入 node
        ListNode curr = dummyHead;
        //表示进位
        int carry = 0;
        int x, y, sum;
        while (p1 != null || p2 != null) {
            x = p1 == null ? 0 : p1.val;
            y = p2 == null ? 0 : p2.val;
            sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
