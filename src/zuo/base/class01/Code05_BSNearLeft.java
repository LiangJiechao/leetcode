package zuo.base.class01;

/**
 * 分查找，可以找 >= 某数的最左，就是firstIndexOf  （要求有序） 不存在则返回 -1
 * 二分查找可以做的：
 * 1、找数（要求有序）
 * 2、可以找 >= 某数的最左，就是firstIndexOf  （要求有序）
 * 3、局部最小值（不用要求有序）
 *
 *
 * @author xiaoliang
 * @date 2021/09/12 15:42
 **/
public class Code05_BSNearLeft {

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
