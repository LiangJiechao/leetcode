package offer.dianxin.d1;

import java.util.Arrays;

/**
 * @author liangjiechao
 * @date 2022/10/12 16:03
 **/
public class Main {
    public static void main(String[] args) {
        int[] arr = {5, 5, 7, 1, 6, 5, 5, 6, 3, 7, 2, 5, 5, 9, 1, 0};
        new Main().quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            swap(arr, left, left + (int) (Math.random() * (right - left + 1)));
            int p = partition(arr, left, right);
            quickSort(arr, left, p);
            quickSort(arr, p + 1, right);
        }


    }

    private int partition(int[] arr, int left, int right) {

        int pivot = arr[left];

        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
