package recur;

import static recur.假设法_连续子数组的最大和.maxSubArray1;

/**
 * 求矩阵中子矩阵的最大累加和
 * 思路：
 * 分解： 3*3的矩阵
 * 求 包含 第0行，且只有第0行下的最大矩阵
 * 求 包含 第1行，且只有第0,1行下的最大矩阵
 * 求 包含 第2行，且只有第0,1,2行下的最大矩阵
 * 求 包含 第1行，且只有第1行下的最大矩阵
 * 求 包含 第1行，且只有第1,2行下的最大矩阵
 * 求 包含 第2行，且只有第2行下的最大矩阵
 *
 * @author xiaoliang
 * @date 2021/09/28 16:19
 **/
public class 假设法_矩阵中的子矩阵的最大和 {

    public static int maxSubMatrix(int[][] arr) {
        if (arr == null || arr[0] == null || arr.length == 0 || arr[0].length == 0) {
            throw new RuntimeException("参数错误");
        }

        int max = Integer.MIN_VALUE;

        for (int row = 0; row < arr.length; row++) {
            int[] sum = new int[arr[0].length];

            for (int i = row; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    sum[j] += arr[i][j];
                }
                max = Math.max(max, maxSubArray1(sum));
            }
        }

        return max;
    }

    public static int maxSubMatrix2(int[][] arr) {
        if (arr == null || arr[0] == null || arr.length == 0 || arr[0].length == 0) {
            throw new RuntimeException("参数错误");
        }

        int max = Integer.MIN_VALUE;
        int cur = 0;
        int[] sum = null;
        for (int row = 0; row < arr.length; row++) {
            sum = new int[arr[0].length];

            for (int i = row; i < arr.length; i++) {
                cur = 0;
                for (int j = 0; j < arr[i].length; j++) {
                    sum[j] += arr[i][j];
                    cur += sum[j];
                    max = Math.max(max, cur);
                    cur = cur < 0 ? 0 : cur;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = {{-5, 3, 6, 4},
                {-7, 9, -5, 3},
                {-10, 1, -200, 4}};
        int max = maxSubMatrix(matrix);
        System.out.println(max + " --- " + (max == maxSubMatrix2(matrix)));
    }

}
