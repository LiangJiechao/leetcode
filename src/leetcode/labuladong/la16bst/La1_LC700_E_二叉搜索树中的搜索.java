package leetcode.labuladong.la16bst;

/**
 * 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
 * 你需要在 BST 中找到节点值等于 val 的节点。
 * 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
 *
 * @author xiaoliang
 * @date 2022/03/03 16:56
 **/
public class La1_LC700_E_二叉搜索树中的搜索 {

    public TreeNode searchBST(TreeNode root, int target) {
        if (root==null) {
            return null;
        }
        if (target < root.val){
            return searchBST(root.left,target);
        }else if(target > root.val){
            return searchBST(root.right,target);
        }else {
            // target == root.target
            return root;
        }
    }

}
