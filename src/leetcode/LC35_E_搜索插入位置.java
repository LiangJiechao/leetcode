package leetcode;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * 思路：二分法，求最左边>=target的下标位置 ， 类似于 LC278_E_第一个错误的版本
 * 但注意处理边界
 * <p>
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * <p>
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * <p>
 * 输入: nums = [1,3,5,6], target = 0
 * 输出: 0
 *
 * @author xiaoliang
 * @date 2021/10/18 10:05
 **/
public class LC35_E_搜索插入位置 {

    public static int searchInsert(int[] nums, int target) {
        if (nums == null) {
            throw new RuntimeException("参数错误");
        }
        // 处理边界，其余都是在数组中间插入
        if (nums.length == 0 || target <= nums[0]) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }

        // 二分法，求最左边>=target的下标位置
        int L = 0;
        int R = nums.length - 1;
        int mostLeft = R;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (nums[mid] >= target) {
                mostLeft = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return mostLeft;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6};
        int target = 5;
        System.out.println(searchInsert(arr, target));
    }
}
