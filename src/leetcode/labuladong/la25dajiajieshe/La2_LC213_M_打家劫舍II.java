package leetcode.labuladong.la25dajiajieshe;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
 * 这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/house-robber-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaoliang
 * @date 2022/09/24 11:36
 **/
public class La2_LC213_M_打家劫舍II {

    /**
     * 思路： 因为是环形，所以第一家和最后一家最多只能抢一家
     * 三种情况 ： （1）都不抢 （2）抢第一家 （3）抢最后一家
     * 情况（1）不用考虑，因为 （2）（3）的选择余地都包含了情况（1）
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int tmp = nums[0];
        nums[0] = 0;
        int res1 = robOne(nums);
        nums[0] = tmp;
        nums[n - 1] = 0;
        int res2 = robOne(nums);
        return Math.max(res1, res2);
    }

    public int robOne(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        // dp[i]表示前i家房子最多能偷
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            // dp[i-1] 不偷
            // dp[i-2]+nums[i] 偷
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }

}
