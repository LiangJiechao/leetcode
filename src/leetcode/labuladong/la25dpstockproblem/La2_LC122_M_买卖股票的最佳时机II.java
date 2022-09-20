package leetcode.labuladong.la25dpstockproblem;

/**
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * 在每一天，你可以决定是否购买和/或出售股票。`你在任何时候 最多 只能持有 一股 股票。`
 * 你也可以先购买，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润 。
 * <p>
 * 输入：prices = [7,1,5,3,6,4]
 * 输出：7
 *
 * @author xiaoliang
 * @date 2022/04/27 09:40
 **/
public class La2_LC122_M_买卖股票的最佳时机II {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {

            if (i - 1 == -1) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }

            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            // 这里可以买卖多次，即k最大可以等于天数
        }
        return dp[n - 1][0];
    }

}
