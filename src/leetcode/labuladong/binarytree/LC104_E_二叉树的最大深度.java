package leetcode.labuladong.binarytree;

/**
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 *
 * @author xiaoliang
 * @date 2022/01/16 11:08
 **/
public class LC104_E_二叉树的最大深度 {
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

    // 两种解题思路
    // 二叉树题目的递归解法可以分两类思路，
    // 第一类是遍历一遍二叉树得出答案，
    // 第二类是通过分解问题计算出答案，
    // 这两类思路分别对应着 回溯算法核心框架 和 动态规划核心框架。

    // 记录最大深度
    int res = 0;
    // 记录遍历到的节点的深度
    int depth = 0;

    public int maxDepth2(TreeNode root) {
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            // 叶子节点，统计深度
            res = Math.max(res, depth);
        }
        // 前序位置
        depth++;
        traverse(root.left);
        traverse(root.right);
        // 后序位置
        depth--;
    }

    // 容易发现一棵二叉树的最大深度可以通过子树的最大高度推导出来，
    // 这就是分解问题计算答案的思路
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);

        // 本节点的最大深度 = 其max(左子树的最大深度，右子树的最大深度)+1
        return Math.max(leftMax, rightMax) + 1;
    }
}
