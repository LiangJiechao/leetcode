package zuo.base.class04;

/**
 * 判断是否为满二叉树
 * 方法一：算出这棵树的深度和节点数，看是否符合 2^height -1 == nodeCnt
 * 
 * @author xiaoliang
 * @date 2021/09/14 15:08
 **/
public class Code07_IsFBT {

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    static class ReturnData {
        int height;
        int nodeCnt;

        public ReturnData(int height, int nodeCnt) {
            this.height = height;
            this.nodeCnt = nodeCnt;
        }
    }

    public static boolean isFBT(Node head) {

        ReturnData info = process(head);
        return Math.pow(2, info.height) - 1 == info.nodeCnt;
    }

    private static ReturnData process(Node head) {
        if (head == null) {
            return new ReturnData(0, 0);
        }

        ReturnData leftData = process(head.left);
        ReturnData rightData = process(head.right);

        // 要返回的信息
        int height = Math.max(leftData.height, rightData.height) + 1;
        int nodeCnt = leftData.nodeCnt + rightData.nodeCnt + 1;

        return new ReturnData(height, nodeCnt);
    }

    public static void main(String[] args) {

        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
//        head.left.left = new Node(1);
        head.left.right = new Node(3);
//        head.right.left = new Node(5);
//        head.right.right = new Node(10);


        System.out.println("isFBT(head) = " + isFBT(head));
    }
}
