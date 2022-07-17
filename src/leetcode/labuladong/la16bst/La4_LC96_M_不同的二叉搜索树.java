package leetcode.labuladong.la16bst;

/**
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？
 * 返回满足题意的二叉搜索树的种数。
 * 输入：n = 3
 * 输出：5
 * @author xiaoliang
 * @date 2022/03/06 11:17
 **/
// 等同于 不同二叉树的形状
public class La4_LC96_M_不同的二叉搜索树 {


    // 动态规划
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] =1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // dp[j] * dp[i-1-j]; == 左 * 右
                dp[i] += dp[j] * dp[i-1-j];
            }
        }

        return dp[n];
    }



    int[][] memory;
    public int numTrees2(int n) {
        memory = new int[n + 1][n + 1];
        return count(1, n);
    }

    /**
     * 返回 [log,high]有多少种情况
     *
     * @param low
     * @param high
     * @return
     */
    private int count(int low, int high) {
        if (low > high) {
            // 即为空节点的情况
            return 1;
        }

        if (memory[low][high] != 0) {
            return memory[low][high];
        }

        int res = 0;
        // 以i为根节点有多少种可能
        for (int i = low; i <= high; i++) {
            int left = count(low, i - 1);
            int right = count(i + 1, high);
            // 左右子树的组合数乘积是 BST 的总数
            res += left * right;
        }

        memory[low][high] = res;
        return res;

    }

}
