package leetcode.labuladong.la31lca;

import java.util.HashSet;
import java.util.Set;

/**
 * 依然给你输入一棵不含重复值的二叉树，但这次不是给你输入p和q两个节点了，
 * 而是给你输入一个包含若干节点的列表nodes（这些节点都存在于二叉树中），
 * 让你算这些节点的最近公共祖先。
 *
 * @author xiaoliang
 * @date 2022/04/23 16:58
 **/
public class La2_LC1676_M_二叉树的最近公共祖先IV {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    // 输入nodes = [7,4,6]，那么函数应该返回节点5。
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {

        Set<Integer> values = new HashSet<>();
        for (TreeNode node : nodes) {
            values.add(node.val);
        }
        return find(root, values);
    }

    private TreeNode find(TreeNode root, Set<Integer> values) {

        if (root == null) {
            return null;
        }

        // 前序位置
        if (values.contains(root.val)) {
            return root;
        }

        TreeNode left = find(root.left, values);
        TreeNode right = find(root.right, values);

        // 后序位置，已经知道左右子树是否存在目标值
        if (left != null && right != null) {
            // 当前节点是 LCA 节点
            return root;
        }

        return left != null ? left : right;
    }

}