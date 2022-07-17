package zuo.base.class02;

/**
 * Code02_SmallSum 小和问题
 * 一个数组上，将每个数前面所有比它小的数求和
 * 即求每个数后面所有比它大的数的和
 * 在纠结前面多少数比我大（或后面多少个数比我小）时候可以使用归并排序
 *
 * @author xiaoliang
 * @date 2021/09/12 15:45
 **/
public class Code02_SmallSum {

    public static int smallSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new RuntimeException("参数错误");
        }
        return mergeSort(arr, 0, arr.length - 1);
    }

    private static int mergeSort(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = left + ((right - left) >> 1);
        return mergeSort(arr, left, mid) +
                mergeSort(arr, mid + 1, right) +
                merge(arr, left, mid, right);
    }

    private static int merge(int[] arr, int left, int mid, int right) {

        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;

        int smallSum = 0;

        while (p1 <= mid && p2 <= right) {
            smallSum += arr[p1] <= arr[p2] ? arr[p1] * (right - p2 + 1) : 0;
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
//            if (arr[p1]<arr[p2]){
//                smallSum+=arr[p1]*(right-p2+1);
//                help[i++]=arr[p1++];
//            }else {
//                help[i++]=arr[p2++];
//            }
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= right) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[left + j] = help[j];
        }
        return smallSum;
    }

    public static void main(String[] args) {
//        int[] arr = {1, 3, 5, 2, 4, 6};
        int[] arr = {56,85,-3, -11, 35, 13, 85, -11 ,-21};

        int smallSum = smallSum(arr);
        System.out.println("smallSum = " + smallSum);
////        Arrays.stream(arr).forEach(x -> System.out.print(x + ","));
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = scanner.nextInt();
//        }
//        System.out.println(new 小和问题().smallSum(nums));
    }
}
