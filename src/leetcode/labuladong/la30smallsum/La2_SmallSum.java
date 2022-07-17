package leetcode.labuladong.la30smallsum;

/**
 * 求小和
 *
 * @author xiaoliang
 * @date 2021/09/12 14:41
 **/
public class La2_SmallSum {

    public static int smallSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new RuntimeException("参数错误");
        }
        return mergeSort(arr, 0, arr.length - 1);
    }

    private static int mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = left + ((right - left) >> 1);
        return mergeSort(arr, left, mid)
                + mergeSort(arr, mid + 1, right)
                + merge(arr, left, mid, right);
    }

    private static int merge(int[] arr, int left, int mid, int right) {

        int[] help = new int[right - left + 1];
        int index = 0;
        int p1 = left;
        int p2 = mid + 1;

        int smallSum = 0;

        while (p1 <= mid && p2 <= right) {
            smallSum += arr[p1] <= arr[p2] ? arr[p1] * (right - p2 + 1) : 0;
            help[index++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
//            if (arr[p1]<arr[p2]){
//                smallSum+=arr[p1]*(right-p2+1);
//                help[index++]=arr[p1++];
//            }else {
//                help[index++]=arr[p2++];
//            }
        }
        while (p1 <= mid) {
            help[index++] = arr[p1++];
        }
        while (p2 <= right) {
            help[index++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[left + j] = help[j];
        }
        return smallSum;
    }
}
