package zuo.base.class01;

/**
 * Code06_BSAwesome
 * 局部最小值，也采用二分法 （不用要求有序）
 * <p>
 * 局部最小值定义：
 * 最左边边界处，如果最左边的数小于左边第二个数，则最左边为局部最小值。
 * 最右边边界处，如果最右边的数小于右边第二个数，则最右边为局部最小值。
 * 中间处，如果一个数小于它两边的数，则这个数就是局部最小值。
 * 说白了，就是二维坐标系中的任意一个最低点，都是局部最小值。
 * 现在，有一个数组，相邻的两个数不相等，请求出一个数组中的一个局部最小值。
 *
 * @author xiaoliang
 * @date 2021/09/12 15:42
 **/
public class Code06_二分法局部最小值 {

    public static int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        // 左边
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        // 右边
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }

        int left = 1;
        int right = arr.length - 2;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {100, 45, 321, 624, 4236, 43, 62, 23, 243};
        int lessIndex = getLessIndex(arr);
        System.out.println("lessIndex = " + lessIndex);

    }
}
