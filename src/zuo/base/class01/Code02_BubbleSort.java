package zuo.base.class01;

import zuo.CheckMachine;

/**
 * 冒泡排序
 *
 * @author xiaoliang
 * @date 2021/09/12 15:40
 **/
public class Code02_BubbleSort {

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = CheckMachine.generateArray(20, 100022);
        bubbleSort(arr);
        for (int item : arr) {
            System.out.print(item + " ");
        }
    }
}
