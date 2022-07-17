package leetcode.labuladong.binarytree;

/**
 * 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
 * 二叉树的根是数组 nums 中的最大元素。
 * 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
 * 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
 * 返回有给定数组 nums 构建的 最大二叉树 。
 *
 * @author xiaoliang
 * @date 2022/01/18 20:21
 **/
public class LC654_E_最大二叉树 {
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

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int i, int j) {

        if (i > j) {
            return null;
        }
        int index = i;
        int max = Integer.MIN_VALUE;
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
