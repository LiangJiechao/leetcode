package leetcode;

/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * <p>
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 *
 * @author xiaoliang
 * @date 2021/11/29 16:58
 **/
public class 剑指Offer47_M_礼物的最大价值 {

    /**
     * 思路2：dp，dp[i][j]表示在该点时的最大价值
     * TODO 还可以继续优化为一维空间
     *
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        // 初始化dp数组
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        // 两重循环
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[row-1][col-1];
    }

    /**
     * 思路1：从左上角走到右下角，递归
     *
     * @param grid
     * @return
     */
    public int maxValue2(int[][] grid) {
        return recur(grid, 0, 0);
    }

    private int recur(int[][] grid, int row, int col) {

        // base case 到达终点了
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return grid[row][col];
        }
        int sum = grid[row][col];
        if (row == grid.length - 1) {
            return sum + recur(grid, row, col + 1);
        }
        if (col == grid[0].length - 1) {
            return sum + recur(grid, row + 1, col);
        }
        return sum + Math.max(recur(grid, row + 1, col), recur(grid, row, col + 1));
    }
}
