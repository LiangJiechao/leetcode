package leetcode;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。
 * 所有 Node.val 互不相同 。
 * p != q
 * p 和 q 均存在于给定的二叉树中。
 *
 * @author xiaoliang
 * @date 2021/11/06 11:33
 **/
public class LC236_M_二叉树的最近公共祖先 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class ReturnData {
        TreeNode res;
        boolean findA;
        boolean findB;

        public ReturnData(TreeNode node, boolean findA, boolean findB) {
            this.res = node;
            this.findA = findA;
            this.findB = findB;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        ReturnData result = process(root, p, q);
        return result.res;
    }

    /**
     * 分两种情况，
     * 1是两个节点需要汇聚才有公共祖先
     * 2是两个节点互为公共祖先
     *
     * @param head
     * @param node1
     * @param node2
     * @return
     */
    private ReturnData process(TreeNode head, TreeNode node1, TreeNode node2) {

        if (head == null) {
            return new ReturnData(null, false, false);
        }

        ReturnData leftData = process(head.left, node1, node2);
        ReturnData rightData = process(head.right, node1, node2);

        // 要返回的信息
        TreeNode res = null;
        boolean findA = leftData.findA || rightData.findA || head == node1;
        boolean findB = leftData.findB || rightData.findB || head == node2;

        if (leftData.res!=null){
            // 左子树中找到了两个节点，即找到答案了，并不断往上传
            res = leftData.res;
        }else if (rightData.res!=null){
            // 右子树中找到了两个节点
            res = rightData.res;
        }else {
            if (findA&&findB){
                // 只有找到两个了，才能为res赋值
                res = head;
            }
        }
        return new ReturnData(res, findA, findB);
    }
}
