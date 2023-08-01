package leetcode.labuladong.la25dpstockproblem;

/**
 * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。​
 * <p>
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * <p>
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * 输入: prices = [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * 示例 2:
 * 输入: prices = [1]
 * 输出: 0
 *
 * @author xiaoliang
 * @date 2022/08/28 19:33
 **/
public class La3_LC309_M_最佳买卖股票时机含冷冻期 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        int cold = 1;

        for (int i = 0; i < n; i++) {

            if (i - 1 == -1) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            if(i - 1 - cold <= -1){
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
                //       = Math.max(dp[i - 1][1], dp[i - 1 - cold][0] - prices[i]);
                //       = Math.max(dp[i - 1][1], -prices[i]);
                continue;
            }
//            if (i - 2 == -1) {
//                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
//                dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
//                //       = Math.max(dp[i - 1][1], dp[i - 1 - cold][0] - prices[i]);
//                //       = Math.max(dp[i - 1][1], -prices[i]);
//                continue;
//            }

            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1 - cold][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}
