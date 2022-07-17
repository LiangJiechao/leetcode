package leetcode.labuladong.binarytree;

/**
 * 1、如果把根节点看做第 1 层，如何打印出每一个节点所在的层数？
 * 2、如何打印出每个节点的左右子树各有多少节点？
 *
 * @author xiaoliang
 * @date 2022/01/16 12:01
 **/
public class 两个简单的二叉树问题 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 问题1：如果把根节点看做第 1 层，如何打印出每一个节点所在的层数？
    // 二叉树遍历函数
    void traverse(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        System.out.println("节点 " + root.val + " 在第 " + level + " 层");
        traverse(root.left, level + 1);
        traverse(root.right, level + 1);
    }

    // 问题2：如何打印出每个节点的左右子树各有多少节点？
    int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = count(root.left);
        int right = count(root.right);
        System.out.println("节点 " + root.val + " 的左子树有 " + left + " 个节点，右子树有 " + right + " 个节点");
        // 当前节点的数量
        return 1 + left + right;
    }

    public static void main(String[] args) {

    }

}
