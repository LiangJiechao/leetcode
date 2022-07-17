package leetcode.labuladong.binarytree;

/**
 * 翻转一棵二叉树。
 * 示例：
 * 输入：
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * 输出：
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 *
 * @author xiaoliang
 * @date 2022/01/18 16:20
 **/
public class LC226_E_翻转二叉树 {
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




    /**
     * 思路：交换每个树的左右节点
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root==null){
            return null;
        }
        // 在先序的位置交换
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        /* 放在后序的位置也可以
        * TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        * */
        return root;
    }
}
