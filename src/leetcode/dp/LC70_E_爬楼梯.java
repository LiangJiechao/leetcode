package leetcode.dp;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * <p>
 * 输入： 2
 * 输出： 2
 * <p>
 * 输入： 3
 * 输出： 3
 *
 * @author xiaoliang
 * @date 2021/10/25 14:58
 **/
public class LC70_E_爬楼梯 {


    /**
     * 表格型动态规划
     *
     * @param n
     * @return
     */
    public static int climbStairs3(int n) {
        if (n < 0) {
            throw new RuntimeException("参数错误");
        }
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 记忆化递归
     *
     * @param n
     * @return
     */
    public static int climbStairs2(int n) {
        if (n < 0) {
            throw new RuntimeException("参数错误");
        }
        int[] dp = new int[n + 1];

        return process2(n, dp);
    }

    private static int process2(int n, int[] dp) {
        if (n <= 2) {
            return n;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = process2(n - 1, dp) + process2(n - 2, dp);
        return dp[n];
    }

    /**
     * 暴力递归
     *
     * @param n
     * @return
     */
    public static int climbStairs1(int n) {
        if (n < 0) {
            throw new RuntimeException("参数错误");
        }
        return process1(n);
    }

    private static int process1(int n) {
        if (n <= 2) {
            return n;
        }
        return process1(n - 1) + process1(n - 2);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(i+" --- "+climbStairs1(i));
        }

    }

}
