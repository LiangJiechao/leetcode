package zuo.base.class04;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 判断是否为搜索二叉树（中序遍历为升序）
 * 有三种方法：
 * 方法一：中序遍历后收集到List，然后进一步判断List
 * 方法二：递归判断
 * 方法三：改写中序遍历的非递归方法
 * 方法四：使用二叉树递归套路
 * 分析：判断是否为搜索二叉树，满足 1.左是搜; 2.右是搜; 3.左max<x; 4.右min>x
 * 故：创建结构 { boolean isBst; int min; int max }
 *
 * @author xiaoliang
 * @date 2021/09/14 15:07
 **/
public class Code04_IsBST {

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    // 递归套路分析出来的返回结构，使用并集
    static class ReturnData {
        boolean isBst;
        int min;
        int max;

        public ReturnData(boolean isBst, int min, int max) {
            this.isBst = isBst;
            this.min = min;
            this.max = max;
        }
    }

    /**
     * 方法四：使用二叉树递归套路
     * 分析：判断是否为搜索二叉树，满足 1.左是搜 2.右是搜 3.左max<x  4.右min>x
     * 故：创建结构 { boolean isBst; int min; int max }
     *
     * @param head
     * @return
     */
    public static boolean isBST4(Node head) {

        ReturnData b = process(head);
        return b.isBst;
    }

    private static ReturnData process(Node head) {

        if (head == null) {
            // 这里base case 返回值的 min和 max不好说，所以返回null，在后续判断
            return null;
        }

        ReturnData leftData = process(head.left);
        ReturnData rightData = process(head.right);

        // 要返回的东西
        boolean isBst = true;
        int min = head.value;
        int max = head.value;

        if (leftData != null) {
            min = Math.min(min, leftData.min);
            max = Math.max(max, leftData.max);
        }
        if (rightData != null) {
            min = Math.min(min, rightData.min);
            max = Math.max(max, rightData.max);
        }

        // 这里是 BST 每个节点要大于等于其左子树  右节点小于其右子树
        if (leftData != null && (!leftData.isBst || leftData.max > head.value)) {
            isBst = false;
        }
        if (rightData != null && (!rightData.isBst || rightData.min <= head.value)) {
            isBst = false;
        }
        return new ReturnData(isBst, min, max);
    }

    /**
     * 方法三：改写中序遍历的非递归方法
     *
     * @param head
     * @return
     */
    public static boolean isBST3(Node head) {
        if (head == null) {
            return true;
        }
        Stack<Node> stack = new Stack<>();
        // 把所有左节点依次进栈
        stack.push(head);
        while (head.left != null) {
            head = head.left;
            stack.push(head);
        }

        int preValue = Integer.MIN_VALUE;
        while (!stack.empty()) {
            head = stack.pop();

            // 判断时机
            if (preValue <= head.value) {
                preValue = head.value;
            } else {
                return false;
            }

            if (head.right != null) {
                head = head.right;
                stack.push(head);
                while (head.left != null) {
                    head = head.left;
                    stack.push(head);
                }
            }
        }
        return true;
    }



    /**
     * 方法二：递归判断
     * 中序遍历 打印时机换成比较时机
     *
     * @param head
     * @return
     */
    public static int preValue = Integer.MIN_VALUE;

    public static boolean isBST2(Node head) {
        if (head == null) {
            return true;
        }
        boolean isBst = isBST2(head.left);

        // 把打印时机换成比较时机
        // 怎么判断是不是BST呢
        if (!isBst) {
            return false;
        }
        if (preValue <= head.value) {
            preValue = head.value;
        } else {
            return false;
        }

        return isBST2(head.right);
    }

    /**
     * 方法一：中序遍历后收集到List，然后进一步判断List
     *
     * @param head
     * @return
     */
    public static boolean isBST1(Node head) {

        List<Node> list = new ArrayList<>();
        collectInOrderList(head, list);
        // 进一步判断list
        boolean b = checkBSTList(list);
        return b;
    }
    private static boolean checkBSTList(List<Node> list) {

        if (list == null || list.size() == 0) {
            return true;
        }
        int preValue = Integer.MIN_VALUE;
        boolean flag = true;

        for (Node item : list) {
            if (item.value < preValue) {
                flag = false;
                break;
            }
            preValue = item.value;
        }

        return flag;
    }
    /**
     * 中序遍历，收集成list
     *
     * @param head
     * @param list
     */
    private static void collectInOrderList(Node head, List<Node> list) {

        if (head == null) {
            return;
        }
        collectInOrderList(head.left, list);
        list.add(head);
        collectInOrderList(head.right, list);
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println("isBST1(head) = " + isBST1(head));
        System.out.println("isBST2(head) = " + isBST2(head));
        System.out.println("isBST3(head) = " + isBST3(head));
        System.out.println("isBST4(head) = " + isBST4(head));

    }

}
