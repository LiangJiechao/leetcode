package b;

/**
 * @author xiaoliang
 * @version 1.0
 * @description: 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则
 * @date 2021/6/24 20:43
 */
public class MergeTwoList {

    public static ListNode merge(ListNode list1, ListNode list2) {
        //list1为空，直接返回list2
        if (list1 == null) {
            return list2;
        }
        //list2为空，直接返回list1
        if (list2 == null) {
            return list1;
        }

        ListNode result = null;
        ListNode current = null;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                if (result == null) {
                    result = current = list1;
                } else {
                    current.next = list1;
                    current = list1;
                }

                list1 = list1.next;

            } else {
                if (result == null) {
                    result = current = list2;
                } else {
                    current.next = list2;
                    current = list2;
                }
                list2 = list2.next;
            }

        }

        if (list1 == null) {
            current.next = list2;
        } else {
            current.next = list1;
        }

        return result;
    }

    /**
     * @description:  递归版本
     * @param: * @param: list1
     * @param: list2
     * @return: b.ListNode
     *
     * @author xiaoliang
     * @date: 2021/6/24 21:05
     */
    public static ListNode merge2(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val<=list2.val){
            list1.next = merge2(list1.next,list2);
            return list1;
        }else {
            list2.next = merge2(list1,list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {

    }
}
