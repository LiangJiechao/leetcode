package zuo.middleascension.class16;

import java.util.Arrays;

/**
 * 子序列：不需要连续也可以
 * 给定一数组，求最长递增子序列的长度
 * 如[3,1,2,6,3,4] ==> 4
 * <p>
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 * <p>
 * 思路：看到子序列、子数组或子串问题，就想以i为结尾的情况下会怎么怎么样
 * 时：O(n^2)
 *
 * @author xiaoliang
 * @date 2021/10/09 21:11
 **/
public class Class08_最长递增子序列 {

    public static int getLongestSubsequence(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            // 在i位置往前看，看谁是你小的数，在比你小的数中选择长度最长的，再加1就是以你结尾的最大递增长度
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 6, 3, 4};
        System.out.println(getLongestSubsequence(arr));
    }
}
