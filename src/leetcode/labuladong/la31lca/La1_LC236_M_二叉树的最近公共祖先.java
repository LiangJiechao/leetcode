package leetcode.labuladong.la31lca;

/**
 * @author xiaoliang
 * @date 2022/04/23 16:57
 **/
public class La1_LC236_M_二叉树的最近公共祖先 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find(root, p.val, q.val);
    }

    public TreeNode find(TreeNode root, int val1, int val2) {
        if (root == null) {
            return null;
        }

        // 前序位置
        if (root.val == val1 || root.val == val2) {
            // 如果遇到目标值，直接返回
            return root;
        }

        TreeNode left = find(root.left, val1, val2);
        TreeNode right = find(root.right, val1, val2);

        // 后序位置，已经知道左右子树是否存在目标值
        if (left != null && right != null) {
            // 当前节点是 LCA 节点
            return root;
        }

        return left != null ? left : right;
    }
}
