package leetcode.dp;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
 * 这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 *
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 *
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 输入：nums = [0]
 * 输出：0
 *
 * @author xiaoliang
 * @date 2021/10/25 16:37
 **/
public class LC213_M_打家劫舍II {

    public static int rob(int[] nums) {
        if (nums==null||nums.length==0) {
            throw new RuntimeException("参数错误");
        }
        if (nums.length==1){
            return nums[0];
        }else if (nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        int temp = nums[0];
        nums[0] = 0;
        int a = robOne(nums);
        nums[0] = temp;

        temp = nums[nums.length-1];
        nums[nums.length-1] = 0;
        int b = robOne(nums);
        nums[nums.length-1] = temp;
        return Math.max(a,b);
    }

    /**
     * 动态规划
     *
     * @param arr
     * @return
     */
    public static int robOne(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new RuntimeException("参数错误");
        }

        if (arr.length == 1) {
            return arr[0];
        } else if (arr.length == 2) {
            return Math.max(arr[0], arr[1]);
        }

        int[] dp = new int[arr.length];
        // init
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);

        }
        return dp[arr.length - 1];
    }


    public static void main(String[] args) {
        int [] arr = {2,3,2};
        System.out.println(rob(arr));
    }
}
