package leetcode;

/**
 * 给定一个`二叉搜索树`, 找到该树中两个指定节点的最近公共祖先。
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * <p>
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 *
 * @author xiaoliang
 * @date 2021/12/14 15:56
 **/
public class 剑指Offer68I_E_二叉搜索树的最近公共祖先 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 思路：因为是搜索二叉树，所以可以用值来比较
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        /*
        (p.val <= root.val && q.val >= root.val) ||
                (q.val <= root.val && p.val >= root.val)
        */
        return root;
    }
}
