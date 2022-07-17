package leetcode.labuladong.la25dpstockproblem;

/**
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * 在每一天，你可以决定是否购买和/或出售股票。`你在任何时候 最多 只能持有 一股 股票。`
 * 你也可以先购买，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润 。
 *
 * 输入：prices = [7,1,5,3,6,4]
 * 输出：7
 *
 * @author xiaoliang
 * @date 2022/04/27 09:40
 **/
public class La2_LC122_M_买卖股票的最佳时机II {

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
            have[i] = Math.max(have[i-1], no[i-1] - prices[i]); // 唯一不同之处
            no[i] = Math.max(no[i-1], prices[i] + have[i-1]);
        }
        return no[len - 1];
    }

}
