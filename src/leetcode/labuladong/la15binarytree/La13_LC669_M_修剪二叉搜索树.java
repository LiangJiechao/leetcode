package leetcode.labuladong.la15binarytree;

/**
 * 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。
 * 通过修剪二叉搜索树，使得所有节点的值在[low, high]中。
 * 修剪树 不应该 改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。
 * 可以证明，存在 唯一的答案 。
 *
 * @author xiaoliang
 * @date 2022/03/01 11:22
 **/
public class La13_LC669_M_修剪二叉搜索树 {

    public TreeNode trimBST2(TreeNode root, int low, int high) {

        return traverse(root, low, high);
    }
    // 后序位置处理
    private TreeNode traverse(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        TreeNode left = traverse(root.left, low, high);
        TreeNode right = traverse(root.right, low, high);
        root.left = left;
        root.right = right;

        if (root.val < low) {
            return root.right;
        } else if (root.val > high) {
            return root.left;
        }
        return root;
    }

    // 前序位置
    public TreeNode trimBST(TreeNode root, int low, int high) {

        // 定义：删除 BST 中小于 low 和大于 high 的所有节点，返回结果 BST
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            // 直接返回 root.right，等于删除 root 以及 root 的左子树
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            // 直接返回 root.left，等于删除 root 以及 root 的右子树
            return trimBST(root.left, low, high);
        }
        // 闭区间 [lo, hi] 内的节点什么都不做
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

}
