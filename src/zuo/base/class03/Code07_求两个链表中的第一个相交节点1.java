package zuo.base.class03;

import java.util.HashSet;

/**
 * 求两个链表中的第一个相交节点
 * 简单方法，利用hashSet判断，
 * 更好的方法，请看 ==> Code07_FindFirstIntersectNode2
 *
 * @author xiaoliang
 * @date 2021/09/13 20:22
 **/
public class Code07_求两个链表中的第一个相交节点1 {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node() {
        }
    }

    // 带头节点
    public static Node getIntersectNode(Node head1, Node head2) {

        if (head1 == null || head1.next == null || head2 == null || head2.next == null) {
            return null;
        }

        HashSet<Node> set1 = new HashSet<>();
        Node first = head1.next;
        while (first != null) {
            // 还没加入过返回true,已经存在返回false
            // 这里防止list1有环
            if (!set1.add(first)) {
                break;
            }
            first = first.next;
        }

        HashSet<Node> set2 = new HashSet<>();
        Node second = head2.next;
        while (second != null) {
            if (set1.contains(second)) {
                return second;
            }
            // 还没加入过返回true,已经存在返回false
            // 这里防止list2有环
            if (!set2.add(second)) {
                return null;
            }
            second = second.next;
        }

        return null;
    }




    public static void main(String[] args) {
        // Head1->1->2->3->4->5->6->7->null
        Node head1 = new Node();
        head1.next = new Node(1);
        head1.next.next = new Node(2);
        head1.next.next.next = new Node(3);
        head1.next.next.next.next = new Node(4);
        head1.next.next.next.next.next = new Node(5);
        head1.next.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next.next = new Node(7);

        // Head2->0->9->8->6->7->null
        Node head2 = new Node();
        head2.next = new Node(0);
        head2.next.next = new Node(9);
        head2.next.next.next = new Node(8);
        head2.next.next.next.next = head1.next.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

        // Head1->1->2->3->4->5->6->7->4...
        head1 = new Node();
        head1.next = new Node(1);
        head1.next.next = new Node(2);
        head1.next.next.next = new Node(3);
        head1.next.next.next.next = new Node(4);
        head1.next.next.next.next.next = new Node(5);
        head1.next.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next.next = head1.next.next.next.next; // 7->4

        // Head2->0->9->8->2...
        head2 = new Node();
        head2.next = new Node(0);
        head2.next.next = new Node(9);
        head2.next.next.next = new Node(8);
        head2.next.next.next.next = head1.next.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);

        // Head2->0->9->8->6->4->5->6..
        head2 = new Node();
        head2.next = new Node(0);
        head2.next.next = new Node(9);
        head2.next.next.next = new Node(8);
        head2.next.next.next.next = head1.next.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

    }

}
