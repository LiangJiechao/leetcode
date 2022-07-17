package leetcode.labuladong.la31lca;

/**
 * @author xiaoliang
 * @date 2022/04/23 17:15
 **/
public class La4_LC235_E_二叉搜索树的最近公共祖先 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int val1 = Math.min(p.val,q.val);
        int val2 = Math.max(p.val,q.val);
        return find(root,val1,val2);
    }

    public TreeNode find(TreeNode root,int val1,int val2){
        if(root==null){
            return null;
        }

        if(root.val>val2){
            return find(root.left,val1,val2);
        }
        if(root.val<val1){
            return find(root.right,val1,val2);
        }
        // val1 <= root.val <= val2
        return root;

    }
}
