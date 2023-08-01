package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
 * 两个相邻元素间的距离为 1 。
 * mat 中至少有一个 0
 * 输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：[[0,0,0],[0,1,0],[0,0,0]]
 * <p>
 * 输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
 * 输出：[[0,0,0],[0,1,0],[1,2,1]]
 *
 * @author xiaoliang
 * @date 2021/10/27 09:28
 **/
public class LC542_M_01矩阵 {

    /**
     * BFS
     * 1.遍历原数组的0，放入目标数组，并放入队列 q
     * 2.遍历队列 q，取出这个点，操作其上下左右四个方向
     * 3.如果操作了，这个点放入 q
     * 4.执行到结束
     *
     * @param matrix
     * @return
     */
    public static int[][] updateMatrix(int[][] matrix) {

        // 数组是对象
        Queue<int[]> queue = new LinkedList<>();

        // 把所有0的位置都放进队列
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    // 便于统一处理
                    matrix[i][j] = -1;
                }
            }
        }

        int level = 1;
        // 四个方向
        int[] direction = {-1, 0, 1, 0, -1};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                // 四个方向走一次
                for (int j = 0; j < 4; j++) {
                    int x = cur[0] + direction[j];
                    int y = cur[1] + direction[j + 1];
                    if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] >= 0) {
                        continue;
                    }
                    matrix[x][y] = level;
                    queue.offer(new int[]{x, y});
                }
            }
            level++;
        }
        return matrix;
    }
}
