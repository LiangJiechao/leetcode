package leetcode.labuladong.la23dp;

/**
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 * @author xiaoliang
 * @date 2022/04/01 10:52
 **/
public class 剑指095_M_最长公共子序列 {

    public int longestCommonSubsequence(String text1, String text2) {
        char[] arr1 = text1.toCharArray();
        char[] arr2 = text2.toCharArray();

        int len1 = arr1.length;
        int len2 = arr2.length;

        int[][] dp = new int[len1+1][len2+1];

        for(int i = 1;i<=len1;i++){
            for(int j = 1;j<=len2;j++){

                if(arr1[i-1] == arr2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }

            }
        }
        return dp[len1][len2];
    }

    // 压缩空间
    // 可以用两个一维数组
    // 或者用一个一维数组 + 几个变量
}
