package leetcode;

/**
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 *
 * @author xiaoliang
 * @date 2022/04/13 22:27
 **/
public class LC33_M_搜索旋转排序数组 {

    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < nums[right]) {
                // 右边有序
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                // 左边有序
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
