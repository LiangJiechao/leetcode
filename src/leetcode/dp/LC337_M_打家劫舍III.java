package leetcode.dp;

/**
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
 * <p>
 * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。
 * 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 * <p>
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaoliang
 * @date 2022/03/12 21:55
 **/
public class LC337_M_打家劫舍III {

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

    class ReturnData {
        int robSum;
        int notRobSum;

        public ReturnData(int robSum, int notRobSum) {
            this.robSum = robSum;
            this.notRobSum = notRobSum;
        }
    }

    public int rob(TreeNode root) {
        ReturnData r = traverse(root);
        return Math.max(r.robSum, r.notRobSum);
    }

    private ReturnData traverse(TreeNode root) {
        if (root == null) {
            return new ReturnData(0, 0);
        }

        ReturnData left = traverse(root.left);
        ReturnData right = traverse(root.right);

        // 虽然是树形递归，但有点难理解
        return new ReturnData(root.val + left.notRobSum + right.notRobSum,
                Math.max(left.robSum, left.notRobSum) + Math.max(right.robSum, right.notRobSum));

    }
}
