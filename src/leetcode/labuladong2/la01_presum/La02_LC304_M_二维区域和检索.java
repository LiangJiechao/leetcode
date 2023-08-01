package leetcode.labuladong2.la01_presum;

/**
 * https://leetcode.cn/problems/range-sum-query-2d-immutable/
 * @author liangjiechao
 * @date 2023/05/14 17:24
 **/
public class La02_LC304_M_二维区域和检索 {

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

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */

}
