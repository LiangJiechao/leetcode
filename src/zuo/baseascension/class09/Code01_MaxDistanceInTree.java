package zuo.baseascension.class09;

/**
 * 求一棵树中两个节点间的最大距离
 * 分析：
 * 按根节点参不参与分为两种情况
 * 1.头节点参与：最大距离 = 左高 + 1 + 右高
 * 2.头节点不参与：最大距离 = max(左子树最大距离，右子树最大距离)
 * 套路的返回信息：{树高，最大距离}
 *
 * @author xiaoliang
 * @date 2021/09/20 09:01
 **/
public class Code01_MaxDistanceInTree {

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
        int maxDist;

        public ReturnData(int height, int maxDist) {
            this.height = height;
            this.maxDist = maxDist;
        }
    }

    public static int getMaxDistance(Node head) {
        if (head == null) {
            return 0;
        }

        ReturnData res = process(head);
        return res.maxDist;
    }

    private static ReturnData process(Node head) {

        // base case
        if (head == null) {
            return new ReturnData(0, 0);
        }
        ReturnData leftData = process(head.left);
        ReturnData rightData = process(head.right);

        int height = Math.max(leftData.height, rightData.height) + 1;
        // head参与 与 head不参与
        int maxDist = Math.max(leftData.height + 1 + rightData.height,
                            Math.max(leftData.maxDist, rightData.maxDist));

        return new ReturnData(height, maxDist);
    }


    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.left = new Node(2);
        head1.right = new Node(3);
        head1.left.left = new Node(4);
        head1.left.right = new Node(5);
        head1.right.left = new Node(6);
        head1.right.right = new Node(7);
        head1.left.left.left = new Node(8);
        head1.right.left.right = new Node(9);
        System.out.println(getMaxDistance(head1));
    }


}
