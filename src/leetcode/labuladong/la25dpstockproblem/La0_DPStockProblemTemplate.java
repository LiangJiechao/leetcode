package leetcode.labuladong.la25dpstockproblem;

/**
 * dp问题下的
 * 股票问题：
 * 121. 买卖股票的最佳时机（简单）
 * 122. 买卖股票的最佳时机 II（简单）
 * 123. 买卖股票的最佳时机 III（困难）
 * 188. 买卖股票的最佳时机 IV（困难）
 * 309. 最佳买卖股票时机含冷冻期（中等）
 * 714. 买卖股票的最佳时机含⼿续费（中等）
 *
 * @author xiaoliang
 * @date 2022/03/12 20:30
 **/
public class La0_DPStockProblemTemplate {

    // 模板

    /**
     * 输入股票价格数组 prices，
     * 你最多进行 max_k 次交易，
     * 每次交易需要额外消耗 fee 的手续费，
     * 而且每次交易之后需要经过 cooldown 天的冷冻期才能进行下一次交易，
     * 请你计算并返回可以获得的最大利润。
     *
     * @param max_k
     * @param prices
     * @param cooldown
     * @param fee
     * @return
     */
    public int maxProfit_all_in_one(int max_k, int[] prices, int cooldown, int fee) {
        int n = prices.length;
        if (n <= 0) {
            return 0;
        }
        int maxk = max_k >= n ? n / 2 : max_k;
        int[][][] dp = new int[n][maxk + 1][2];

        for (int i = 0; i < n; i++) {
            for (int k = maxk; k >= 1; k--) {

                if (i - 1 == -1) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i] - fee;
                    continue;
                }
                // if (i - cooldown - 1 < 0) {
                if (i - 1 - cooldown <= -1) {
                    dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                    dp[i][k][1] = Math.max(dp[i - 1][k][1], -prices[i] - fee);
                    //          = Math.max(dp[i-1][k][1],dp[i-cooldown-1][k-1][0] - prices[i] - fee);
                    //          = Math.max(dp[i-1][k][1],dp[-1][k-1][0] - prices[i] - fee);
                    //          = Math.max(dp[i-1][k][1],0 - prices[i] - fee);
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1 - cooldown][k - 1][0] - prices[i] - fee);

            }
        }
        return dp[n - 1][maxk][0];
    }

}
