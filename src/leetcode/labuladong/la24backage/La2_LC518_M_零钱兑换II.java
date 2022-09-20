package leetcode.labuladong.la24backage;

/**
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * <p>
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * <p>
 * 假设每一种面额的硬币有无限个
 * <p>
 * 输入：amount = 5, coins = [1, 2, 5]
 * 输出：4
 * 解释：有四种方式可以凑成总金额：
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * <p>
 * 1 <= coins.length <= 300
 * 1 <= coins[i] <= 5000
 * coins 中的所有值 互不相同
 * 0 <= amount <= 5000
 *
 * @author xiaoliang
 * @date 2022/03/12 11:02
 **/
public class La2_LC518_M_零钱兑换II {

    public int change(int amount, int[] coins) {

        // dp[i][j] 代表用前i种 coins去凑,当j元时，有多少种凑出的方法
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i <= coins.length; i++) {
            // 0元时能凑出一种
            dp[i][0] = 1;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[coins.length][amount];
    }

    // 压缩空间
    // 需要先遍历硬币，再遍历金额
    public int change2(int amount, int[] coins) {

        int[] dp = new int[amount + 1];
        // 当0元时，能凑出一种
        dp[0] = 1;

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] >= 0) {
                    dp[j] = dp[j] + dp[j - coins[i - 1]];
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int amount = 150;
        int[] coins = {1, 2, 5};
        System.out.println(new La2_LC518_M_零钱兑换II().change(amount, coins));
        System.out.println(new La2_LC518_M_零钱兑换II().change2(amount, coins));
    }

}
