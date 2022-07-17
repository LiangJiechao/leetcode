package zuo.goodoffer.class01;

import java.util.Arrays;

/**
 * 给定一个正数数组arr，长度为n，正数x，正数y
 * 目标是让数组累加和小于等于0
 * 你可以对数组中的数执行以下三种操作中的一种，且每个数最多只能执行一次操作
 * 1.不变
 * 2.让数num变为0，代价为x
 * 3.让数num变为相反数-num，代价为y
 * 返回达到目标的最小代价
 *
 * @author xiaoliang
 * @date 2021/11/12 10:10
 **/
public class Code01_让数组累加和小于等于0的最小代价 {

    /**
     * 思路：暴力解，每个数有三种执行的可能，依次尝试
     *
     * @param arr
     * @param x
     * @param y
     * @return
     */
    public static int lowestCost(int[] arr, int x, int y) {

        int sum = Arrays.stream(arr).reduce(0, (a, b) -> a + b);

        return process1(arr, x, y, 0, sum);
    }

    private static int process1(int[] arr, int x, int y, int i, int sum) {

        if (sum <= 0) {
            return 0;
        }
        // sum > 0 没搞定
        if (i == arr.length) {
            return Integer.MAX_VALUE;
        }
        // 第一选择，什么也不干！
        int p1 = process1(arr, x, y, i + 1, sum);
        // 第二选择，执行x的操作，变0 x + 后续
        int p2 = Integer.MAX_VALUE;
        int next2 = process1(arr, x, y, i + 1, sum - arr[i]);
        if (next2 != Integer.MAX_VALUE) {
            p2 = x + next2;
        }
        // 第三选择，执行y的操作，变相反数 x + 后续 7 -7 -14
        int p3 = Integer.MAX_VALUE;
        int next3 = process1(arr, x, y, i + 1, sum - (arr[i] << 1));
        if (next3 != Integer.MAX_VALUE) {
            p3 = y + next3;
        }
        return Math.min(p1, Math.min(p2, p3));
    }
}
