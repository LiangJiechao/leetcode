package leetcode;

import java.util.Stack;

/**
 题目中，「两数之和」通常与其他形式表示的数字结合起来：
     两个字符串形式的数字相加（第 415 题）
     两个链表形式的数字相加（第 2 、445、369 题）
     数组形式的数字相加（第 66 、989题）
     两个二进制形式的数字相加（第 67 题）

 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 输入：l1 = [7,2,4,3], l2 = [5,6,4]
 * 输出：[7,8,0,7]
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[8,0,7]
 *
 * @author xiaoliang
 * @date 2021/11/02 11:14
 **/
public class LC445_M_两数相加II {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        ListNode dummy = new ListNode(0);
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || carry > 0) {

            int temp = carry;
            temp += s1.isEmpty() ? 0 : s1.pop();
            temp += s2.isEmpty() ? 0 : s2.pop();

            // 上链
            ListNode node = new ListNode(temp % 10);
            carry = temp / 10;
            node.next = dummy.next;
            dummy.next = node;
        }
        return dummy.next;

    }

}
