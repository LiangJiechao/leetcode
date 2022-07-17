package changkao.zijie;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author xiaoliang
 * @date 2022/03/29 16:59
 **/
public class LC103_M_二叉树的锯齿形层序遍历 {
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

        /**
         * 树中节点数目在范围 [0, 2000] 内
         * 思路：bst
         *
         * @param root
         * @return
         */
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new LinkedList<>();
            if (root == null) {
                return res;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            // flag 标志是顺序还是逆序
            boolean flag = true;
            while (!queue.isEmpty()) {
                int size = queue.size();
                LinkedList<Integer> track = new LinkedList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    if (flag) {
                        track.addLast(poll.val);
                    } else {
                        track.addFirst(poll.val);
                    }
                    if (poll.left != null) {
                        queue.offer(poll.left);
                    }
                    if (poll.right != null) {
                        queue.offer(poll.right);
                    }
                }
                res.add(track);
                flag = !flag;
            }
            return res;
        }
    }
}
