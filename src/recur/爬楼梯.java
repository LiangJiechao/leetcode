package recur;

/**
 * 爬楼梯，一次只能一格或两格，问有几种爬法
 *
 * @author xiaoliang
 * @date 2021/09/23 14:30
 **/
public class 爬楼梯 {

    public static int climbStair1(int n) {
        if (n < 1) {
            return 0;
        }
        return process1(n);
    }

    private static int process1(int n) {

        // base case
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        return process1(n - 1) + process1(n - 2);
    }

    public static int climbStair2(int n) {
        if (n < 1) {
            return 0;
        }
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        return process2(n, dp);
    }

    private static int process2(int n, int[] dp) {
        if (dp[n] != -1) {
            return dp[n];
        }
        dp[n] = process2(n - 1, dp) + process2(n - 2, dp);
        return dp[n];
    }

    public static int climbStair3(int n) {
        if (n < 1) {
            return 0;
        }
        return process3(n);
    }

    private static int process3(int n) {
        int[] dp = new int[n + 1];
        // init dp[]
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 29;
        System.out.println("climbStair1(n) = " + climbStair1(n));
        System.out.println("climbStair2(n) = " + climbStair2(n));
        System.out.println("climbStair3(n) = " + climbStair3(n));
    }
}
