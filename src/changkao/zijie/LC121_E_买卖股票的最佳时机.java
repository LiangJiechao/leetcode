package changkao.zijie;

/**
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 *
 * @author xiaoliang
 * @date 2022/03/29 16:58
 **/
public class LC121_E_买卖股票的最佳时机 {

    /**
     * 输入：[7,1,5,3,6,4]
     * 输出：5
     * 1 <= prices.length <= 105
     * 0 <= prices[i] <= 104
     * <p>
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        int[] dp = new int[prices.length + 1];
        int preMin = Integer.MAX_VALUE;
        for (int i = 1; i <= prices.length; i++) {
            preMin = Math.min(preMin, prices[i - 1]);
            dp[i] = Math.max(dp[i - 1], prices[i - 1] - preMin);
        }
        return dp[dp.length - 1];
    }
}
