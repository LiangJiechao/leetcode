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
public class LC91_解码方法 {

    public int numDecodings(String s) {
        char[] arr = s.toCharArray();
        if (arr[0]=='0'){
            return 0;
        }
        if (arr.length == 1) {
            return 1;
        }
        // dp[i]表示arr前i个元素有多少种组合方式
        int[] dp = new int[arr.length + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= arr.length; i++) {
            if ((arr[i - 2] - '0') * 10 + (arr[i - 1] - '0') <= 26) {
                dp[i] = dp[i - 2] + dp[i - 1];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        //"12113123123543"
//        for (int i = 2; i <= arr.length; i++) {
//            if ((arr[i - 1] - '0') * 10 + (arr[i] - '0') <= 26) {
//                dp[i] = dp[i - 1] + dp[i-2];
//            } else {
//                dp[i] = dp[i - 1];
//            }
//        }

        return dp[dp.length - 1];
    }

    public int numDecodings2(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (arr[i - 1] != '0') {
                dp[i] += dp[i - 1];
            }
            if (i > 1 && arr[i - 2] != '0' && ((arr[i - 2] - '0') * 10 + (arr[i - 1] - '0') <= 26)) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new LC91_解码方法().numDecodings("2226"));
    }


}
