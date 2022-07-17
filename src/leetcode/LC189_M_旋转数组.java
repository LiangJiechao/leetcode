package leetcode;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 进阶：
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 * <p>
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 * @author xiaoliang
 * @date 2021/10/19 16:27
 **/
public class LC189_M_旋转数组 {

    // 巧妙方法
    public static void rotate3(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k < 0) {
            throw new RuntimeException("参数错误");
        }
        if (k == 0) {
            return;
        }
        //防止循环
        k %= nums.length;
        int L = 0;
        int R = nums.length - 1;

        reverse1(nums, L, R - k);
        reverse1(nums, R - k + 1, R);
        reverse1(nums, L, R);
    }

    public static void reverse1(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }

    private static void reverse(int[] nums, int start, int end) {

        int mid = start + ((end - start) >> 1);
        for (int i = start, j = 0; i <= mid; i++, j++) {
            swap(nums, i, end - j);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 双重循环，类似于冒泡排序
    public static void rotate2(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            throw new RuntimeException("参数错误");
        }
        if (k == 0) {
            return;
        }
        int len = nums.length;
        //防止循环
        k %= len;

        int temp;
        for (int i = 0; i < k; i++) {
            temp = nums[len - 1];
            for (int j = len - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }

    // 暴力求解
    public static void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            throw new RuntimeException("参数错误");
        }
        if (k == 0) {
            return;
        }
        int len = nums.length;
        //防止循环
        k %= len;

        int[] help = new int[len * 2];

        for (int i = 0; i < len; i++) {
            help[i] = help[i + len] = nums[i];
        }

        for (int i = 0, j = len - k; i < len; i++, j++) {
            nums[i] = help[j];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        rotate3(arr, 3);
    }
}
