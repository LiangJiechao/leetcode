package offer.tengxun.t5;

import java.util.Scanner;

/**
 * 作者：AFU(OvO)
 * 链接：https://www.nowcoder.com/discuss/940915?type=post&order=create&pos=&page=1&ncTraceId=&channel=-1&source_id=search_post_nctrack&gio_id=24B388B3E038C6EC048F97CF747D6AA7-1650937823795
 * <p>
 * 作者：miao的测试
 * 链接：https://www.nowcoder.com/discuss/940859?type=post&order=create&pos=&page=3&ncTraceId=&channel=-1&source_id=search_post_nctrack&gio_id=24B388B3E038C6EC048F97CF747D6AA7-1650941635010
 * 来源：牛客网
 * <p>
 * 题目:
 * 现在有一个长度为n的价格数组a，表示某只股票 每天的 价格，
 * 你每天最多买入或卖出该只股票的1手股票，买入或者卖出没有手续费，
 * 且卖出股票前必须手里已经有股票才能卖出，
 * 但是持有的股票数目不受限制，并且初始资金为m元，
 * 你在任意时刻都不能进行透支，所以你的资金必须始终大于等于 0 。
 * 请问你在n天结束之后，拥有最大的总资产是多少?（总资产:股票数目*股票价格+现金)
 * 输入
 * 6 2
 * 2 3 1 1 1 2
 * 输出:
 * 6
 * <p>
 * <p>
 * 思路：动态规划，设dp[i][j]为第i天持有j个股票能拥有的最大现金额度，
 * dp[i][j]  = Math.min(dp[i-1][j] , dp[i][j+1] +prices[i] , dp[i][j-1]-prices[i])
 * <p>
 * 01背包变种。定义dp[i][j]代表前i天，手上当前持有j只股票的最大现金数。
 * 那么可以根据每天选择买入还是卖出达成转移。
 *
 * @author xiaoliang
 * @date 2022/04/24 19:56
 **/
public class Main {

    /**
     * 6 2
     * 2 3 1 1 1 2
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }
        long dp[][] = new long[n][n];//dp[i][j] 表示在第i天拥有j注股票的最大资产 ,n天最多n-1支股票
        dp[0][0] = m;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                //持有不动的情况
                dp[i][j] = dp[i - 1][j];
                //如果j大于0而且前一天的现金数目大于今天的股票价格，
                // 即股票数目大于0有可能是持有不动或者买入1只股票转化而来的状态
                if (j > 0 && dp[i - 1][j - 1] >= prices[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] - prices[i]);
                }
                // 前一天卖出一只股票和持有不动，哪个现金数目更多
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j + 1] + prices[i]);
            }
        }

        long res = 0;
//        for (int i = 0; i < n; i++) {
//            res = Math.max(res, dp[n][i] + i * prices[n]);
//        }
        System.out.println(res);
    }

}
