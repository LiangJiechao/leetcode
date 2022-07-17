package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 * @author xiaoliang
 * @date 2021/11/05 11:03
 **/
public class LC94_E_二叉树的中序遍历 {

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

    /**
     * 二叉树的中序遍历，非递归版
     * 用栈：
     * 1、先把头节点的所有左节点依次进栈
     * 2、弹出/处理，把该节点的右节点 按 1循环
     *
     * @param root
     */
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (root.left != null) {
            root = root.left;
            stack.push(root);
        }

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            result.add(pop.val);
            if (pop.right != null) {
                pop = pop.right;
                stack.push(pop);
                while (pop.left != null) {
                    pop = pop.left;
                    stack.push(pop);
                }
            }
        }
        return result;
    }
}
