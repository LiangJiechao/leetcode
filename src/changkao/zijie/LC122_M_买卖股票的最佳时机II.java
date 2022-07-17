package changkao.zijie;

/**
 * 给定一个数组 prices ，其中 prices[i] 表示股票第 i 天的价格。
 * <p>
 * 在每一天，你可能会决定购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以购买它，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润 。
 * <p>
 * 输入: prices = [7,1,5,3,6,4]
 * 输出: 7
 *
 * @author xiaoliang
 * @date 2022/03/30 09:24
 **/
public class LC122_M_买卖股票的最佳时机II {

    public int maxProfit(int[] prices) {

        if (prices.length < 2) {
            return 0;
        }
        // dp[i][0]表示第i天持有的现金
        // dp[i][1]表示第i天持有的股票
        int[][] dp = new int[prices.length + 1][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i <= prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1]);

        }
        return dp[dp.length - 1][0];
    }

}
