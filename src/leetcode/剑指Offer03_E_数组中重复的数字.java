package leetcode;

/**
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 * @author xiaoliang
 * @date 2021/11/23 21:29
 **/
public class 剑指Offer03_E_数组中重复的数字 {

    /**
     * 思路：把一个数n放回到n位置
     * 鹊巢原理
     *
     * @param nums
     * @return
     */
    public static int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                adjust(nums, i);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return nums[i];
            }
        }
        return -1;
    }

    private static void adjust(int[] arr, int i) {
        while (arr[arr[i]] != arr[i]) {
            int temp = arr[arr[i]];
            arr[arr[i]] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(nums));
    }
}
