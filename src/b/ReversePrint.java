package b;

import java.util.Stack;

/**
 * @author xiaoliang
 * @version 1.0
 * @description: 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * @date 2021/6/26 17:21
 */
public class ReversePrint {

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] result = new int[stack.size()];
        int i = 0;
        while (!stack.empty()) {
            result[i++] = stack.pop();
        }
        return result;
    }

    public int[] reversePrint2(ListNode head) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        int[] result = new int[size];
        temp = head;
        for (int i = size - 1; i >= 0; i--) {
            result[i] = temp.val;
            temp = temp.next;
        }

        return result;
    }

}
