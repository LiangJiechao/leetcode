package leetcode;

/**
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 * 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 * <p>
 * 输入：grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 输出：6
 * 解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
 * <p>
 * [[1,1,0,0,0],
 * [1,1,0,0,0],
 * [0,0,0,1,1],
 * [0,0,0,1,1]]
 *
 * @author xiaoliang
 * @date 2021/10/26 18:01
 **/
public class LC695_M_岛屿的最大面积 {

    /**
     * 计算岛屿的最大面积
     *
     * @param grid
     * @return
     */
    public static int maxAreaOfIsland(int[][] grid) {
        if (grid == null) {
            throw new RuntimeException("参数错误");
        }
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, process(grid, i, j));
                }
            }
        }
        return max;
    }

    private static int process(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != 1) {
            return 0;
        } else {
            // 改标记
            grid[row][col] = 2;
            // 进入这里，本来就是一个格子，所以count初始化为1
            int count = 1;
            count += process(grid, row - 1, col);
            count += process(grid, row + 1, col);
            count += process(grid, row, col - 1);
            count += process(grid, row, col + 1);
            return count;
        }
    }

    /**
     * 计算岛屿的数量
     *
     * @param grid
     * @return
     */
    public static int countOfIsland(int[][] grid) {
        if (grid == null) {
            throw new RuntimeException("参数错误");
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res++;
                    infect(grid, i, j);
                }
            }
        }
        return res;
    }

    private static void infect(int[][] grid, int row, int col) {

        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != 1) {
            return;
        }
        grid[row][col] = 2;
        infect(grid, row - 1, col);
        infect(grid, row + 1, col);
        infect(grid, row, col - 1);
        infect(grid, row, col + 1);
    }

    public static void main(String[] args) {
//        int[][] arr = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
//                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
//                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        int[][] arr = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        System.out.println(maxAreaOfIsland(arr));
        System.out.println(arr);

    }

}
