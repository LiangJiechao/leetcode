package leetcode.labuladong.la21island;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 * 输入：grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * 输出：3
 *
 * @author xiaoliang
 * @date 2021/11/07 12:25
 **/
public class La1_LC200_M_岛屿数量 {

    /**
     * BFS
     *
     * @param grid
     * @return
     */
    public static int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    bfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private static void bfs(char[][] grid, int i, int j) {


        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            i = poll[0];
            j = poll[1];
            if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == '1') {
                grid[i][j] = '2';
                queue.offer(new int[]{i-1,j});
                queue.offer(new int[]{i+1,j});
                queue.offer(new int[]{i,j-1});
                queue.offer(new int[]{i,j+1});
            }
        }
    }

    /**
     * DFS
     *
     * @param grid
     * @return
     */
    public static int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    infect(grid, i, j);
                }
            }
        }
        return res;
    }

    private static void infect(char[][] grid, int i, int j) {
        // base case
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        // 将该块淹没
        grid[i][j] = '0';
        // 将上下左右 淹没
        infect(grid, i - 1, j);
        infect(grid, i + 1, j);
        infect(grid, i, j - 1);
        infect(grid, i, j + 1);
    }

    public static void main(String[] args) {
        char[][] arr = {{'1', '1', '0'}, {'0', '0', '0'}, {'0', '1', '1'}};
        System.out.println(numIslands2(arr));
    }
}
