package leetcode.labuladong.binarytree;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。
 * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 * 这条路径可能穿过也可能不穿过根结点。
 *    1
 *   / \
 *   2   3
 *  / \
 * 4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 * @author xiaoliang
 * @date 2022/01/16 15:01
 **/
public class LC543_E_二叉树的直径 {
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

    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        maxDepth(root);
        return maxDiameter;
    }

    // 当前节点的最长距离 = max(左子树的最长距离，右子树的最长距离，左子树最大深度+右子树最大深度+1)
    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        // 当前节点的距离 = 当前节点左的深度+当前节点右的深度
        maxDiameter = Math.max(maxDiameter, left + right);

        return Math.max(left, right) + 1;

    }
}
