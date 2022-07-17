package zuo.base.class04;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断是否为完全二叉树
 * 方法一：
 * 1.任一节点有右无左 ==> false;
 * 2.在满足1的条件下，若出现了一个节点的子节点出现双非全节点，则后续节点皆为叶子节点
 *
 * @author xiaoliang
 * @date 2021/09/14 15:08
 **/
public class Code05_IsCBT {

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean isCBT(Node head) {

        if (head == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList();
        queue.add(head);

        // 标志位：用来记录是否出现了 一个节点的子节点出现双非全节点
        boolean flag = false;
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.left == null && node.right != null) {
                // 任一节点有右无左 ==> false;
                return false;
            }
            if (flag && (node.left != null || node.right != null)) {
                // 标志位出现后，后面的节点都必须为叶子节点
                return false;
            }

            // 在满足1的条件下，若出现了一个节点的子节点出现双非全节点，则后续节点皆为叶子节点
            if (node.left != null && node.right == null) {
                flag = true;
            }

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(3);
        head.right.right = new Node(5);

        System.out.println("isCBT(head) = " + isCBT(head));

    }
}
