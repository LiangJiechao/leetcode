package leetcode;

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * <p>
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaoliang
 * @date 2022/03/01 21:44
 **/
public class LC98_M_验证二叉搜索树 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

    }

    class ReturnData {
        boolean isBst;
        long min;
        long max;

        public ReturnData(boolean isBst, long min, long max) {
            this.isBst = isBst;
            this.min = min;
            this.max = max;
        }
    }

    public boolean isValidBST(TreeNode root) {

        ReturnData data = traverse(root);
        return data.isBst;
    }

    private ReturnData traverse(TreeNode root) {
        if (root == null) {
            // 空节点，肯定满足bst，有个测试用例为long
            return new ReturnData(true, Long.MAX_VALUE, Long.MIN_VALUE);
        }

        ReturnData left = traverse(root.left);
        ReturnData right = traverse(root.right);
        boolean isBst = false;
        long min = Integer.MAX_VALUE;// 这里可以随便写，不重要了，因为isBst为false
        long max = Integer.MIN_VALUE;
        if (left.isBst && right.isBst && root.val > left.max && root.val < right.min) {
            isBst = true;
            min = Math.min(left.min, root.val);
            max = Math.max(root.val, right.max);
        }

        return new ReturnData(isBst, min, max);
    }

    // 第二种写法，用中序遍历
    public boolean isValidBST2(TreeNode root) {

        return isValid(root);
    }

    TreeNode pre = null;

    private boolean isValid(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isValid(root.left);
        if (pre != null && pre.val >= root.val) {
            return false;
        }
        pre = root;
        boolean right = isValid(root.right);
        return left && right;
    }


}
