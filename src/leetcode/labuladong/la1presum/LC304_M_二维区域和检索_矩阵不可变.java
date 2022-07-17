package leetcode.labuladong.la1presum;

/**
 * 给定一个二维矩阵 matrix，以下类型的多个请求：
 * 计算其子矩形范围内元素的总和，该子矩阵的 左上角 为 (row1, col1) ，右下角 为 (row2, col2) 。
 * 实现 NumMatrix 类：
 * <p>
 * NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化
 * int sumRegion(int row1, int col1, int row2, int col2) 
 * 返回 左上角 (row1, col1) 、右下角 (row2, col2) 所描述的子矩阵的元素 总和 。
 *
 * @author xiaoliang
 * @date 2022/02/23 15:54
 **/
public class LC304_M_二维区域和检索_矩阵不可变 {

    /**
     * 思路：前缀和
     */
    class NumMatrix {
        private int[][] presum;

        public NumMatrix(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            presum = new int[m + 1][n + 1];

            for (int i = 1; i < presum.length; i++) {
                for (int j = 1; j < presum[0].length; j++) {
                    // 计算每个矩阵 [0, 0, i, j] 的元素和
                    presum[i][j] = presum[i - 1][j] + presum[i][j - 1] + matrix[i - 1][j - 1] - presum[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            // 2 1 4 3
            // (4,3) - (1,3) - (4,0) +(1,0)

            return presum[row2 + 1][col2 + 1] - presum[row1][col2 + 1] - presum[row2 + 1][col1] + presum[row1][col1];
        }
    }

}
