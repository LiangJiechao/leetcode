package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * 例如:
 * 给定的树 A:
 *     3
 *    / \
 *   4   5
 *  / \
 * 1   2
 * 给定的树 B：
 *   4
 *  /
 * 1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 * <p>
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 *
 * @author xiaoliang
 * @date 2021/11/27 15:14
 **/
public class 剑指Offer26_M_判断树的子结构 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        if (check(A, B)) {
            return true;
        }
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean check(TreeNode A, TreeNode B) {

        // base case
        if (B == null) {
            return true;
        }
        // 若A为空B不为空 或者 A.val != B.val
        if (A == null || A.val != B.val) {
            return false;
        }
        return check(A.left, B.left) && check(A.right, B.right);
    }

    /**
     * 思路：先找到A中与B头节点的位置，然后遍历B,同时A也采用相同的遍历方式，对比遍历结果
     *
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure1(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }

        List<TreeNode> headList = findHead(A, B);
        if (headList.size() == 0) {
            return false;
        }

        for (TreeNode head : headList) {
            boolean check = check1(B, head);
            if (check) {
                return true;
            }
        }
        return false;
    }

    private boolean check1(TreeNode B, TreeNode head) {
        // 对比 headList中每个head 与 B 的结构
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(B);
        queue.offer(head);
        while (!queue.isEmpty()) {
            TreeNode poll1 = queue.poll();
            TreeNode poll2 = queue.poll();
            if (poll1.val != poll2.val) {
                return false;
            }
            if (poll1.left != null) {
                if (poll2.left != null) {
                    queue.offer(poll1.left);
                    queue.offer(poll2.left);
                } else {
                    return false;
                }
            }
            if (poll1.right != null) {
                if (poll2.right != null) {
                    queue.offer(poll1.right);
                    queue.offer(poll2.right);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private List<TreeNode> findHead(TreeNode A, TreeNode B) {

        // 处理存在多个头相同的情况
        List<TreeNode> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(A);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.val == B.val) {
                list.add(poll);
            }
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }
        return list;
    }
}
