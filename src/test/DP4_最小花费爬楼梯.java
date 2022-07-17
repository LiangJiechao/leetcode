package test;

import java.util.Scanner;

/**
 * @author xiaoliang
 * @date 2022/05/01 10:05
 **/
public class DP4_最小花费爬楼梯 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = scanner.nextInt();
        }
        int res = lowestCost(n, cost);
        System.out.println(res);
    }

    private static int lowestCost(int n, int[] cost) {
        int first = 0;
        int second = 0;
        int third = 0;

        for (int i = 2; i <= n; i++) {
            third = Math.min(first + cost[i-2],second+cost[i-1]);
            first = second;
            second= third;
        }
        return third;
    }

    private static int lowestCost2(int n, int[] cost) {
        if (n == 1) {
            return 0;
        }

        // dp[i] 表示跳上第i级台阶，最少需要多少花费
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }
        return dp[n];
    }
}
