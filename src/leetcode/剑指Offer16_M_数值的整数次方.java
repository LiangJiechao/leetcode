package leetcode;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，
 * 同时不需要考虑大数问题。
 * <p>
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 *
 * @author xiaoliang
 * @date 2021/12/15 17:35
 **/
public class 剑指Offer16_M_数值的整数次方 {

    /**
     * 思路：快速幂
     * 1.00000 -2147483648 为了应对这种边界情况，因为int 的范围[-2147483648,2147483647]，所以要先除2，后再乘2，
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow2(double x, int n) {

        if (n == 0 || x == 1.0) {
            return 1.0;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1.0 / x;
        }

        //Java 代码中 int32 变量 n in [-2147483648, 2147483647]
        // 因此当 n = -2147483648 时执行 n = -n 会因越界而赋值出错。
        // 解决方法是先将 n 存入 long 变量 b ，后面用 b 操作即可。
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        // 把pow化成二进制，能看出1的位置是包含在结果的
        // 如 5的13次方 ==>  13 = 1101  ==>  等于  5的1次方 * 5的4次方 * 5的8次方
        while (b != 0) {
            if ((b & 1) == 1) {
                res *= x;
            }
            b >>= 1;
            x *= x;
        }

        return res;
    }



    public static void main(String[] args) {

        factorialTailRecursive(15);

    }

    private static long factorNormal(long n) {
        return n == 1 ? n : n * factorNormal(n - 1);
    }

    static long factorialTailRecursive(long n) {
        return factorialHelper(1, n);
    }

    private static long factorialHelper(long acc, long n) {
        // 未来可以优化栈帧，只用一个
        return n == 1 ? acc : factorialHelper(acc * n, n - 1);
    }
}
