package leetcode.labuladong.binarytree;

/**
 * @author xiaoliang
 * @date 2022/09/14 20:49
 **/
public class 二叉树转双向链表 {

    static class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public Node changeTreeToDeList(Node root) {
        getLeftestNode(root);
        process(root);
        return res;
    }

    Node res = null;

    private void getLeftestNode(Node root) {
        Node tmp = root;
        while (tmp != null) {
            res = tmp;
            tmp = tmp.left;
        }
    }

    // todo 学习学习
    //  需要保存上次访问的节点
    //  中序遍历
    Node pre = null;

    private void process(Node root) {
        if (root == null) {
            return;
        }
        process(root.left);

        root.left = pre;
        if (pre != null) {
            pre.right = root;
        }
        pre = root;
        process(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        Node convert = new 二叉树转双向链表().changeTreeToDeList(root);
        System.out.println(convert);
    }
}
