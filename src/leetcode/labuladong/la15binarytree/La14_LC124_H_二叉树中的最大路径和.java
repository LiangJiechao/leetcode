package leetcode.labuladong.la15binarytree;

/**
 * 求任意两节点之间的路径和最大
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。
 * 同一个节点在一条路径序列中 至多出现一次 。该
 * 路径 至少包含一个 节点，且不一定经过根节点。
 * <p>
 * 路径和 是路径中各节点值的总和。
 * <p>
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 * @author xiaoliang
 * @date 2022/03/01 11:41
 **/
public class La14_LC124_H_二叉树中的最大路径和 {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        traverse(root);
        return max;
    }

    // 后序位置处理逻辑
    private int traverse(TreeNode root) {

        if (root == null) {
            return 0;
        }

//        int left = traverse(root.left);
//        int right = traverse(root.right);
//        int cur = root.val;
//        max = Math.max(Math.max(left, 0) + Math.max(right, 0) + cur, max);
//        return root.val + Math.max(0, Math.max(left, right));

        int left = Math.max(0, traverse(root.left));
        int right = Math.max(0, traverse(root.right));

        max = Math.max(root.val + left + right, max);
        return root.val + Math.max(left, right);
    }

}
