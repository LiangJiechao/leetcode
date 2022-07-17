package zuo;

/**
 * 求小和
 *
 * @author xiaoliang
 * @date 2021/09/12 14:41
 **/
public class SmallSum {

    // 可以分析为什么不会漏算和重算，分析一个数的心路历程
    // 不仅排序，而且求小和
    public static int process(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1); // >> 右移一位 == 除2
        return process(arr, l, mid) // 左侧产生的小和
                + process(arr, mid + 1, r) // 右侧产生的小和
                + merge(arr, l, mid, r); // merge过程中产生的小和
    }

    /**
     * 合并数组，下表从l 到 r
     *
     * @param arr
     * @param l
     * @param mid
     * @param r
     * @return
     */
    public static int merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        int res = 0;

        while (p1 <= mid && p2 <= r) {
            res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) { // 剩下p1
            help[i++] = arr[p1++];
        }
        while (p2 <= r) { // 剩下p2
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[i+l]=help[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,2,5};
        System.out.println(process(arr,0,arr.length-1));
    }
}
