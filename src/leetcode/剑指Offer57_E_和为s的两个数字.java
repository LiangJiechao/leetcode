package leetcode;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 * 如果有多对数字的和等于s，则输出任意一对即可。
 *
 * @author xiaoliang
 * @date 2021/12/02 17:36
 **/
public class 剑指Offer57_E_和为s的两个数字 {

    /**
     * 思路：双指针法，左右两边的数加起来，如果>target，则右指针移动；如果<target，则左指针移动
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }

        int left = 0;
        int right = nums.length - 1;
        int tmp;
        while (left < right) {
            tmp = nums[left] + nums[right];
            if (tmp < target) {
                left++;
            } else if (tmp > target) {
                right--;
            } else {
                return new int[]{nums[left], nums[right]};
            }
        }
        // 找不到
        return null;
    }
}
