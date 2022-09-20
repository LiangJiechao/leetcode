package leetcode.labuladong.la23dp;

/**
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 * <p>
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 * <p>
 * 输入：s = "bbbab"
 * 输出：4
 * 解释：一个可能的最长回文子序列为 "bbbb" 。
 * <p>
 * 输入：s = "cbbd"
 * 输出：2
 * 解释：一个可能的最长回文子序列为 "bb" 。
 *
 * @author xiaoliang
 * @date 2022/04/11 15:40
 **/
public class La8_LC516_M_最长回文子序列 {

    /**
     * 有关子序列的dp，可以用二维的数组解决
     */
    public int longestPalindromeSubseq(String s) {
        char[] arr = s.toCharArray();
        int m = arr.length;

        // dp[i][j] 代表 s[i..j]上的最长回文子序列
        int[][] dp = new int[m][m];

        for (int i = 0; i < m; i++) {
            dp[i][i] = 1;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = i + 1; j < m; j++) {
                if (arr[i] == arr[j]) {
                    // 它俩一定在最长回文子序列中
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    // s[i+1..j] 和 s[i..j-1] 谁的回文子序列更长？
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][m - 1];

    }
}
