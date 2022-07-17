package leetcode;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 *
 * @author xiaoliang
 * @date 2021/11/07 17:27
 **/
public class LC300_M_最长递增子序列 {

    /**
     * 思路：改变一下dp数组的意义，
     * dp[i]代表长度为i+1的，结尾的最小的数字
     *
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int index = 0;
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > dp[index]) {
                dp[++index] = nums[i];
            } else {
                int left = 0;
                int right = index;

                // 二分法找到大于nums[i]的下标位置，然后用nums[i]替换该位置
                int first = 0;
                // dp[i] 长度为i+1的结尾的最小的数字变为nums[i]
                while (left <= right) {
                    int mid = left + ((right - left) >> 1);
                    if (dp[mid] >= nums[i]) {
                        first = mid;
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                dp[first] = nums[i];
            }

        }
        return index + 1;
    }

    /**
     * 思路：看到子序列、子数组或子串问题，就想以i为结尾的情况下会怎么怎么样
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            // 在i位置往前看，看谁是你小的数，在比你小的数中选择长度最长的，再加1就是以你结尾的最大递增长度
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
    }
}
