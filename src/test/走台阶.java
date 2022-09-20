package test;

/**
 * @author xiaoliang
 * @date 2022/09/08 17:22
 **/
public class 走台阶 {

    public int func(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        // init
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
