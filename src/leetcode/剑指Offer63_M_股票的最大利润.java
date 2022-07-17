package leetcode;

/**
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * @author xiaoliang
 * @date 2021/11/29 16:22
 **/
public class 剑指Offer63_M_股票的最大利润 {

    /**
     * 思路：遍历数组，先找小的数，然后看后面加入有比他大的数，就计算加入这天卖出的利润
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length < 2) {
            return 0;
        }

        int minNum = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minNum) {
                minNum = prices[i];
            } else {
                maxProfit = Math.max(prices[i] - minNum, maxProfit);
            }
        }
        return maxProfit;
    }

}
