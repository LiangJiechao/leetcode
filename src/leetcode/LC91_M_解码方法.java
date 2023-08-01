package leetcode;

/**
 * 示例 1：
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 * <p>
 * 示例 2：
 * 输入：s = "226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 * @author xiaoliang
 * @date 2022/03/17 11:36
 **/
public class LC91_M_解码方法 {

    public int numDecodings(String s) {
        int n = s.length();
        if (n < 1) {
            return 0;
        }
        // 定义：dp[i] 表示 s[0..i-1] 的解码方式数量
        int[] dp = new int[n + 1];
        // base case: s 为空或者 s 只有一个字符的情况
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        // 注意 dp 数组和 s 之间的索引偏移一位
        for (int i = 2; i <= n; i++) {
            char c = s.charAt(i - 1), d = s.charAt(i - 2);
            if ('1' <= c && c <= '9') {
                // 1. s[i] 本身可以作为一个字母
                dp[i] += dp[i - 1];
            }
            if (d == '1' || d == '2' && c <= '6') {
                // 2. s[i] 和 s[i - 1] 结合起来表示一个字母
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }



    // 动态规划
    public int numDecodings2(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        // dp[i]表示s中前i个数字有多少中拼法
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (arr[i - 1] != '0') {
                dp[i] += dp[i - 1];
            }
            if (i > 1 && (arr[i - 2] == '1' || (arr[i - 2] == '2' && arr[i - 1] <= '6'))) {
                dp[i] += dp[i - 2];
            }
//            if (i > 1 && arr[i - 2] != '0' && ((arr[i - 2] - '0') * 10 + (arr[i - 1] - '0') <= 26)) {
//                dp[i] += dp[i - 2];
//            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new LC91_M_解码方法().numDecodings("2226"));
    }

}
