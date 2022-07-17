package leetcode.labuladong.la23dp;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 * @author xiaoliang
 * @date 2022/03/10 21:12
 **/
public class La5_LC53_M_最大子数组和 {

    // 这道题还可以压缩空间，也是用两个变量来记录，但不好写
    public int maxSubArray(int[] nums) {

        int n = nums.length;
        // dp[i]代表以i为结尾的最大子数组和
        int[] dp = new int[n];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = nums[i] + Math.max(0, dp[i - 1]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
