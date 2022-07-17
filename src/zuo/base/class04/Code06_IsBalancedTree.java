package zuo.base.class04;

/**
 * 判断是否为平衡二叉树
 *
 * @author xiaoliang
 * @date 2021/09/14 15:08
 **/
public class Code06_IsBalancedTree {

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    static class ReturnData {
        boolean isBalanced;
        int height;

        public ReturnData(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public static boolean isBalancedTree(Node head) {
        ReturnData b = process(head);
        return b.isBalanced;
    }

    private static ReturnData process(Node head) {
        if (head == null) {
            return new ReturnData(true, 0);
        }

        ReturnData leftData = process(head.left);
        ReturnData rightData = process(head.right);

        // 要返回的信息
        int height = Math.max(leftData.height, rightData.height) + 1;

        boolean isBalanced = true;
        if (!leftData.isBalanced || !rightData.isBalanced || !(Math.abs(leftData.height - rightData.height) < 2)) {
            isBalanced=false;
        }
        return new ReturnData(isBalanced, height);
    }

    public static void main(String[] args) {

        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);
//        head.right.left.left = new Node(5);
//        head.right.left.left.left = new Node(5);

        boolean isBalancedTree = isBalancedTree(head);
        System.out.println("isBalancedTree = " + isBalancedTree);

    }
}
