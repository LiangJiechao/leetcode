package leetcode;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * @author xiaoliang
 * @date 2021/11/23 17:41
 **/
public class 剑指Offer06_E_从尾到头打印链表 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        int size = 0;
        ListNode temp = head;
        while (temp!=null){
            size++;
            temp = temp.next;
        }

        int[] result = new int[size];
        temp = head;
        for (int i = size-1; i >=0 ; i--) {
            result[i] = temp.val;
            temp = temp.next;
        }
        return result;
    }
}
