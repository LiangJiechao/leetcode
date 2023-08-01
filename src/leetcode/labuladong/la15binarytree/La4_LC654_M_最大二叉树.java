package leetcode.labuladong.la15binarytree;

/**
 * 给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
 * 创建一个根节点，其值为 nums 中的最大值。
 * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
 * 递归地在最大值 右边 的 子数组后缀上 构建右子树。
 * 返回 nums 构建的 最大二叉树 。
 *
 * @author xiaoliang
 * @date 2022/02/28 19:48
 **/
public class La4_LC654_M_最大二叉树 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int i, int j) {
        if (i > j) {
            return null;
        }
        int index = i;
        int max = nums[i];
        for (int k = i; k <= j; k++) {
            if (nums[k] > max) {
                max = nums[k];
                index = k;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = build(nums, i, index - 1);
        root.right = build(nums, index + 1, j);
        return root;
    }
}
