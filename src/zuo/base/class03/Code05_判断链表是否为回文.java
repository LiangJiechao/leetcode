package zuo.base.class03;

import java.util.Stack;

/**
 * 判断链表是否回文
 *
 * @author xiaoliang
 * @date 2021/09/13 17:44
 **/
public class Code05_判断链表是否为回文 {

    static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node() {
        }
    }

    /**
     * 判断链表是否回文，有头节点
     * 方法1：用栈，全部用栈
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome1(Node head) {

        // 有头节点
        if (head == null || head.next == null || head.next.next == null) {
            return true;
        }
        Stack<Node> stack = new Stack<>();
        Node p = head.next;

        // 入栈
        while (p != null) {
            stack.push(p);
            p = p.next;
        }

        Node first = head.next;
        // 判断
        while (first.next != null) {
            if (stack.pop().value != first.value) {
                return false;
            }
            first = first.next;
        }
        return true;
    }

    /**
     * 判断链表是否回文，有头节点
     * 方法2：用快慢指针和栈，省一半的栈空间
     * 找到链表的中点，中点后的都入栈
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome2(Node head) {

        // 有头节点
        if (head == null || head.next == null || head.next.next == null) {
            return true;
        }

        // 从头节点开始跑
        Node fast = head;
        Node slow = head;
        // fast 满足走两步才走
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // fast后还有一个节点
        if (fast.next != null) {
            slow = slow.next;
        }

        // 入栈
        Stack<Node> stack = new Stack<>();
        Node mid = slow.next;
        while (mid != null) {
            stack.push(mid);
            mid = mid.next;
        }

        // 比较、判断
        Node first = head.next;
        while (!stack.empty()) {
            if (first.value != stack.pop().value) {
                return false;
            }
            first = first.next;
        }
        return true;
    }

    /**
     * 判断链表是否回文，头节点
     * 方法3：用快慢指针，空间复杂度 O(1)
     * 找到链表的中点，中点后的都逆序，然后判断回文，完后恢复链表
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome3(Node head) {
        // 有头节点
        if (head == null || head.next == null || head.next.next == null) {
            return true;
        }

        // 从头节点开始跑
        Node fast = head;
        Node slow = head;
        // fast 满足走两步才走
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // fast后还有一个节点
        if (fast.next != null) {
            slow = slow.next;
        }

        //有头节点，原地逆序，返回整个链表的中间节点
        Node mid = reverse(slow);

        Node second = mid.next;
        Node first = head.next;
        boolean result = true;

        // 判断回文
        while (second != null) {
            if (second.value != first.value) {
                result = false;
                break;
            }
            second = second.next;
            first = first.next;
        }

        //恢复链表
        //有头节点，原地逆序
        reverse(slow);

        return result;
    }

    /**
     * 方法1：有头节点，原地逆序
     *
     * @param head
     * @return
     */
    public static Node reverse(Node head) {

        if (head == null || head.next == null) {
            return head;
        }
        Node pre = head.next;
        Node cur = pre.next;

        while (cur != null) {
            pre.next = cur.next;
            cur.next = head.next;
            head.next = cur;
            cur = pre.next;
        }
        return head;
    }

    public static void main(String[] args) {

        Node head = new Node();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        Node node5 = new Node(4);
        Node node6 = new Node(3);
        Node node7 = new Node(2);
        Node node8 = new Node(1);
        Node node9 = new Node(9);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

//        node4.next = node5;
        node4.next = node9;
        node9.next = node5;

        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
//        node8.next = node9;

        boolean palindrome = isPalindrome3(head);
        System.out.println("palindrome = " + palindrome);
    }

}
