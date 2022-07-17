package leetcode.labuladong.la15binarytree;

/**
 * @author xiaoliang
 * @date 2022/02/28 19:15
 **/
public class La1_LC226_翻转二叉树 {
    // 将整棵树的节点翻转
    TreeNode invertTree(TreeNode root) {
        // base case
        if (root==null){
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}
