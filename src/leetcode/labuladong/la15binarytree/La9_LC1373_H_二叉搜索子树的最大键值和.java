package leetcode.labuladong.la15binarytree;

/**
 * 给你一棵以 root 为根的 二叉树 ，请你返回 任意 二叉搜索子树的最大键值和。
 * 二叉搜索树的定义如下：
 * 任意节点的左子树中的键值都 小于 此节点的键值。
 * 任意节点的右子树中的键值都 大于 此节点的键值。
 * 任意节点的左子树和右子树都是二叉搜索树。
 *
 * @author xiaoliang
 * @date 2022/02/28 22:17
 **/
public class La9_LC1373_H_二叉搜索子树的最大键值和 {

    int maxSumBST = 0;

    public int maxSumBST(TreeNode root) {

        traverse(root);

        return maxSumBST;
    }

    /**
     * 根据以上三点，站在当前节点的视⻆，需要知道以下具体信息：
     * 1、左右⼦树是否是 BST。
     * 2、左⼦树的最⼤值和右⼦树的最⼩值。
     * 3、左右⼦树的节点值之和。
     *
     * @param root
     * @return
     */
    private ReturnData traverse(TreeNode root) {

        if (root == null) {
            return new ReturnData(true, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }

        ReturnData leftData = traverse(root.left);
        ReturnData rightData = traverse(root.right);

        boolean isBST = false;
        int max = 0;
        int min = 0;
        int sum = 0;
        if (leftData.isBST && rightData.isBST && root.val > leftData.max && root.val < rightData.min) {
            isBST = true;
            max = Math.max(root.val, rightData.max);
            min = Math.min(root.val, leftData.min);
            sum = leftData.sum + rightData.sum + root.val;

            maxSumBST = Math.max(sum, maxSumBST);
        }

        return new ReturnData(isBST, max, min, sum);

    }

    class ReturnData {
        boolean isBST;
        int max;
        int min;
        int sum;

        public ReturnData(boolean isBST, int max, int min, int sum) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
            this.sum = sum;
        }
    }

}
