package leetcode;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。
 * 求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 * <p>
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * @author xiaoliang
 * @date 2021/11/29 16:34
 **/
public class 剑指Offer42_E_连续子数组的最大和 {

    /**
     * 子数组问题，思考以i结尾会怎么怎么样
     * dp[i] 表示以i结尾会怎么怎么样
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int tempSum = 0;
        int max = nums[0];
        for (int num : nums) {
            tempSum = Math.max(tempSum + num, 0);
            max = Math.max(tempSum, max);
        }
        return max;
    }
}
