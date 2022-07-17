package zuo.base.class01;

import zuo.CheckMachine;

import java.util.Arrays;

/**
 * Code04_BSExist 二分查找，在有序数组中
 * 二分查找可以做的：
 * 1、找数（要求有序）
 * 2、可以找 >= 某数的最左，就是firstIndexOf  （要求有序）
 * 3、局部最小值（不用要求有序）
 *
 * @author xiaoliang
 * @date 2021/09/12 15:41
 **/
public class Code04_BSExist {

    public static int exist(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) {
            return -1;
        }
        int L = 0, R = sortedArr.length - 1;
        while (L <= R) {
            // 二分
            int mid = L + ((R - L) >> 1);
            if (sortedArr[mid] == num){
                return mid;
            }else if (sortedArr[mid] < num) {
                L = mid + 1;
            } else if (sortedArr[mid] > num) {
                R = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = CheckMachine.generateArray(100, 12312312);
        Arrays.sort(arr);
        int num = arr[50];
        int exist = exist(arr, num);
        System.out.println("exist = " + exist);
    }
}
