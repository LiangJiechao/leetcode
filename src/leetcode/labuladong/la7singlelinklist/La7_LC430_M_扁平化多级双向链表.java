package leetcode.labuladong.la7singlelinklist;

/**
 * https://leetcode.cn/problems/flatten-a-multilevel-doubly-linked-list/
 *
 * @author liangjiechao
 * @date 2022/10/09 20:29
 **/
public class La7_LC430_M_扁平化多级双向链表 {

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }


    // 递归法
    public Node flatten(Node head) {
        Node dummy = new Node();
        dummy.next = head;
        Node p = head;

        while (p != null) {
            if (p.child == null) {
                p = p.next;
            } else {
                Node tmp = p.next;
                Node chead = flatten(p.child);
                p.next = chead;
                chead.prev = p;
                p.child = null;
                Node last = chead;
                while (last.next != null) {
                    last = last.next;
                }
                last.next = tmp;
                if (tmp != null) {
                    tmp.prev = last;
                }
                p = tmp;

            }
        }

        return dummy.next;
    }

    // 迭代法
    public Node flatten2(Node head) {

        Node dummy = new Node();
        dummy.next = head;
        Node p = head;
        while (p != null) {

            if (p.child != null) {
                Node tmp = p.next;
                Node child = p.child;
                p.next = child;
                child.prev = p;
                p.child = null;
                Node last = child;
                while (last.next != null) {
                    last = last.next;
                }
                last.next = tmp;
                if (tmp != null) {
                    tmp.prev = last;
                }
            }
            p = p.next;
        }

        return dummy.next;
    }
}
