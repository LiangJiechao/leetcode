package leetcode;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 * <p>
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 *
 * @author xiaoliang
 * @date 2021/12/14 16:05
 **/
public class 剑指Offer68II_E_二叉树的最近公共祖先 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 思路：向左右子树找 p q
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 3种情况
        // 1.左右都不为空 如果p和q都在以root为根的树
        if (left != null && right != null) {
            return root;
        }
        // 2.左右都为null 如果p和q都不在以root为根的树中，直接返回null
        if (left == null && right == null) {
            return null;
        }
        // 3.如果p和q只有一个存在于root为根的树中
        return left == null ? right : left;
    }

}
