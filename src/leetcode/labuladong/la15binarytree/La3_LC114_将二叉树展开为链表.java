package leetcode.labuladong.la15binarytree;

/**
 * 
 * @author xiaoliang
 * @date 2022/02/28 19:26
 **/
public class La3_LC114_将二叉树展开为链表 {

    // 定义：将以 root 为根的树拉平为链表
    void flatten(TreeNode root) {
        if (root==null){
            return;
        }

        flatten(root.left);
        flatten(root.right);

        if (root.left==null) {
            return;
        }

        TreeNode mostRight = root.left;
        while (mostRight.right!=null){
            mostRight = mostRight.right;
        }
        mostRight.right = root.right;

        root.right = root.left;
        root.left = null;

    }

}
