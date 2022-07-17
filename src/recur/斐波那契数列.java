package recur;

import static zuo.middleascension.class15.Class01_快速幂.fastPowMatrix;

/**
 * 递归实现斐波那契数列
 *
 * @author xiaoliang
 * @date 2021/09/17 11:56
 **/
public class 斐波那契数列 {

    // 1 1 2 3 5 8...
    public static int fib(int n) {

        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    // logN的方法，利用线性代数
    public static int fib2(int n) {

        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        int[][] base = {{1, 1}, {1, 0}};
        int[][] res = fastPowMatrix(base, n - 2);
        return res[0][0] + res[1][0];
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println("fib(30) = " + fib(30));
        long end1 = System.nanoTime();
        System.out.println("fib2(30) = " + fib2(30));
        long end2= System.nanoTime();

        System.out.println(end1-start);
        System.out.println(end2-end1);

    }
}
