package leetcode.labuladong.la24backage;


/**
 * 给你⼀个可装载重量为 W 的背包和 N 个物品，每个物品有重量和价值两个属性。
 * 其中第 i 个物品的重量为 wt[i]，价值为 val[i]，现在让你⽤这个背包装物品，最多能装的价值是多少？
 *
 * @author xiaoliang
 * @date 2022/03/11 21:27
 **/
public class La1_01背包问题 {

    public int knapsack(int bag, int[] weights, int[] values) {

        int[][] dp = new int[weights.length + 1][bag + 1];

        for (int i = 1; i <= weights.length; i++) {
            for (int j = 1; j <= bag; j++) {

                if (j - weights[i - 1] >= 0) {
                    // 当放入了第 i个物品后，剩下的重量是当前i-1个物品时的重量
                    // `dp[i - 1]`[j - weights[i - 1]] + values[i - 1]这里i-1是因为物品不可重复
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }

        }
        return dp[weights.length][bag];
    }

    public static void main(String[] args) {
        int[] weights = {8, 3, 2, 4, 7, 1};
        int[] values = {5, 3, 6, 3, 19, 3};
        int bag = 13;
        System.out.println(new La1_01背包问题().knapsack(bag, weights, values));
    }
}
