package leetcode;

import java.util.Arrays;

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * <p>
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * <p>
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 * @author xiaoliang
 * @date 2021/10/19 16:01
 **/
public class LC977_E_有序数组的平方 {

    public static int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new RuntimeException("参数错误");
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    // 双指针法
    public static int[] sortedSquares2(int[] nums) {

        if (nums == null || nums.length == 0) {
            throw new RuntimeException("参数错误");
        }
        int[] result = new int[nums.length];
        int L = 0;
        int R = nums.length - 1;
        int index = result.length - 1;

        while (L <= R) {
            if (nums[L] * nums[L] >= nums[R] * nums[R]) {
                result[index--] = nums[L] * nums[L];
                L++;
            } else {
                result[index--] = nums[R] * nums[R];
                R--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {-7, -3, 2, 3, 11};
        for (int item : sortedSquares2(arr)) {
            System.out.print(item + " ");
        }
    }
}
