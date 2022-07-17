package leetcode.labuladong.la23dp;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 *
 * @author xiaoliang
 * @date 2022/03/10 20:34
 **/
public class La4_LC300_M_最长递增子序列LIS {

    /**
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {

        int n = nums.length;
        // dp[i]代表以长度为i+1的最长递增子序列，结尾最小的数
        int[] dp = new int[n];
        dp[0] = nums[0];
        int index = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] > dp[index]) {
                dp[++index] = nums[i];
            } else {
                // 在[0..index]中找到合适的位置，>=nums[i]的第一个数字的下标（位置）
                int left = 0;
                int right = index;
                int first = 0;
                while (left <= right) {
                    int mid = left + ((right - left) >> 1);
                    if (dp[mid] >= nums[i]) {
                        first = mid;
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                // 更新dp数组
                dp[first] = nums[i];

            }

        }
        return index + 1;
    }

    // 时间复杂度 O(n^2)
    public int lengthOfLIS2(int[] nums) {

        int n = nums.length;
        // dp[i]代表以nums[i]为结尾的最长子序列
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int res = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    res = Math.max(dp[i],res);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(new La4_LC300_M_最长递增子序列LIS().lengthOfLIS2(nums));
    }
}
