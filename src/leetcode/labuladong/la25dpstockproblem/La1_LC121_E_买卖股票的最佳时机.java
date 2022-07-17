package leetcode.labuladong.la25dpstockproblem;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *
 * @author xiaoliang
 * @date 2022/04/27 09:10
 **/
public class La1_LC121_E_买卖股票的最佳时机 {


    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int[] have = new int[len];  // 表示第i天持有股票所得最多现金
        int[] no = new int[len];    // 表示第i天不持有股票所得最多现金
        have[0] = -prices[0]; // 此时的持有股票就一定是买入股票了
        no[0] = 0;            // 不持有股票那么现金就是0

        for (int i = 1; i < len; i++) {
            have[i] = Math.max(have[i-1], -prices[i]);
            no[i] = Math.max(no[i-1], prices[i] + have[i-1]);
        }
        return no[len - 1];
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(new La1_LC121_E_买卖股票的最佳时机().maxProfit(prices));
    }



    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n+1];
        int preMin = prices[0];

        for (int i = 1; i <= n; i++) {
            preMin = Math.min(preMin,prices[i-1]);
            dp[i] = Math.max(dp[i - 1], prices[i - 1] - preMin);
        }
        return dp[dp.length - 1];

    }
}
