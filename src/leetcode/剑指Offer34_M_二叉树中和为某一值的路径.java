package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，
 * 找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：[]
 *
 * @author xiaoliang
 * @date 2021/12/07 21:43
 **/
public class 剑指Offer34_M_二叉树中和为某一值的路径 {

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

    public List<List<Integer>> pathSum(TreeNode root, int target) {

        List<List<Integer>> res = new LinkedList<>();
        List<Integer> temp = new LinkedList<>();
        dfs(root, target, temp, res);
        return res;
    }

    private void dfs(TreeNode root, int target, List<Integer> temp, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        temp.add(root.val);
        dfs(root.left, target - root.val, temp, res);
        dfs(root.right, target - root.val, temp, res);

        // 回溯前判断
        if (root.left == null && root.right == null && target == root.val) {
            res.add(new ArrayList<>(temp));
        }
        // 还原
        temp.remove(temp.size() - 1);

    }

    public List<List<Integer>> pathSum2(TreeNode root, int target) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new LinkedList<>();
        List<TreeNode> temp = new LinkedList<>();
        dfs2(root, 0, target, temp, res);
        return res;
    }

    private void dfs2(TreeNode root, int sum, int target, List<TreeNode> temp, List<List<Integer>> res) {

        sum += root.val;
        temp.add(root);

        if (root.left == null && root.right == null) {
            if (sum == target) {
                List<Integer> collect = temp.stream().map(item -> item.val).collect(Collectors.toList());
                res.add(collect);
            }
        } else {
            if (root.left != null) {
                dfs2(root.left, sum, target, temp, res);
            }
            if (root.right != null) {
                dfs2(root.right, sum, target, temp, res);
            }
        }

        sum -= root.val;
        temp.remove(root);
    }
}
