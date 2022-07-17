package leetcode.labuladong.la24backage;

import java.util.Arrays;

/**
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 *
 * @author xiaoliang
 * @date 2022/03/12 20:01
 **/
public class La3_LC416_M_分割等和子集 {

    /**
     * 思路：可以看作背包问题
     * 先判断nums的总和sum是否能被2整除
     * 将背包大小设为sum/2，看是否能完成将背包恰好用完
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if ((sum & 1) != 0) {
            return false;
        }
        sum = sum / 2;

        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        for (int i = 0; i <= nums.length; i++) {
            // 当背包容量全部用完时，为true
            dp[i][0] = true;
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - nums[i - 1] >= 0) {
                    // 这里用 ||的原因时存在有true的可能就行，即有可能装到0，无论是装与不装
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[nums.length][sum];
    }

    // 压缩空间
    public boolean canPartition2(int[] nums) {

        int sum = Arrays.stream(nums).sum();
        if ((sum & 1) != 0) {
            return false;
        }
        sum = sum / 2;

        boolean[] dp = new boolean[sum + 1];
        // 当背包容量全部用完时，为true
        dp[0] = true;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = sum; j >= 1; j--) {
                if (j - nums[i - 1] >= 0) {
                    // 这里用 ||的原因时存在有true的可能就行，即有可能装到0，无论是装与不装
                    // 唯⼀需要注意的是 j 应该从后往前反向遍历，因为每个物品（或者说数字）只能用一次，以免之前的结果影响其他的结果。
                    dp[j] = dp[j] || dp[j - nums[i - 1]];
                }
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5};
        System.out.println(new La3_LC416_M_分割等和子集().canPartition(nums));
    }

}
