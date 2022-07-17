package zuo.base.class04;

import java.util.Stack;

/**
 * 二叉树遍历，非递归法
 *
 * @author xiaoliang
 * @date 2021/09/14 09:22
 **/
public class Code02_二叉树遍历非递归版 {

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 二叉树的先序遍历，非递归版
     * 用栈：
     * 1、头节点进栈
     * 2、弹栈，输出/处理节点，把该节点的 '右节点' 和 '左节点' 依次进栈（如果有的话）
     * 3、循环 2
     *
     * @param head
     */
    public static void preOrderNonRecur(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.empty()) {
            Node node = stack.pop();
            System.out.print(node.value + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    /**
     * 二叉树的后序遍历，非递归版
     * 像先序一样，把先序的入栈 头左右 ==> 头右左 ==> 都入栈 ==> 弹出：左右头
     * 用栈：
     * 1、头节点进栈
     * 2、弹栈，输出/处理节点，把该节点的左节点和右节点依次进栈（如果有的话）
     * 3、循环 2
     *
     * @param head
     */
    public static void postOrderNonRecur(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Stack<Node> collect = new Stack<>();
        stack.push(head);
        while (!stack.empty()) {
            Node node = stack.pop();
            // 处理：放入收集栈
            collect.push(node);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        // 收集栈输出
        while (!collect.empty()) {
            System.out.print(collect.pop().value + " ");
        }
    }


    /**
     * 二叉树的中序遍历，非递归版
     * 用栈：
     * 1、先把头节点的所有左节点依次进栈
     * 2、弹出/处理，把该节点的右节点 按 1循环
     *
     * @param head
     */
    public static void inOrderNonRecur(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        // 把所有左节点依次进栈
        stack.push(head);
        while (head.left != null) {
            head = head.left;
            stack.push(head);
        }

        while (!stack.empty()) {
            head = stack.pop();
            System.out.print(head.value + " ");
            if (head.right != null) {
                head = head.right;
                stack.push(head);
                while (head.left != null) {
                    head = head.left;
                    stack.push(head);
                }
            }
        }
    }

    // 左老师的实现，与上面的思路一样
    public static void inOrderNonRecur2(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                // 所有左节点入栈
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.print(head.value + " ");
                head = head.right;
            }
        }
    }



    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        preOrderNonRecur(node1);
        System.out.println();
        inOrderNonRecur(node1);
        System.out.println();
        postOrderNonRecur(node1);
    }
}
