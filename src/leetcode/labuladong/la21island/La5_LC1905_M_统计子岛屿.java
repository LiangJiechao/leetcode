package leetcode.labuladong.la21island;

/**
 * 给你两个 m x n 的二进制矩阵 grid1 和 grid2 ，
 * 它们只包含 0 （表示水域）和 1 （表示陆地）。
 * 一个 岛屿 是由 四个方向 （水平或者竖直）上相邻的 1 组成的区域。
 * 任何矩阵以外的区域都视为水域。
 * <p>
 * 如果 grid2 的一个岛屿，被 grid1 的一个岛屿 完全 包含，
 * 也就是说 grid2 中该岛屿的每一个格子都被 grid1 中同一个岛屿完全包含，
 * 那么我们称 grid2 中的这个岛屿为 子岛屿 。
 * <p>
 * 请你返回 grid2 中 子岛屿 的 数目 。
 * <p>
 * https://leetcode-cn.com/problems/count-sub-islands/
 *
 * @author xiaoliang
 * @date 2022/03/09 19:38
 **/
public class La5_LC1905_M_统计子岛屿 {

    /**
     * 思路：先让grid1中的海对应grid2中的陆地淹没掉
     * 剩下的就是符合的岛屿
     *
     * @param grid1
     * @param grid2
     * @return
     */
    public int countSubIslands(int[][] grid1, int[][] grid2) {

        int m = grid1.length;
        int n = grid1[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid1[i][j] == 0 && grid2[i][j] == 1) {
                    dfs(grid1, grid2, i, j);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    dfs(grid1, grid2, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grid1, int[][] grid2, int i, int j) {

        if (i < 0 || i >= grid2.length || j < 0 || j >= grid2[0].length || grid2[i][j] != 1) {
            return;
        }

        grid2[i][j] = 0;

        dfs(grid1, grid2, i + 1, j);
        dfs(grid1, grid2, i - 1, j);
        dfs(grid1, grid2, i, j + 1);
        dfs(grid1, grid2, i, j - 1);
    }

}
