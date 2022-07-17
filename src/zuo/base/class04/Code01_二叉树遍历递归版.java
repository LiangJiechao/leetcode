package zuo.base.class04;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树遍历，递归版
 * 递归序的概念
 * 每个节点都会访问到三次 1 2 4 4 4 2 5 5 5 2 1 3 6 6 6 3 7 7 7 3 1
 *
 * @author xiaoliang
 * @date 2021/09/14 09:21
 **/
public class Code01_二叉树遍历递归版 {

    static class Node{
        int value;
        Node left;
        Node right;

        public Node(int  value){
            this.value=value;
        }
    }

    // 可以先收集，再打印
    static List<Integer> preOrderList = new ArrayList<>();
    static List<Integer> inOrderList = new ArrayList<>();
    static List<Integer> postOrderList = new ArrayList<>();

    /**
     * 二叉树的先序遍历，递归版
     * @param head
     */
    public static void preOrderRecur(Node head) {
        if (head==null){
            return;
        }
        // 处理
        System.out.print(head.value+" ");
//        preOrderList.add(head.value);
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    /**
     * 二叉树的中序遍历，递归版
     * @param head
     */
    public static void inOrderRecur(Node head) {
        if (head==null){
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value+" ");
//        inOrderList.add(head.value);
        inOrderRecur(head.right);
    }

    /**
     * 二叉树的后序遍历，递归版
     * @param head
     */
    public static void postOrderRecur(Node head) {
        if (head==null){
            return;
        }
        postOrderRecur(head.left);
        postOrderRecur(head.right);
        System.out.print(head.value+" ");
//        postOrderList.add(head.value);
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

        preOrderRecur(node1);
        System.out.println();
        inOrderRecur(node1);
        System.out.println();
        postOrderRecur(node1);

//        preOrderList.forEach(x -> System.out.print(x + " "));
//        System.out.println();
//        inOrderList.forEach(x -> System.out.print(x + " "));
//        System.out.println();
//        postOrderList.forEach(x -> System.out.print(x + " "));
//        System.out.println();
    }
}
