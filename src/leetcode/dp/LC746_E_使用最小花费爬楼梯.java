package leetcode.dp;

/**
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
 * 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
 * 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 * <p>
 * 输入：cost = [10, 15, 20]
 * 输出：15
 * 解释：最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15 。
 * <p>
 * 输入：cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出：6
 * 解释：最低花费方式是从 cost[0] 开始，逐个经过那些 1 ，跳过 cost[3] ，一共花费 6 。
 *
 * @author xiaoliang
 * @date 2021/10/25 15:36
 **/
public class LC746_E_使用最小花费爬楼梯 {

    /**
     * 动态规划
     *
     * @param cost
     * @return
     */
    public static int minCostClimbingStairs3(int[] cost) {
        if (cost == null || cost.length == 0) {
            throw new RuntimeException("参数错误");
        }
        // dp[i]代表到达i+1级楼梯，最少花费
        int[] dp = new int[cost.length];
        // init dp[]
        if (cost.length == 1) {
            return 0;
        } else if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < cost.length; i++) {
            if (i == cost.length - 1) {
                dp[i] = Math.min(dp[i - 1], dp[i - 2] + cost[i]);
            } else {
                dp[i] = Math.min(dp[i - 1] + cost[i], dp[i - 2] + cost[i]);
            }
        }
        return dp[cost.length - 1];
    }

    /**
     * 记忆化递归
     *
     * @param cost
     * @return
     */
    public static int minCostClimbingStairs2(int[] cost) {
        if (cost == null || cost.length == 0) {
            throw new RuntimeException("参数错误");
        }
        int[] dp = new int[cost.length];
        return process2(0, cost, dp);
    }

    private static int process2(int i, int[] cost, int[] dp) {
        // base case
        if (i >= cost.length) {
            return 0;
        }
        if (dp[i] != 0) {
            return dp[i];
        }
        int one = cost[i] + process2(i + 1, cost, dp);
        int two = i < cost.length - 1 ? cost[i + 1] + process2(i + 2, cost, dp) : 0;

        dp[i] = Math.min(one, two);
        return dp[i];
    }

    /**
     * 暴力递归
     *
     * @param cost
     * @return
     */
    public static int minCostClimbingStairs1(int[] cost) {
        if (cost == null || cost.length == 0) {
            throw new RuntimeException("参数错误");
        }
        return process1(0, cost);
    }

    private static int process1(int i, int[] cost) {
        // base case
        if (i >= cost.length) {
            return 0;
        }
        int one = cost[i] + process1(i + 1, cost);

        int two = i < cost.length - 1 ? cost[i + 1] + process1(i + 2, cost) : 0;
        return Math.min(one, two);
    }

    public static void main(String[] args) {
        int[] arr = {10, 15, 20};
        System.out.println(minCostClimbingStairs1(arr) == minCostClimbingStairs3(arr));
    }
}
