package leetcode;

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：一个机器人每次只能向下或者向右移动一步。
 *
 * @author xiaoliang
 * @date 2022/02/22 22:49
 **/
public class 剑指OfferII099_M_最小路径之和 {

    /**
     * 动态规划
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j != 0) {
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                } else if (i != 0 && j == 0) {
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                } else if (i != 0 && j != 0) {
                    dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 递归写法：超时
     *
     * @param grid
     * @return
     */
    public int minPathSum2(int[][] grid) {
        return process(grid, 0, 0);
    }

    private int process(int[][] grid, int i, int j) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }
        if (i == grid.length - 1) {
            return grid[i][j] + process(grid, i, j + 1);
        }
        if (j == grid[0].length - 1) {
            return grid[i][j] + process(grid, i + 1, j);
        }
        return grid[i][j] + Math.min(process(grid, i + 1, j), process(grid, i, j + 1));
    }

}
