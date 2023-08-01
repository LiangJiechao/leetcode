package leetcode.labuladong.la23dp;

import java.util.Arrays;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 *
 * @author xiaoliang
 * @date 2022/03/10 19:47
 **/
public class La2_LC322_M_零钱兑换 {




    public int coinChange(int[] coins, int amount) {
        // dp[i] 代表 i元的时候，最少需要几个硬币组成
        int[] dp = new int[amount + 1];
        // 为啥不直接初始化为 int 型的最⼤值 Integer.MAX_VALUE 呢？
        // 因为后⾯有 dp[i - coin] + 1，这就会导致整型溢出。
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];

    }

    public static void main(String[] args) {
        int[] nums = {5,2,4};
        int amount = 12;
        System.out.println(new La2_LC322_M_零钱兑换().coinChange(nums, amount));
    }

}
