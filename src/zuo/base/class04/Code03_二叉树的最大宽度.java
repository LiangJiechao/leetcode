package zuo.base.class04;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 队列，在Java中,用双向循环链表 LinkedList
 * 层序遍历，求出二叉树的最大宽度，（思想是与层序遍历相似的）
 * 方法一：用Map记录每个节点的层数
 * 方法二：curend，nextend 记录当前层和下一层的最后一个节点
 *
 * @author xiaoliang
 * @date 2021/09/14 10:23
 **/
public class Code03_二叉树的最大宽度 {

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 求树的最大宽度
     * 方法一：用Map记录每个节点的层数
     *
     * @param head
     */
    public static int maxWidth1(Node head) {

        if (head == null) {
            return 0;
        }
        // 用来记录每个节点对应的层数
        Map<Node, Integer> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        // 头节点层数为1
        map.put(head, 1);
        int curLevel = 1;
        int curLevelNodes = 0;
        int max = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int curNodeLevel = map.get(node);
            if (curNodeLevel == curLevel) {
                curLevelNodes++;
            } else {
                // 进入下一层了，清算合计该层的节点数，
                // 初始化curLevelNodes=1（因为已经进入了下一层的第一个节点了），
                // 当前层数++
                max = Math.max(max, curLevelNodes);
                curLevelNodes = 1;
                curLevel++;
            }
            // 放入节点时，把该节点的层数也保存
            if (node.left != null) {
                map.put(node.left, curLevel + 1);
                queue.add(node.left);
            }
            if (node.right != null) {
                map.put(node.right, curLevel + 1);
                queue.add(node.right);
            }
        }

        // 因为最后一个元素出队时，还没有清算
        return Math.max(max, curLevelNodes);
    }

    /**
     * 求树的最大宽度
     * 方法二：不需要用map记录层数，
     * curend，nextend 记录当前层和下一层的最后一个节点
     *
     * @param head
     */
    public static int maxWidth2(Node head) {

        if (head == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);

        // 记录当前层和下一层的最后一个节点
        Node curEnd = head;
        Node nextEnd = null;

        int curLevelNodes = 0;
        int max = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            curLevelNodes++;

            if (node.left != null) {
                queue.add(node.left);
                nextEnd = node.left;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextEnd = node.right;
            }

            if (node == curEnd) {
                // 该层的最后一个节点，清算结果，初试化curLevelNodes和curEnd
                max = Math.max(max, curLevelNodes);
                curLevelNodes = 0;
                curEnd = nextEnd;
            }
        }

        return max;
    }

    /**
     * 层序遍历
     *
     * @param head
     */
    public static void levelOrder(Node head) {
        if (head == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.value + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
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

//        levelOrder(node1);

        System.out.println("maxWidth1() = " + maxWidth1(node1));
        System.out.println("maxWidth2() = " + maxWidth2(node1));
    }

}
