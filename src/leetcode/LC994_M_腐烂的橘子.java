package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 * <p>
 * 输入：[[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * <p>
 * 输入：[[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 *
 * @author xiaoliang
 * @date 2021/10/28 20:16
 **/
public class LC994_M_腐烂的橘子 {

    /**
     * BFS 记录层数
     *
     * @param grid
     * @return
     */
    public static int orangesRotting(int[][] grid) {

        if (grid == null) {
            throw new RuntimeException("参数错误");
        }

        Queue<int[]> queue = new LinkedList<>();
        int count = 0;// 记录新鲜的个数
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        int level = 0;
        int[] direction = {-1, 0, 1, 0, -1};
        while (!queue.isEmpty() && count > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int x = cur[0] + direction[j];
                    int y = cur[1] + direction[j + 1];
                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0 || grid[x][y] == 2) {
                        continue;
                    }
                    // grid[x][y] ==1
                    count--;
                    grid[x][y] = 2;
                    queue.offer(new int[]{x, y});
                }
            }
            level++;
        }
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                // 表示还有新鲜的
//                if (grid[i][j] == 1) {
//                    return -1;
//                }
//            }
//        }
        return count == 0 ? level : -1;
    }

    public static void main(String[] args) {
        int[][] arr = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(orangesRotting(arr));
    }
}
