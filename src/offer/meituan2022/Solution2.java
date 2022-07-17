package offer.meituan2022;

import java.util.Scanner;

/**
 * 输出n(0<n<1000)个数字，每个数字可能是1或者是-1，问连续的序列的乘积是正数的数有多少个？
 *
 * @author xiaoliang
 * @date 2022/03/13 11:31
 **/
public class Solution2 {

    // 枚举所有子数组
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int x = 1;
            for (int j = i; j < n; j++) {
                x *= nums[j];

                if (x == 1) {
                    res++;
                }
            }
        }
        System.out.println(res);
        check(nums);
    }

    public static void check(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] == 1 ? 0 : 1;
        }

        int[] presSum = new int[nums.length + 1];
        presSum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            presSum[i] = presSum[i - 1] + nums[i - 1];
        }

        int res = 0;
        // 这里统计
        for (int i = 1; i < presSum.length; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = presSum[i] - presSum[j];
                if (tmp % 2 == 0) {
                    res++;
                }
            }
        }

        System.out.println(res);
    }

}
