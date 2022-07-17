package leetcode.labuladong.la23dp.sanyedp;

/**
 * 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
 * <p>
 * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。
 * 在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。
 * 具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
 * <p>
 * 输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
 * 输出：13
 * 解释：如图所示，为和最小的两条下降路径
 *
 * @author xiaoliang
 * @date 2022/04/26 14:38
 **/
public class S5_La931_M_下降路径最小和 {

    // 压缩空间
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = matrix[0][i];
        }
        int pre = dp[0];
        int tmp = pre;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    pre = dp[j];
                    dp[j] = matrix[i][j]+ Math.min(dp[j],dp[j+1]);
                }else if (j==n-1){
                    dp[j] = matrix[i][j]+ Math.min(dp[j],pre);
                }else {
                    tmp = dp[j];
                    dp[j] = matrix[i][j] + Math.min(dp[j], Math.min(dp[j + 1], pre));
                    pre = tmp;
                }
            }
        }

        int res = dp[0];
        for (int i = 0; i < n; i++) {
            res = Math.min(res, dp[i]);
        }
        return res;
    }

    public int minFallingPathSum2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                } else if (j == n - 1) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j + 1], dp[i - 1][j - 1]));
                }
            }
        }
        int res = dp[m - 1][0];
        for (int i = 0; i < n; i++) {
            res = Math.min(res, dp[m - 1][i]);
        }
        return res;
    }

}
