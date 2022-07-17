package offer.meituan2022319.m4;

import java.util.Scanner;

/**
 * 第一行有三个正整数n, k1 , k2 (1<=n<=100000,1<=k1 , k2<=10)，代表球的数量和小团选择的两个参数。
 *
 * 第二行有 n 个整数，分别代表每个球上写的数。这些数的绝对值不超过1000。
 *
 * 数字间两两有空格隔开。
 * 
 * @author xiaoliang
 * @date 2022/03/19 11:11
 **/
/*
测试1：
5 3 4
6 8 -2 -5 2
预期结果：
9 2

测试2：
10 3 4
6 8 -2 -5 2 9 1 3 -6 -3
结果： 27  2

 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k1 = scanner.nextInt();
        int k2 = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();;
        }

        dfs2(nums, 0, k1, k2,n);

        System.out.println(res + " " + num);
    }

    static int res = 0;
    static long num = 0;
    static int path = 0;

    /*
    *   1. 球上所写的数之和可以被k1整除
        2. 球上所写的数之和不能被k2整除
        3. 在满足前两个条件的前提下，球上所写的数之和要尽可能的大
    * */
    private static void dfs(int[] nums, int i, int k1, int k2) {
        if (i ==nums.length) {
            if (path % k1 == 0 && path % k2 != 0) {
                if (res < path) {
                    res = path;
                    num = 1;
                } else if (res == path) {
                    num += 1;
                    num %= 998244353;
                }
            }
            return;
        }

        // 不选
        dfs(nums, i + 1, k1, k2);

        // 选
        path += nums[i];
        dfs(nums, i + 1, k1, k2);
        path -= nums[i];

    }

    private static void dfs2(int[] nums, int i, int k1, int k2, int n) {

        if (path % k1 == 0 && path % k2 != 0) {
            if (res < path) {
                res = path;
                num = 1;
            } else if (res == path) {
                num += 1;
                num %= 998244353;
            }
        }

        if (i == nums.length) {
            return;
        }

        for (int j = i; j < n; j++) {
            path += nums[j];
            dfs2(nums, j + 1, k1, k2, n);
            path -= nums[j];
        }
    }
}
