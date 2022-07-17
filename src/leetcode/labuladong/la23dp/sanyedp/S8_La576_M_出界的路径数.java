package leetcode.labuladong.la23dp.sanyedp;

import java.util.Arrays;

/**
 * 给你一个大小为 m x n 的网格和一个球。球的起始坐标为 [startRow, startColumn] 。
 * 你可以将球移到在四个方向上相邻的单元格内（可以穿过网格边界到达网格之外）。你 最多 可以移动 maxMove 次球。
 * 给你五个整数 m、n、maxMove、startRow 以及 startColumn ，
 * 找出并返回可以将球移出边界的路径数量。
 * 因为答案可能非常大，返回对 109 + 7 取余 后的结果。
 * <p>
 * 输入：m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
 * 输出：6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/out-of-boundary-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaoliang
 * @date 2022/04/26 14:32
 **/
public class S8_La576_M_出界的路径数 {

    int[][][] memory;
    int mod = 1000000007;
    // dfs
    public int findPaths2(int m, int n, int maxMove, int startRow, int startColumn) {
        memory = new int[m][n][maxMove + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(memory[i][j], -1);
            }
        }

        return dfs(m, n, maxMove, startRow, startColumn);
    }

    private int dfs(int m, int n, int step, int startRow, int startColumn) {

        if (startRow < 0 || startRow >= m || startColumn < 0 || startColumn >= n) {
            return 1;
        }

        if (step <= 0) {
            return 0;
        }
        if (memory[startRow][startColumn][step] != -1) {
            return memory[startRow][startColumn][step];
        }
        // step > 0
        int count = 0;
        count = (count + dfs(m, n, step - 1, startRow - 1, startColumn)) % mod;
        count = (count + dfs(m, n, step - 1, startRow + 1, startColumn)) % mod;
        count = (count + dfs(m, n, step - 1, startRow, startColumn - 1)) % mod;
        count = (count + dfs(m, n, step - 1, startRow, startColumn + 1)) % mod;
        memory[startRow][startColumn][step] = count;
        return count;
    }

}
