package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 输出：[3,9,20,15,7]
 *
 * @author xiaoliang
 * @date 2021/11/27 12:18
 **/
public class 剑指Offer32I_M_从上到下打印二叉树 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 思路：使用队列
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        if (root==null) {
            return new int[]{};
        }
        List<Integer> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            list.add(poll.val);
            if (poll.left!=null){
                queue.add(poll.left);
            }
            if (poll.right!=null){
                queue.add(poll.right);
            }
        }
        int[] res = list.stream().mapToInt(Integer::intValue).toArray();
        return res;
    }
}
