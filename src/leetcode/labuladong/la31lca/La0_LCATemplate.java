package leetcode.labuladong.la31lca;

/**
 * LCA（Lowest Common Ancestor）作为最近公共祖先节点的缩写
 * @author xiaoliang
 * @date 2022/04/23 16:40
 **/
public class La0_LCATemplate {

    // 这种适合所给节点一定存在树中时使用，不会每个节点都遍历
    // 定义：在以 root 为根的二叉树中寻找值为 val 的节点
//    TreeNode find(TreeNode root, int val) {
//        // base case
//        if (root == null) {
//            return null;
//        }
//        // 看看 root.val 是不是要找的
//        if (root.val == val) {
//            return root;
//        }
//        // root 不是目标节点，那就去左子树找
//        TreeNode left = find(root.left, val);
//        if (left != null) {
//            return left;
//        }
//        // 左子树找不着，那就去右子树找
//        TreeNode right = find(root.right, val);
//        if (right != null) {
//            return right;
//        }
//        // 实在找不到了
//        return null;
//    }



// 这种适合节点不一定存在时使用，因为会遍历树中每一个节点
//    TreeNode find(TreeNode root, int val) {
//        if (root == null) {
//            return null;
//        }
//        // 先去左右子树寻找
//        TreeNode left = find(root.left, val);
//        TreeNode right = find(root.right, val);
//        // 后序位置，判断 root 是不是目标节点
//        if (root.val == val) {
//            return root;
//        }
//        // root 不是目标节点，再去看看哪边的子树找到了
//        return left != null ? left : right;
//    }
}
