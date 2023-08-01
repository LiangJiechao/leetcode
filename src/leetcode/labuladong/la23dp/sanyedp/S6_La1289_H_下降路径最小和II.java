package leetcode.labuladong.la23dp.sanyedp;

/**
 * 给你一个 n x n 整数矩阵 arr ，请你返回 非零偏移下降路径 数字和的最小值。
 * 非零偏移下降路径 定义为：从 arr 数组中的每一行选择一个数字，且按顺序选出来的数字中，相邻数字不在原数组的同一列。
 * <p>
 * 输入：arr = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：13
 *
 * @author xiaoliang
 * @date 2022/04/26 14:32
 **/
public class S6_La1289_H_下降路径最小和II {

    // m*m
    public int minFallingPathSum(int[][] grid) {
        int m = grid.length;

        int[][] dp = new int[m][m];

        for (int i = 0; i < m; i++) {
            dp[0][i] = grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < m; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < m; k++) {
                    if (k != j) {
                        min = Math.min(min, dp[i-1][k]);
                    }
                    dp[i][j] = grid[i][j] + min;
                }
            }
        }

        int res = dp[m - 1][0];
        for (int i = 0; i < m; i++) {
            res = Math.min(res, dp[m - 1][i]);
        }
        return res;
    }
}
