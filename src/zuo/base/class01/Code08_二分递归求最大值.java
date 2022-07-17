package zuo.base.class01;

/**
 * Code08_GetMax
 *
 * @author xiaoliang
 * @date 2021/09/12 15:44
 **/
public class Code08_二分递归求最大值 {

    public static int getMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new RuntimeException("参数错误");
        }
        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int left, int right) {

        if (left == right) {
            return arr[left];
        }
        int mid = left + ((right - left) >> 1);
        int leftMax = process(arr, left, mid);
        int rightMax = process(arr, mid + 1, right);
        return Math.max(leftMax, rightMax);

    }

    public static void main(String[] args) {

        int[] arr = {3, 4, 13, 4, 1, 323, 64, 3, 32, 17, 1, 13, 321, 1};
        int getMax = getMax(arr);
        System.out.println("getMax = " + getMax);

    }
}
