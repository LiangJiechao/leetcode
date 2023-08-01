package leetcode;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 进阶：
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 *
 * @author xiaoliang
 * @date 2022/01/09 20:47
 **/
public class LC34_M_在排序数组中查找元素的第一个和最后一个位置 {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = leftBound(nums, target);
        int right = rightBound(nums, target);

        return new int[]{left, right};
    }

    /**
     * nums = [1,2,2,2,3]，target 为 2
     * 找最左侧边界 返回 1
     *
     * @param nums   有序
     * @param target
     * @return
     */
    int leftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int firstIndex = 0;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] >= target) {
                firstIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nums[firstIndex] == target ? firstIndex : -1;
    }

    /**
     * nums = [1,2,2,2,3]，target 为 2
     * 返回 3
     *
     * @param nums
     * @param target
     * @return
     */
    int rightBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int lastIndex = 0;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] <= target) {
                lastIndex = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // 不存在则返回-1
        return nums[lastIndex] == target ? lastIndex : -1;
    }

}
