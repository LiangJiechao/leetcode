package leetcode.labuladong.la23dp;

/**
 * @author xiaoliang
 * @date 2022/03/10 21:33
 **/
public class La6_LC1143_M_最长公共子序列 {

    public int longestCommonSubsequence(String text1, String text2) {
        char[] arr1 = text1.toCharArray();
        char[] arr2 = text2.toCharArray();

        int m = arr1.length;
        int n = arr2.length;

        // dp[i][j]代表arr1[0..i]与 arr2[0..j]中的最长公共子序列
        int[][] dp = new int[m + 1][n + 1];
        /*for (int i = 0; i < m; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 0;
        }*/

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    // arr1[i-1] 和 arr2[j-1] 必然在 lcs 中
                    // 如 a b c c 与 a c e
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // a c e 和 b c
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }
        return dp[m][n];
    }

}
