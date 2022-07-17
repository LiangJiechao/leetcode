package leetcode.labuladong.la4binarysearch;

/**
 * 搜索⼀个数，如果存在，返回其索引，否则返回 -1。
 *
 * @author xiaoliang
 * @date 2022/02/24 15:58
 **/
public class La1_二分查找一个数 {

    /**
     * @param nums   有序数组
     * @param target
     * @return
     */
    int binarySearch(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }
}
