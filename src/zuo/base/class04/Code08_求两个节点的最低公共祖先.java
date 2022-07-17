package zuo.base.class04;

import java.util.*;

/**
 * 求两个节点的最低公共祖先
 * 两种方法：
 * 方法一：用Map和Set，用map记录所有节点的父节点，然后把node1的所有祖先放入set中，
 * 在map中遍历找到node2的祖先在set中，即为最低公共祖先
 * 方法二：递归
 * 有两种情况：
 * ① node1与node2互为公共祖先
 * ② node1与node2不互为公共祖先，需要汇聚才能找到
 *
 * @author xiaoliang
 * @date 2021/09/14 21:56
 **/
public class Code08_求两个节点的最低公共祖先 {

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    static class ReturnData {
        boolean findA;
        boolean findB;
        Node res;

        public ReturnData(boolean findA, boolean findB, Node res) {
            this.findA = findA;
            this.findB = findB;
            this.res = res;
        }
    }

    /**
     * 使用二叉树递归模板
     * todo res 这里不是很明白
     * @param head
     * @param node1
     * @param node2
     * @return
     */
    public static Node lowestAncestor3(Node head, Node node1, Node node2) {
        ReturnData b = process(head, node1, node2);
        return b.res;
    }

    private static ReturnData process(Node head, Node node1, Node node2) {
        if (head == null || node1 == null || node2 == null) {
            return new ReturnData(false, false, null);
        }

        ReturnData leftData = process(head.left, node1, node2);
        ReturnData rightData = process(head.right, node1, node2);

        // 要返回的值
        boolean findA = leftData.findA || rightData.findA || head == node1;
        boolean findB = leftData.findB || rightData.findB || head == node2;
        Node res = null;

        if (leftData.res!=null){
            // 左子树中找到了两个节点，即找到答案了，并不断往上传
            res = leftData.res;
        }else if (rightData.res!=null){
            // 右子树中找到了两个节点
            res = rightData.res;
        }else {
            if (findA&&findB){
                // 只有找到两个了，才能为res赋值
                res = head;
            }
        }
        return new ReturnData(findA, findB, res);
    }

    /**
     * 方法二：递归
     * 有两种情况：
     * ① node1与node2互为公共祖先
     * ② node1与node2不互为公共祖先，需要汇聚才能找到
     *
     * @param head
     * @param node1
     * @param node2
     * @return
     */
    public static Node lowestAncestor2(Node head, Node node1, Node node2) {

        if (head == null || head == node1 || head == node2) {
            return head;
        }

        //分别去左右寻找这两个节点，如果没有找到，会返回空
        Node left = lowestAncestor2(head.left, node1, node2);
        Node right = lowestAncestor2(head.right, node1, node2);

        // 此时是两个分支，需要汇聚
        if (left != null && right != null) {
            return head;
        }

        return left != null ? left : right;
    }

    /**
     * 求node1、node2的最低公共祖先
     * 这里前提是node1和node2一定属于head为头的树
     * 方法一：用Map和Set，用map记录所有节点的父节点，然后把node1的所有祖先放入set中，
     * 在map中遍历找到node2的祖先在set中，即为最低公共祖先
     *
     * @param head
     * @param node1
     * @param node2
     * @return
     */
    public static Node lowestAncestor1(Node head, Node node1, Node node2) {
        if (head == null || node1 == null || node2 == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Set<Node> set = new HashSet<>();

        map.put(head, head);
        // 遍历把所有节点的父节点找到
        getTreeNodeParent(head, map);

        Node cur = node1;
        set.add(cur);
        // 把node1的祖先节点放入set中
        while (cur != head) {
            Node parent = map.get(cur);
            set.add(parent);
            cur = parent;
        }
        cur = node2;
        // 判断node2
        while (!set.contains(cur)) {
            cur = map.get(cur);
        }
        return cur;
    }

    private static void getTreeNodeParent(Node head, Map<Node, Node> map) {
        if (head == null) {
            return;
        }
        if (head.left != null) {
            map.put(head.left, head);
            getTreeNodeParent(head.left, map);
        }
        if (head.right != null) {
            map.put(head.right, head);
            getTreeNodeParent(head.right, map);
        }
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        Node node6 = new Node(6);
        head.right = node6;
        Node node1 = new Node(1);
        head.left.left = node1;
        head.left.right = new Node(3);
        Node node5 = new Node(5);
        head.right.left = node5;
        head.right.left.left = new Node(5);
        head.right.left.left.left = new Node(5);
        System.out.println("lowestAncestor1(head,node6,node5).value = " + lowestAncestor1(head, node6, node5).value);
        System.out.println("lowestAncestor2(head,node6,node5).value = " + lowestAncestor2(head, node6, node5).value);
        System.out.println("lowestAncestor3(head,node6,node5).value = " + lowestAncestor3(head, node6, node5).value);
    }

}
