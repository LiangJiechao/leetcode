package test;

import java.util.Scanner;

/**
 * @author xiaoliang
 * @date 2022/05/01 10:28
 **/
public class DP5_有多少个不同的二叉搜索树 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int res = diffTreeType(n);
        System.out.println(res);

    }

    public static int diffTreeType(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
