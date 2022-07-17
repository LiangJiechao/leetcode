package zuo.middleascension.class15;

import java.util.Arrays;

import static zuo.middleascension.class15.Class01_快速幂.fastPowMatrix;

/**
 * 农场有一头牛，牛能生牛，但小牛要3年才成熟
 * 问n年后农场上有多少头牛
 * 年份 1 2 3 4 5 6
 * 牛数 1 2 3 4 6 9
 * 得出 f(n)=f(n-1)+f(n-3)
 * 因为得出 除了初始项外，后面每一项都有严格的递归式 的问题 ==> 可以应用斐波那契套路
 * 让时间复杂度变为 O(logN)
 * <p>
 * 解得矩阵为 m={ {1,1,0},
 * {0,0,1},
 * {1,0,0} }
 * 所以 |f(n) f(n-1) f(n-2)| = |f(3) f(2) f(1)|*m^n-3
 *
 * @author xiaoliang
 * @date 2021/09/27 16:52
 **/
public class Class02_农场上牛的数量 {

    /**
     * 斐波那契套路写法
     * 让时间复杂度变为 O(logN)
     *
     * @param n
     * @return
     */
    public static int cowNum2(int n) {
        if (n < 1) {
            throw new RuntimeException("参数错误");
        }
        return process2(n);
    }

    private static int process2(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 3;
        }

        int[][] base = {{1, 1, 0}, {0, 0, 1}, {1, 0, 0}};

        int[][] res = fastPowMatrix(base, n - 3);
        return 3 * res[0][0] + 2 * res[1][0] + res[2][0];
    }

    /**
     * 递归写法
     *
     * @param n
     * @return
     */
    public static int cowNum1(int n) {
        if (n < 1) {
            throw new RuntimeException("参数错误");
        }
        int[] memory = new int[n + 1];
        Arrays.fill(memory, -1);
        memory[0] = 0;
        memory[1] = 1;
        memory[2] = 2;
        memory[3] = 3;
        return process1(n, memory);
    }

    private static int process1(int n, int[] memory) {
        if (memory[n] != -1) {
            return memory[n];
        }
        memory[n] = process1(n - 1, memory) + process1(n - 3, memory);
        return memory[n];
    }

    public static void main(String[] args) {
        System.out.println("cowNum1(6) = " + cowNum1(30));
        System.out.println("cowNum2(6) = " + cowNum2(30));

    }

}
