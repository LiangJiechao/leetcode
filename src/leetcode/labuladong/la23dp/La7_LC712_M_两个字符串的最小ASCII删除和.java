package leetcode.labuladong.la23dp;

/**
 * 给定两个字符串s1 和 s2，返回 使两个字符串相等所需删除字符的 ASCII 值的最小和 。
 *
 * 输入: s1 = "sea", s2 = "eat"
 * 输出: 231
 * 解释: 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
 * 在 "eat" 中删除 "t" 并将 116 加入总和。
 * 结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。
 *
 * @author xiaoliang
 * @date 2022/04/18 11:31
 **/
public class La7_LC712_M_两个字符串的最小ASCII删除和 {

    public int minimumDeleteSum(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        int len1 = arr1.length;
        int len2 = arr2.length;

        // 画图理解
        // dp[i][j] 代表 使得 s1[0..i-1] 和 s2[0..j-1]相同的最小删除ASCII总和
        int[][] dp = new int[len1 + 1][len2 + 1];
        // init
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = dp[i - 1][0] + arr1[i - 1];
        }
        for (int i = 1; i <= len2; i++) {
            dp[0][i] = dp[0][i - 1] + arr2[i - 1];
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + arr1[i - 1], dp[i][j - 1] + arr2[j - 1]);
                }
            }
        }
        return dp[len1][len2];

    }

    public static void main(String[] args) {
        String s1 = "sea", s2 = "eat";
        new La7_LC712_M_两个字符串的最小ASCII删除和().minimumDeleteSum(s1,s2);
    }
}
