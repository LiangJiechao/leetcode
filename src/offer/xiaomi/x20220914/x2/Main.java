package offer.xiaomi.x20220914.x2;

class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int data) {
        this.data = data;
    }

    public Node() {
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    /* Write Code Here */
    public Node Convert(Node pRootOfTree) {
        getLeftestNode(pRootOfTree);
        process(pRootOfTree);
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
        pre= root;
        process(root.right);
    }
}

public class Main {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        Node convert = new Solution().Convert(root);
        System.out.println(convert);
    }
}
