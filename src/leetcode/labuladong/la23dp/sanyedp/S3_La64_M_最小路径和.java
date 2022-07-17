package leetcode.labuladong.la23dp.sanyedp;

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 *
 * @author xiaoliang
 * @date 2022/04/26 14:38
 **/
public class S3_La64_M_最小路径和 {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + grid[0][i - 1];
        }
        dp[0] = Integer.MAX_VALUE;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[j] = dp[j - 1] < dp[j] ? dp[j - 1] + grid[i][j - 1] : dp[j] + grid[i][j - 1];
            }
        }
        return dp[n];
    }
}
