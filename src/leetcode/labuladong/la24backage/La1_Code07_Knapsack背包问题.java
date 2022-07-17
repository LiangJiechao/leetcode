package leetcode.labuladong.la24backage;

import static zuo.base.class06.Code07_Knapsack背包问题.maxValue1;

/**
 * 暴力递归：背包问题，选形式最简单的。参数越少的实现方式去实现
 * 给定两个长度都为N的数组weights和values，
 * weights[i]和values[i]分别代表 i号物品的重量和价值。
 * 给定一个正数bag，表示一个载重bag的袋子，你装的物品不能超过这个重量。
 * 返回你能装下最多的价值是多少？
 *
 * @author xiaoliang
 * @date 2021/09/16 16:15
 **/
public class La1_Code07_Knapsack背包问题 {



    public static int maxValue2(int[] weights, int[] values, int bag) {
        return process2(weights, values, 0, bag);
    }

    private static int process2(int[] weights, int[] values, int i, int bag) {

        // base case
        if (i == weights.length || bag <= 0) {
            return 0;
        }
        int a = process2(weights, values, i + 1, bag);
        int b = bag - weights[i] >= 0 ?
                values[i] + process2(weights, values, i + 1, bag - weights[i])
                : 0;
        return Math.max(a, b);
    }

    public static int maxValue3(int[] weights, int[] values, int bag) {
        return process3(weights, values, bag);
    }

    /**
     * 动态规划法
     *
     * @param weights
     * @param values
     * @param bag
     * @return
     */
    private static int process3(int[] weights, int[] values, int bag) {

        int[][] dp = new int[bag + 1][weights.length + 1];
        for (int i = 1; i <= bag; i++) {
            for (int j = 1; j <= weights.length; j++) {
                if (i >= weights[j - 1]) {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - weights[j - 1]][j - 1] + values[j - 1]);
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[bag][weights.length];
    }

    public static void main(String[] args) {
        int[] weights = {8, 3, 2, 4, 7, 1};
        int[] values = {5, 3, 6, 3, 19, 3};
        int bag = 13;
        System.out.println(maxValue1(weights, values, bag));
        System.out.println(maxValue2(weights, values, bag));
        System.out.println(maxValue3(weights, values, bag));
    }
}
