package zuo.base.class03;

import zuo.CheckMachine;

/**
 * 基数排序
 *
 * @author xiaoliang
 * @date 2021/09/12 20:28
 **/
public class Code02_RadixSort {

    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        radixSort(arr, 0, arr.length - 1, maxbits(arr));
    }

    /**
     * 获取数组中的最大位数
     *
     * @param arr
     * @return
     */
    public static int maxbits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }

    public static void radixSort(int[] arr, int L, int R, int digit) {
        final int radix = 10;
        int i = 0, j = 0;
        int[] bucket = new int[R - L + 1];

        for (int d = 1; d <= digit; d++) { // 有多少位就进出桶几次

            int[] count = new int[radix];
            for (i = L; i <= R; i++) {
                j = getDigit(arr[i], d);
                count[j]++;
            }
            for (i = 1; i < radix; i++) {
                // 前缀和，这里相当于分片了
                count[i] += count[i - 1];
            }
            for (i = R; i >= L; i--) { // 从后往前遍历是为了 相当于 让桶里的先进先出
                j = getDigit(arr[i], d);
                bucket[count[j] - 1] = arr[i];
                count[j]--;
            }
            // 重新收集
            for (i = L, j = 0; i <= R; i++, j++) {
                arr[i] = bucket[j];
            }
        }
    }

    /**
     * 获取num的第d位上的数字
     *
     * @param num
     * @param d
     * @return
     */
    public static int getDigit(int num, int d) {

        int res = -1;
        for (int i = 0; i < d; i++) {
            res = num % 10;
            num /= 10;
        }
        return res;
    }

    public static void main(String[] args) {

        int[] arr = CheckMachine.generateArray(10, 3000);
//        System.out.println(getDigit(1234, 2));
        radixSort(arr);
        for (int item : arr) {
            System.out.print(item + " ");
        }
    }
}
