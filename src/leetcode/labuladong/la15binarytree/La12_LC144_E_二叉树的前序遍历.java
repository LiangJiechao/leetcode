package leetcode.labuladong.la15binarytree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author xiaoliang
 * @date 2022/03/01 11:15
 **/
public class La12_LC144_E_二叉树的前序遍历 {

    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        traverse(root, res);

        return res;
    }

    private void traverse(TreeNode root, LinkedList<Integer> res) {

        if (root == null) {
            return;
        }
        res.add(root.val);
        traverse(root.left, res);
        traverse(root.right, res);
    }

    public List<Integer> preorderTraversal3(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root==null){
            return res;
        }
        res.add(root.val);
        res.addAll(preorderTraversal3(root.left));
        res.addAll(preorderTraversal3(root.right));
        return res;
    }


    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            res.add(pop.val);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
        return res;
    }

}
