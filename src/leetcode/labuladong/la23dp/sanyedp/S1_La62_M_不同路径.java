package leetcode.labuladong.la23dp.sanyedp;

import java.util.Arrays;

/**
 * 无后效性：
 * 如果对于某个状态，我们可以只关注状态的值，而不需要关注状态是如何转移过来的话，
 * 那么这就是一个无后效性的问题，可以考虑使用 DP 解决
 *
 * 另外一个更加实在的技巧，我们还可以通过 数据范围 来猜测是不是可以用 DP 来做。
 * 因为 DP 是一个递推的过程，因此如果数据范围是 10^5~10^6 的话，可以考虑是不是可以使用一维 DP 来解决；
 * 如果数据范围是 10^2~10^3 的话，可以考虑是不是可以使用二维 DP 来做 ...
 *
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 *
 * 输入：m = 3, n = 7
 * 输出：28
 *
 * @author xiaoliang
 * @date 2022/04/26 14:32
 **/
public class S1_La62_M_不同路径 {

    public int uniquePaths(int m, int n) {

        int[] dp = new int[n+1];
        Arrays.fill(dp,1);
        dp[0] = 0;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[j] = dp[j]+dp[j-1];
            }
        }
        return dp[n];
    }
}
