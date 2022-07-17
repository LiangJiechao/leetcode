package zuo.base.class03;

/**
 * 求两个链表中的第一个相交节点
 * 不用额外数据结构的方法：
 * （怎么判断有环无环，如果有环：同时求出入环节点）==>
 *   求入环节点的方法：
     * 方法1：HashSet
     * 方法2：利用快慢指针，
     * ①快慢指针会在环内相遇，
     * ②相遇后快指针回到原点，慢指针保持原地
     * ③快慢指针开始一步一步走，相遇的节点即为入环的第一个节点
 * 首先，分有环无环两种情况：（怎么判断有环无环）
 * 一、两个链表都无环
 *  方法1：利用HashSet找到两个链表的第一个相交节点
 *  方法2：不使用额外结构
 *      ①利用指针，获得两个链表的长度以及尾节点
 *      ②判断两个尾节点内存地址是否相同，不相同则不相交；相同=>则长表先走差值步|len1-len2| ，然后再同时走，相遇的节点即为第一个相交节点
 * 二、两个链表都有环
 *  分为三种情况：
 *   1、两个环链表无相交
 *      因为两个链表的入环节点都已经知道，那么只需要让一个链表从入环节点的位置开始走，直到走回原点也没遇到另一个入环节点，
 *      则证明我两个环链表无相交
 *   2、两个链表在环外相交
 *      环外相交，那么入环节点肯定相同，
 *      然后获得两个链表的头节点到入环节点的长度，让长表先走差值步|len1-len2|，然后同时走，相遇时的节点即为第一个相交节点
 *   3、两个链表在环内相交
 *      因为两个链表的入环节点都已经知道，那么只需要让一个链表从入环节点的位置开始走，直到走回原点前能遇到另一个入环节点，
 *      则证明我两个环链表环内相交，则返回任一一个环内节点
 *
 * 三、一个链表有环，另一个无环 ==> 不存在此情况
 *
 * @author xiaoliang
 * @date 2021/09/13 20:22
 **/
public class Code07_求两个链表中的第一个相交节点2 {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node() {
        }
    }

    /**
     * 求两个链表中的第一个相交节点
     * @param head1
     * @param head2
     * @return
     */
    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head1.next == null || head2 == null || head2.next == null) {
            return null;
        }
        Node loop1 = firstListLoop(head1);
        Node loop2 = firstListLoop(head2);

        if(loop1==null&&loop2==null){
            // 一、两个链表都无环
            return noLoop(head1,head2);
        } else if (loop1 != null && loop2 != null) {
            // 二、两个链表都有环，分三种情况
            return bothLoop(head1,loop1,head2,loop2);

        }else {
            // 一个有环，一个无环的情况
            return null;
        }
    }

    /**
     * 判断链表是否有环，如果有环：同时求出入环节点
     *
     * @param head
     * @return
     */
    private static Node firstListLoop(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        // 如果有环
        if (fast == slow) {
            fast = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        } else {
            return null;
        }
    }

    public static Node noLoop(Node head1, Node head2) {
        int len1 = 0;
        int len2 = 0;
        Node first = head1;
        while (first.next != null) {
            len1++;
            first = first.next;
        }
        Node second = head2;
        while (second.next != null) {
            len2++;
            second = second.next;
        }

        if (first == second) {
            // 相交
            // 算出差值，已经长短链表
            int sub = len1 > len2 ? len1 - len2 : len2 - len1;
            Node pLong = len1 > len2 ? head1 : head2;
            Node pShort = pLong == head1 ? head2 : head1;
            // 长链表先走差值
            while (sub != 0) {
                pLong = pLong.next;
                sub--;
            }
            while (pLong != pShort) {
                pLong = pLong.next;
                pShort = pShort.next;
            }
            return pLong;
        } else {
            // 不相交
            return null;
        }
    }

    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        // 二、两个链表都有环，分三种情况
        if (loop1 == loop2) {
            // 1.如果是环外相交，那么入环节点肯定相同
            int len1 = 0;
            int len2 = 0;
            Node first = head1;
            while (first != loop1) {
                len1++;
                first = first.next;
            }
            Node second = head2;
            while (second != loop1) {
                len2++;
                second = second.next;
            }
            // 算出差值，已经长短链表
            int sub = len1 > len2 ? len1 - len2 : len2 - len1;
            Node pLong = len1 > len2 ? head1 : head2;
            Node pShort = pLong == head1 ? head2 : head1;
            // 长链表先走差值
            while (sub != 0) {
                pLong = pLong.next;
                sub--;
            }
            while (pLong != pShort) {
                pLong = pLong.next;
                pShort = pShort.next;
            }
            return pLong;
        } else {
            // 2.如果是环内相交
            Node first = loop1.next;
            while (first != loop1) {
                if (first == loop2) {
                    return loop1;
                }
                first = first.next;
            }
            // 3. 无相交
            return null;
        }
    }

    public static void main(String[] args) {
        // Head1->1->2->3->4->5->6->7->null
        Node head1 = new Node(-1);
        head1.next = new Node(1);
        head1.next.next = new Node(2);
        head1.next.next.next = new Node(3);
        head1.next.next.next.next = new Node(4);
        head1.next.next.next.next.next = new Node(5);
        head1.next.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next.next = new Node(7);

        // Head2->0->9->8->6->7->null
        Node head2 = new Node(-1);
        head2.next = new Node(0);
        head2.next.next = new Node(9);
        head2.next.next.next = new Node(8);
        head2.next.next.next.next = head1.next.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

        // Head1->1->2->3->4->5->6->7->4...
        head1 = new Node(-1);
        head1.next = new Node(1);
        head1.next.next = new Node(2);
        head1.next.next.next = new Node(3);
        head1.next.next.next.next = new Node(4);
        head1.next.next.next.next.next = new Node(5);
        head1.next.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next.next = head1.next.next.next.next; // 7->4

        // Head2->0->9->8->2...
        head2 = new Node(-1);
        head2.next = new Node(0);
        head2.next.next = new Node(9);
        head2.next.next.next = new Node(8);
        head2.next.next.next.next = head1.next.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);

        // Head2->0->9->8->6->4->5->6..
        head2 = new Node(-1);
        head2.next = new Node(0);
        head2.next.next = new Node(9);
        head2.next.next.next = new Node(8);
        head2.next.next.next.next = head1.next.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

    }
}
