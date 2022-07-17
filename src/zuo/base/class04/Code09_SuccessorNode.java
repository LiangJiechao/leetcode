package zuo.base.class04;

import java.util.ArrayList;
import java.util.List;

/**
 * 求一个节点的直接后续节点（即中序遍历的下一个节点）
 * 因为此树的数据结构中有指向直接 parent的指针，所以用方法二会更快
 * 两种方法：
 * 方法一：
 * 用中序遍历，保存遍历顺序，然后找到直接后续节点
 * 方法二：
 * ① x有右树，则x的后续位右树的最左节点
 * ② x无右树，那它的后续节点是他的父节点直到是上一个节点的左子树，或者他就是中序遍历中最后一个节点。
 *
 * @author xiaoliang
 * @date 2021/09/14 21:56
 **/

public class Code09_SuccessorNode {

    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent; // 有父指针

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 方法二：
     * ① x有右树，则x的后续位右树的最左节点
     * ② x无右树，那么x是这棵树的最右节点，那它的后续节点是他的父节点直到是上一个节点的左子树，或者他就是中序遍历中最后一个节点。
     *
     * @param node
     * @return
     */
    public static Node getSuccessorNode2(Node node) {

        if (node == null) {
            return null;
        }

        if (node.right != null) {
            // ① x有右树，则x的后续位右树的最左节点
            return getMostLeftNode(node.right);
        } else {
            // ② x无右树，那它的后续节点是他的父节点直到是上一个节点的左子树，或者他就是中序遍历中最后一个节点。
            Node parent = node;
            while (parent != null && parent.left != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }

    }

    private static Node getMostLeftNode(Node node) {
        Node cur = node;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }

    /**
     * 方法一：
     * 用中序遍历，保存遍历顺序，然后找到直接后续节点
     * 但该方法没有利用到Node结构上的parent属性
     *
     * @param node
     * @return
     */
    public static Node getSuccessorNode1(Node head, Node node) {

        if (head == null || node == null) {
            return null;
        }
        List<Node> inOrderList = new ArrayList<>();

        getInOrderList(head, inOrderList);

        int i = inOrderList.indexOf(node);
        if (i == inOrderList.size() - 1) {
            return null;
        }

        return inOrderList.get(i + 1);
    }

    /**
     * 根据头节点获得节点的中序列表
     *
     * @param head
     * @param inOrderList
     */
    private static void getInOrderList(Node head, List<Node> inOrderList) {
        if (head == null) {
            return;
        }
        getInOrderList(head.left, inOrderList);
        inOrderList.add(head);
        getInOrderList(head.right, inOrderList);

    }

    public static void main(String[] args) {

        Node head = new Node(6);
        head.parent = null;
        head.left = new Node(3);
        head.left.parent = head;
        head.left.left = new Node(1);
        head.left.left.parent = head.left;
        head.left.left.right = new Node(2);
        head.left.left.right.parent = head.left.left;
        head.left.right = new Node(4);
        head.left.right.parent = head.left;
        head.left.right.right = new Node(5);
        head.left.right.right.parent = head.left.right;
        head.right = new Node(9);
        head.right.parent = head;
        head.right.left = new Node(8);
        head.right.left.parent = head.right;
        head.right.left.left = new Node(7);
        head.right.left.left.parent = head.right.left;
        head.right.right = new Node(10);
        head.right.right.parent = head.right;


        Node successorNode = getSuccessorNode1(head, head.right.right);

        if (successorNode == null) {
            System.out.println("节点  ==> " + "为该树最后一个节点");
        } else {
            System.out.println("successorNode = " + successorNode.value);
        }

        successorNode = getSuccessorNode2( head.right.right);
        if (successorNode == null) {
            System.out.println("节点  ==> " + "为该树最后一个节点");
        } else {
            System.out.println("successorNode = " + successorNode.value);
        }

    }

}

