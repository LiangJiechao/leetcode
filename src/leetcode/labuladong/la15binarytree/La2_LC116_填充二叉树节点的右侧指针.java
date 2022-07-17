package leetcode.labuladong.la15binarytree;

/**
 * @author xiaoliang
 * @date 2022/02/28 19:19
 **/
public class La2_LC116_填充二叉树节点的右侧指针 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;

    public Node connect(Node root) {
        if (root != null) {
            connectTwoNode(root.left, root.right);
        }
        return root;

    }

    private void connectTwoNode(Node node1, Node node2) {

        if (node1 == null || node2 == null) {
            return;
        }
        node1.next = node2;

        connectTwoNode(node1.left, node1.right);
        connectTwoNode(node2.left, node2.right);
        connectTwoNode(node1.right, node2.left);

    }
}
