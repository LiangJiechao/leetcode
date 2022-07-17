package leetcode.labuladong.la15binarytree;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。
 * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 * 这条路径可能穿过也可能不穿过根结点。
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 * @author xiaoliang
 * @date 2022/01/16 15:01
 **/
public class La11_LC543_E_二叉树的直径 {

    int maxDiameter = 0;

    /**
     * 求直径，因为要用到子树的信息，所以逻辑代码写在后序位置
     *
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        traverse(root);
        return maxDiameter;
    }

    private int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = traverse(root.left);
        int right = traverse(root.right);

        // 本节点的最大距离 = left + right
        maxDiameter = Math.max(maxDiameter, left + right);

        // 返回为本节点深度
        return Math.max(left, right) + 1;
    }

}
