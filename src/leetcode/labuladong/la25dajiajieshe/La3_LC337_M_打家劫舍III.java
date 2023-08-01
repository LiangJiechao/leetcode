package leetcode.labuladong.la25dajiajieshe;

/**
 * 第三题又想法设法地变花样了，此强盗发现现在面对的房子不是一排，不是一圈，
 * 而是一棵二叉树！房子在二叉树的节点上，相连的两个房子不能同时被抢劫：
 * @author xiaoliang
 * @date 2022/09/24 11:57
 **/
public class La3_LC337_M_打家劫舍III {

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

    public int rob(TreeNode root) {
        int[] res = dp(root);
        return Math.max(res[0], res[1]);
    }

    /* 返回一个大小为 2 的数组 arr
        arr[0] 表示不抢 root 的话，得到的最大钱数
        arr[1] 表示抢 root 的话，得到的最大钱数 */
    private int[] dp(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = dp(root.left);
        int[] right = dp(root.right);

        int rob = root.val + left[0] + right[0];
        int norob = 0 + Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{norob, rob};
    }
}
