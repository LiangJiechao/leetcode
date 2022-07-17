package test;

import java.util.Scanner;

/**
 * @author xiaoliang
 * @date 2022/05/01 09:53
 **/
public class 牛客 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        maxSubarraySumCircular(nums);
//        int[] dp = new int[n];
//        dp[0] = nums[0];
//        int res = dp[0];
//        for (int i = 1; i < 2 * n; i++) {
//            dp[i % n] = Math.max(dp[(i - 1) % n], 0) + nums[i % n];
//            res = Math.max(res, dp[i % n]);
//        }
//        System.out.println(res);
    }

    public static int maxSubarraySumCircular(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new RuntimeException("参数错误");
        }

        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int max = arr[0];
        int sum = arr[0];

        // 求最大子序列和
        for (int i = 1; i < arr.length; i++) {
            sum += arr[i];
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + arr[i] : arr[i];
            max = Math.max(dp[i], max);
        }

        int min = 0;
        // 求最小子序列和，只需要求arr[1]-arr[n-2]间这些负数的最小和求出来
        for (int i = 1; i < arr.length-1; i++) {
            dp[i] = dp[i - 1] < 0 ? dp[i - 1] + arr[i] : arr[i];
            min = Math.min(dp[i], min);
        }

        return Math.max(max, sum - min);
    }

}
