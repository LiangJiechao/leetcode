package leetcode.labuladong.la31lca;

/**
 * 给你输入一棵不含重复值的二叉树的，以及两个节点p和q，
 * 如果p或q不存在于树中，则返回空指针，
 * 否则的话返回p和q的最近公共祖先节点。
 * @author xiaoliang
 * @date 2022/04/23 17:06
 **/
public class La3_LC1644_M_二叉树的最近公共祖先II {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 用于记录 p 和 q 是否存在于二叉树中
    boolean foundP = false, foundQ = false;

    TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = find(root, p.val, q.val);
        if (!foundP || !foundQ) {
            return null;
        }
        // p 和 q 都存在二叉树中，才有公共祖先
        return res;
    }

    private TreeNode find(TreeNode root, int val1, int val2) {

        if (root==null){
            return null;
        }

        TreeNode left = find(root.left, val1, val2);
        TreeNode right = find(root.right, val1, val2);

        // 后序位置，判断当前节点是不是目标值
        if (root.val == val1){
            foundP = true;
            return root;
        }
        if (root.val == val2){
            foundQ = true;
            return root;
        }

        return left != null ? left : right;
    }
}
