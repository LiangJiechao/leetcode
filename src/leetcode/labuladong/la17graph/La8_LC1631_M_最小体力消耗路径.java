package leetcode.labuladong.la17graph;

import java.util.*;

/**
 * 你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，
 * 其中 heights[row][col] 表示格子 (row, col) 的高度。一开始你在最左上角的格子 (0, 0) ，
 * 且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。
 * 你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
 * <p>
 * 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
 * <p>
 * 请你返回从左上角走到右下角的最小 体力消耗值 。
 * <p>
 * 输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
 * 输出：2
 * 解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
 * 这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
 *
 * @author xiaoliang
 * @date 2022/03/07 17:36
 **/
public class La8_LC1631_M_最小体力消耗路径 {

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        // effortTo[i][j] 表示 i,j 位置到 起点的最大消耗为 effortTo[i][j]
        int[][] effortTo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(effortTo[i], Integer.MAX_VALUE);
        }
        effortTo[0][0] = 0;

        Queue<State> queue = new PriorityQueue<>((o1, o2) -> o1.effortFromStart - o2.effortFromStart);
        queue.offer(new State(0, 0, effortTo[0][0]));

        while (!queue.isEmpty()) {
            State curState = queue.poll();
            int curX = curState.x;
            int curY = curState.y;
            int curEffortFromStart = curState.effortFromStart;

            if (curEffortFromStart > effortTo[curX][curY]) {
                continue;
            }

            List<int[]> neighbor = getNeighbor(heights, curState.x, curState.y);
            for (int[] item : neighbor) {
                int nextX = item[0];
                int nextY = item[1];
                int effortToNextNode = Math.max(effortTo[curX][curY],
                        Math.abs(heights[curX][curY] - heights[nextX][nextY]));

                // 更新 dp table
                if (effortTo[nextX][nextY] > effortToNextNode) {
                    effortTo[nextX][nextY] = effortToNextNode;
                    queue.offer(new State(nextX, nextY, effortToNextNode));
                }
            }

        }
        return effortTo[m - 1][n - 1];
    }

    private List<int[]> getNeighbor(int[][] matrix, int x, int y) {
        int m = matrix.length, n = matrix[0].length;
        int[] direction = {-1, 0, 1, 0, -1};// 四个方向

        List<int[]> neighbor = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            int nx = x + direction[i];
            int ny = y + direction[i + 1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                // 越界
                continue;
            }
            neighbor.add(new int[]{nx, ny});
        }
        return neighbor;
    }

     class State {
        int x;
        int y;
        int effortFromStart;

        public State(int x, int y, int effortFromStart) {
            this.x = x;
            this.y = y;
            this.effortFromStart = effortFromStart;
        }
    }

    public static void main(String[] args) {
        int[][] height = {{1,2,2},{3,8,2},{5,3,5}};
        System.out.println(new La8_LC1631_M_最小体力消耗路径().minimumEffortPath(height));
    }

}
