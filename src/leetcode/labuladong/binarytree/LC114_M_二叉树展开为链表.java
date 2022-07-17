package leetcode.labuladong.binarytree;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 * 654. 最大二叉树（中等）
 *
 * 105. 从前序与中序遍历序列构造二叉树（中等）
 *
 * 106. 从中序与后序遍历序列构造二叉树（中等）
 *
 * 889. 根据前序和后序遍历构造二叉树（中等）
 * @author xiaoliang
 * @date 2022/01/18 17:07
 **/
public class LC114_M_二叉树展开为链表 {
    public static class TreeNode {
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

    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        if (root.left==null) {
            return;
        }
        TreeNode mostRight = root.left;
        // 找到最右的指针，
        while (mostRight.right != null) {
            mostRight = mostRight.right;
        }
        mostRight.right = root.right;
        root.right = root.left;
        root.left = null;
    }

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        flatten(treeNode);
    }
}
