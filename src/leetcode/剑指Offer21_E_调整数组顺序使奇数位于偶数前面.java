package leetcode;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 *
 * @author xiaoliang
 * @date 2021/12/02 17:29
 **/
public class 剑指Offer21_E_调整数组顺序使奇数位于偶数前面 {

    /**
     * 思路：双指针法，类似快排
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return nums;
        }

        int left = 0;
        int right = nums.length - 1;
        int temp = nums[left];

        while (left < right) {
            while (left < right && nums[right] % 2 == 0) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] % 2 == 1) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = temp;
        return nums;
    }
}
