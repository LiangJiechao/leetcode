package leetcode.labuladong.la23dp;

import java.util.Scanner;

/**
 * @author xiaoliang
 * @date 2022/05/01 09:53
 **/
public class 乘积为正数的最长连续子数组 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        int tmp;
        for (int i = 0; i < n; i++) {
            tmp = scanner.nextInt();
            if (tmp > 0) {
                nums[i] = 1;
            } else if (tmp < 0) {
                nums[i] = -1;
            }
        }
        int res = 0;
        // O(n^2)超时
//        for (int i = 0; i < n; i++) {
//            int sub = 1;
//            for (int j = i; j < n; j++) {
//                sub *= nums[j];
//                if (sub > 0) {
//                    res = Math.max(res, j - i + 1);
//                }
//            }
//        }

        // O(n)
        // 表示目前正负数的长度
        int positive = nums[0] > 0 ? 1 : 0;
        int negative = nums[0] < 0 ? 1 : 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                positive = positive + 1;
                // 前面出现有负数
                negative = negative > 0 ? negative + 1 : 0;
            } else if (nums[i] == 0) {
                positive = 0;
                negative = 0;
            } else {
                // nums[i] < 0
                // 这里要判断 negative > 0 是因为需要前面有出现负数
                tmp = negative > 0 ? negative + 1 : 0;
                negative = positive + 1;
                positive = tmp;
            }
            res = Math.max(res, positive);
        }

        System.out.println(res);
    }
}
