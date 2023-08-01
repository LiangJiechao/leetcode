package b;

/**
 * @description:
 * 逆转列表
 * @author xiaoliang
 * @date 2021/6/25 9:41
 * @version 1.0
 */
public class ReverseList {

    public static ListNode reverseList(ListNode head) {
        ListNode p = null;
        ListNode q;
        while (head != null) {
            q=head.next;
            head.next=p;
            p=head;
            head=q;
        }
        return p;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;

        ListNode reverseList = ReverseList.reverseList(a);
    }
}
