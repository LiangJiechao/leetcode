package zuo.base.class01;

/**
 * 选择排序
 *
 * @author xiaoliang
 * @date 2021/09/12 15:40
 **/
public class Code01_SelectionSort {

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 每次循环找到一个最小值
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            // 找到最小值对应的下标
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[minIndex] < arr[j] ? minIndex : j;
            }
            swap(arr, i, minIndex);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 6, 334, 53, 34, 63, 6, Integer.MIN_VALUE, 32, Integer.MAX_VALUE,};
        selectionSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
