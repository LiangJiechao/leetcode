package zuo.base.class02;

/**
 * 归并排序
 *
 * @author xiaoliang
 * @date 2021/09/12 15:40
 **/
public class Code01_MergeSort {

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * 对arr数组[left..right]进行归并排序
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        // 左右两边划分
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        // 划分完成后开始合并
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {

        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;

        while (p1 <= mid && p2 <= right) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 有一个子数组完了
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= right) {
            help[i++] = arr[p2++];
        }

        //拷贝回原数组，这里注意细节arr下标
        for (int j = 0; j < help.length; j++) {
            arr[left + j] = help[j];
        }
    }

    public static void main(String[] args) {
        int[] arr = {23, 315, 8, 25, 28, 92, 1144, 513, 626};
        mergeSort(arr);
        for (int item : arr) {
            System.out.print(item + " ");
        }
    }
}
