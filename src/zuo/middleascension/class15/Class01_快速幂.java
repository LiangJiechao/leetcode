package zuo.middleascension.class15;

/**
 * @author xiaoliang
 * @date 2021/09/27 15:46
 **/
public class Class01_快速幂 {

    public static int fastPow(int base, int pow) {

        int res = 1;
        while (pow != 0) {
            // 把pow化成二进制，能看出1的位置是包含在结果的
            // 如 5的13次方 ==>  13 = 1101  ==>  等于  5的1次方 * 5的4次方 * 5的8次方
            if ((pow & 1) != 0) { // pow%2==1
                res *= base;
            }
            pow >>= 1; // pow/=2;
            base *= base;
        }
        return res;
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

    public static void main(String[] args) {
        System.out.println("fastPow(2,5) = " + fastPow(2, 5));

        int[][] a = {{1, 2, 3}, {4, 5, 6}};
        int[][] b = {{1, 4}, {2, 5}, {3, 6}};
//        int[][] c = matrixPow(a, b);
//        for (int i = 0; i < c.length; i++) {
//            for (int j = 0; j < c[0].length; j++) {
//                System.out.print(c[i][j] + " ");
//            }
//            System.out.println();
//        }
    }
}
