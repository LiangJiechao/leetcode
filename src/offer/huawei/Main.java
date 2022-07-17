package offer.huawei;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），
 * 并返回该子数组所对应的乘积。
 *
 * 示例 1:
 * 输入: [2,3,-2,4]
 * 输出: [2,3] 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 *
 * 示例 2:
 * 输入: [-2,0,-1]
 * 输出: [0] 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * @author xiaoliang
 * @date 2022/04/07 19:33
 **/
public class Main {

    public static void main(String[] args) {
        int[] nums = {-2,0,-1};
        System.out.println(new Main().maxProduct(nums));
    }


    public int maxProduct(int[] nums){

        int len = nums.length;

        // dp[i][0] 代表 前i个元素的最大乘积
        // dp[i][1] 代表 前i个元素的最小乘积
        int[][] dp = new int[len][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int res = nums[0];

        for (int i = 1; i < len; i++) {
            int a = dp[i-1][0] * nums[i];
            int b = dp[i-1][1] * nums[i];

            dp[i][0] = Math.max(Math.max(a,b),nums[i]);
            dp[i][1] = Math.min(Math.min(a,b),nums[i]);
            res = Math.max(dp[i][0],res);
        }
        return res;
    }

}
