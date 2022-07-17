package leetcode.labuladong.la15binarytree;

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
public class La10_LC104_E_二叉树的最大深度 {

    // 两种解题思路
    // 二叉树题目的递归解法可以分两类思路，
    // 第一类是遍历一遍二叉树得出答案，
    // 第二类是通过分解问题计算出答案，
    // 这两类思路分别对应着 回溯算法核心框架 和 动态规划核心框架。

    int res = 0;
    int depth = 0;

    public void maxDepth2(TreeNode root) {
        if (root == null) {
            res = Math.max(res, depth);
            return;
        }
        depth++;
        maxDepth2(root.left);
        maxDepth2(root.right);
        depth--;

    }

    /**因为利用到左右子树的信息，所以主要逻辑放在后序位置
     * 首先利用递归函数的定义算出左右⼦树的最⼤深度，然后推出原树的最大深度，主要逻辑⾃然放在后序位置。
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        int depth = Math.max(left, right) + 1;

        return depth;
    }
}
