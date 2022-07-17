package recur;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 示例1: 输入: nums = [-2,1,-3,4,-1,2,1,-5,4] 输出: 6 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * @author xiaoliang
 * @date 2021/09/23 17:53
 **/
public class 假设法_连续子数组的最大和 {

    // todo 连续子数组的最大和
    // 用两个变量完成
    public static int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new RuntimeException("参数错误");
        }

        int cur = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            cur += nums[i];
            max = max < cur ? cur : max;
            cur = cur < 0 ? 0 : cur;
        }
        return max;
    }

    // todo 连续子数组的最大和
    public static int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int sum = dp[0];
        // dp[i] 表示 i位置上的数 及 前面的数 能组成的最大正数
        for (int i = 1; i < nums.length; i++) {
            // nums[i - 1] 有两种情况，>0 或 <0
            // 求最大值，只需保留大于0的部分
            dp[i] = Math.max(dp[i - 1], 0) + nums[i];
            sum = Math.max(sum, dp[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("maxSubArray1(nums) = " + maxSubArray1(nums));
        int[] nums2 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("maxSubArray2(nums) = " + maxSubArray2(nums2));
    }
}
