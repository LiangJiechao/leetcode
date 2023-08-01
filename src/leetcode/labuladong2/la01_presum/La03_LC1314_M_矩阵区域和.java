package leetcode.labuladong2.la01_presum;

/**
 * https://leetcode.cn/problems/matrix-block-sum/
 *
 * @author liangjiechao
 * @date 2023/05/14 17:45
 **/
public class La03_LC1314_M_矩阵区域和 {

    public int[][] matrixBlockSum(int[][] mat, int k) {

        int m = mat.length;
        int n = mat[0].length;
        NumMatrix numMatrix = new NumMatrix(mat);
        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int x1 = Math.max(0, i - k);
                int y1 = Math.max(0, j - k);

                int x2 = Math.min(i + k, m - 1);
                int y2 = Math.min(j + k, n - 1);

                res[i][j] = numMatrix.sumRegion(x1, y1, x2, y2);
            }
        }
        return res;
    }

    class NumMatrix {

        int[][] presum;

        public NumMatrix(int[][] matrix) {
            int row = matrix.length;
            int col = matrix[0].length;

            presum = new int[row + 1][col + 1];

            for (int i = 1; i <= row; i++) {
                for (int j = 1; j <= col; j++) {
                    presum[i][j] = presum[i][j - 1] + presum[i - 1][j] - presum[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return presum[row2 + 1][col2 + 1] - presum[row1][col2 + 1] - presum[row2 + 1][col1] + presum[row1][col1];
        }
    }
}
