package zuo.base.class03;

/**
 * 倒转列表
 * https://www.cnblogs.com/mwl523/p/10749144.html
 * @author xiaoliang
 * @date 2021/09/13 16:50
 **/
public class Code04_逆转链表 {

    static class Node {
        public int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node() {
        }
    }

    /**
     * 方法1：有头节点，原地逆序
     *
     * @param head
     * @return
     */
    public static Node reverse1(Node head) {

        if (head == null || head.next == null|| head.next.next == null) {
            return head;
        }
        Node pre = head.next;
        Node cur = pre.next;

        while (cur!=null){
            pre.next = cur.next;
            cur.next = head.next;
            head.next = cur;
            cur = pre.next;
        }
        return head;
    }

    /**
     * 方法2：新建节点，头插法，有头节点
     *
     * @param head
     * @return
     */
    public static Node reverse2(Node head) {

        if (head == null || head.next == null|| head.next.next == null) {
            return head;
        }
        Node newHead = new Node();
        Node pCur = head.next;
        Node pNext = null;
        while (pCur != null) {
            pNext = pCur.next;
            pCur.next = newHead.next;
            newHead.next = pCur;
            pCur = pNext;
        }
        return newHead;
    }


    /**
     * 方法3：递归方法：逆转链表
     * https://zhuanlan.zhihu.com/p/86745433
     * @param head 是传入的是第一个有效节点
     * @return
     */
    public static Node reverse3(Node head) {

        // base case
        if (head.next == null) {
            return head;
        }
        Node last = reverse3(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    /**
     * 递归方法：逆转链表，逆转链表前N个元素
     * @param head
     * @param n n要比head.length 小
     * @return
     */
    static Node successor = null; // 后驱节点
    public static Node reverseN(Node head,int n) {
        if (n==1){
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        Node last = reverseN(head.next,n-1);
        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next= successor;
        return last;
    }


    public static void main(String[] args) {
        Node head = new Node();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
//
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        head.next = reverseN(head.next,2);

        Node p = head.next;
        while (p != null) {
            System.out.println(p.value);
            p = p.next;
        }
    }

}
