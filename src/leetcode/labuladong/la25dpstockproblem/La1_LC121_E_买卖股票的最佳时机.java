package leetcode.labuladong.la25dpstockproblem;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *
 * @author xiaoliang
 * @date 2022/04/27 09:10
 **/
public class La1_LC121_E_买卖股票的最佳时机 {

    public int maxProfit(int[] prices) {
        int n = prices.length;

        // dp[i][0] 表示第i天 没有持有 股票的最大利润
        // dp[i][i] 表示第i天 持有 股票的最大利润
        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {

            if (i - 1 == -1) {
                dp[i][0] = 0;
                // dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
                //          = Math.max(0,-inf+prices[i]);
                //          = 0
                dp[i][1] = -prices[i];
                // dp[i][0] = Math.max(dp[i-1][1],dp[i][0] - prices[i]);
                //          = Math.max(-inf,0 - prices[i]);
                //          = -prices[i]
                continue;
            }

            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1],  - prices[i]);
            // 这里是因为只能买卖一次，所以k=1，
            // 如果买一次后，k=0, 意味着根本不允许交易，这时候利润当然是 0。
        }
        return dp[n-1][0];
    }
}
