package leetcode;

/**
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 * <p>
 * 输入:
 * Tree 1                     Tree 2
 * 1                         2
 * / \                       / \
 * 3   2                     1   3
 * /                           \   \
 * 5                             4   7
 * 输出:
 * 合并后的树:
 * 3
 * / \
 * 4   5
 * / \   \
 * 5   4   7
 *
 * @author xiaoliang
 * @date 2021/10/26 19:15
 **/
public class LC617_E_合并二叉树 {

    static class TreeNode {
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

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) {
            return null;
        } else if (root1 != null && root2 == null) {
            return root1;
        } else if (root1 == null && root2 != null) {
            return root2;
        }
        return process(root1,root2);
    }

    private static TreeNode process(TreeNode root1, TreeNode root2) {
        TreeNode head = null;
        if (root1 != null && root2 != null) {
            head = new TreeNode(root1.val + root2.val);
            head.left = process(root1.left, root2.left);
            head.right = process(root1.right, root2.right);
        } else if (root1 != null && root2 == null) {
            head = new TreeNode(root1.val);
            head.left = process(root1.left, null);
            head.right = process(root1.right, null);
        } else if (root1 == null && root2 != null) {
            head = new TreeNode(root2.val);
            head.left = process(null, root2.left);
            head.right = process(null, root2.right);
        }
        return head;
    }

}
