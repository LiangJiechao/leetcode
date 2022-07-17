package leetcode.dp;

/**
 * 泰波那契序列 Tn 定义如下： 
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 * <p>
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * <p>
 * 输入：n = 25
 * 输出：1389537
 * <p>
 * <p>
 * 分析：
 * 符合斐波那契套路，可以使用线性代数法， 得出[[1,1,0],[1,0,1],[1,0,0]]
 *
 * @author xiaoliang
 * @date 2021/10/22 17:35
 **/
public class LC1137_E_第N个泰波那契数 {

    /**
     * 分析：
     * 符合斐波那契套路，可以使用线性代数法， 得出[[1,1,0],[1,0,1],[1,0,0]]
     *
     * @param n
     * @return
     */
    public static int tribonacci2(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }
        return process2(n);
    }

    private static int process2(int n) {

        int[][] base = {{1, 1, 0}, {1, 0, 1}, {1, 0, 0}};

        int[][] matrix = fastPowMatrix(base, n - 2);

        return matrix[0][0] + matrix[1][0];
    }

    /**
     * 矩阵的快速幂
     *
     * @param base 底数，必须为 n*n矩阵
     * @param pow  幂数
     * @return
     */
    public static int[][] fastPowMatrix(int[][] base, int pow) {

        int[][] res = new int[base.length][base[0].length];
        // init 单位矩阵
        for (int i = 0; i < res.length; i++) {
            res[i][i] = 1;
        }

        while (pow != 0) {
            if ((pow & 1) != 0) { // pow%2==1
                res = matrixPow(res, base);
            }
            pow >>= 1; // pow/=2
            base = matrixPow(base, base);
        }
        return res;
    }

    public static int[][] matrixPow(int[][] a, int[][] b) {

        if (a == null || b == null || a.length != b[0].length) {
            throw new RuntimeException("参数错误");
        }
        int[][] c = new int[a.length][b[0].length];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

    public static int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }

        int a = 0, b = 1, c = 1;
        int temp;

        for (int i = 3; i <= n; i++) {
            temp = a;
            a = b;
            b = c;
            c = temp;
            c = a + b + c;
        }
        return c;
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 40; i++) {

            System.out.println(tribonacci(i) == tribonacci2(i));
        }
    }

}
