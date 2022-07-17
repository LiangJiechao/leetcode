package leetcode.labuladong.la24backage;

/**
 * 做dp题目时，
 * 像La1_01背包问题，La3_LC416_M_分割等和子集，物品不能重复，dp转换时，
 * dp[i][j] = Math.max(dp[i - 1][j], `dp[i - 1]`[j - weights[i - 1]] + values[i - 1]);
 * dp[i][j] = dp[i - 1][j] || `dp[i - 1]`[j - nums[i - 1]];
 * 压缩空间时：
 * 唯⼀需要注意的是 j 应该从后往前反向遍历，因为每个物品（或者说数字）只能⽤⼀次，以免之前的结果影响其他的结果。
 *
 * 像La2_LC518_M_零钱兑换II，硬币可重复使用，dp转换时 dp[i][j] = dp[i - 1][j] + `dp[i]`[j - coins[i - 1]];
 * @author xiaoliang
 * @date 2022/03/12 20:14
 **/
public class La0_DPTemplate {
}
