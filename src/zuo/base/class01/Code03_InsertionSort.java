package zuo.base.class01;

import zuo.CheckMachine;

/**
 * 插入排序
 *
 * @author xiaoliang
 * @date 2021/09/12 15:40
 **/
public class Code03_InsertionSort {

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {

            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j-1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = CheckMachine.generateArray(20, 100022);
        insertSort(arr);
        for (int item : arr) {
            System.out.print(item + " ");
        }
    }
}
