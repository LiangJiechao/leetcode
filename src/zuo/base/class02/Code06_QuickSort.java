package zuo.base.class02;

import zuo.CheckMachine;

/**
 * 快排
 *
 * @author xiaoliang
 * @date 2021/09/12 15:46
 **/
public class Code06_QuickSort {

    public static void quickSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort1(arr, 0, arr.length - 1);
    }


    public static void quickSort1(int[] arr, int L, int R) {
        if (L < R) {
            swap(arr, L, L + (int) (Math.random() * (R - L + 1)));
            int p = partition1(arr, L, R);
            quickSort1(arr, L, p);
            quickSort1(arr, p + 1, R);
        }
    }

    /**
     * 记录pivot，从右边开始，把大于pivot的放到右边，小于pivot的放到左边
     *
     * @param arr
     * @param L
     * @param R
     * @return
     */
    public static int partition1(int[] arr, int L, int R) {

        int pivot = arr[L];
        while (L < R) {
            while (L < R && arr[R] >= pivot) {
                R--;
            }
            arr[L] = arr[R];

            while (L < R && arr[L] < pivot) {
                L++;
            }
            arr[R] = arr[L];
        }
        arr[L] = pivot;
        return L;
    }

    public static void quickSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort2(arr, 0, arr.length - 1);
    }

    public static void quickSort2(int[] arr, int L, int R) {
        if (L < R) {
            swap(arr, L + (int) (Math.random() * (R - L + 1)), R);

            int[] p = partition2(arr, L, R);
            quickSort2(arr, L, p[0]);
            quickSort2(arr, p[1], R);
        }
    }

    public static int[] partition2(int[] arr, int L, int R) {
        int pivot = arr[R];
        // less 表示小区，一开始小区和大区一个也没括上
        int less = L - 1;
        // more 表示大区
        int more = R + 1;
        while (L <= R) {
            // 3种情况
            if (arr[L] < pivot) {
                // 放到最左边
                swap(arr, ++less, L++);
            } else if (arr[L] > pivot) {
                swap(arr, L, R--);
                more--;
            } else {
                // arr[less]==K
                L++;
            }
        }
//        System.out.println("快排需要用上这两个坐标"+less+"--"+more);
        return new int[]{less, more};
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr2 = {5, 5, 7, 1, 6, 5, 5, 6, 3, 7, 2, 5, 5, 9, 1, 0};
//        int[] arr2 = CheckMachine.generateArray(100, 50312323);
        int[] arr1 = CheckMachine.copyArray(arr2);

        quickSort2(arr2);
        quickSort1(arr1);

        System.out.println("CheckMachine.isEqual(arr1,arr2) = " + CheckMachine.isEqual(arr1, arr2));
    }

}
