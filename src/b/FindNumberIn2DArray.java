package b;

/**
 * @author xiaoliang
 * @version 1.0
 * @description: 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @date 2021/6/24 17:33
 */
public class FindNumberIn2DArray {

    public boolean findNumberIn2DArray(int target, int[][] matrix) {
        //基本思路从左下角开始找，这样速度最快
        int row = matrix.length - 1;
        int col = 0;

        while ((row >= 0) && (col < matrix[0].length)) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean findNumberIn2DArray2(int target, int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        //从右上角开始查找
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] > target) {
                col--;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                return true;
            }
        }
        return false;
    }
}
