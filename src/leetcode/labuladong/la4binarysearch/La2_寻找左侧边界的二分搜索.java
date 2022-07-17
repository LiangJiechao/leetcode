package leetcode.labuladong.la4binarysearch;

/**
 * ⽐如说给你有序数组 nums = [1,2,2,2,3]，target 为 2，此算法返回的索引是 2，没错。但是如果我想
 * 得到 target 的左侧边界，即索引 1，或者我想得到 target 的右侧边界，即索引 3
 * 不存在则返回-1
 *
 * @author xiaoliang
 * @date 2022/02/24 16:06
 **/
public class La2_寻找左侧边界的二分搜索 {

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
            // 因为是找最左侧，所以从右边逼近
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

    public static void main(String[] args) {
        La2_寻找左侧边界的二分搜索 obj = new La2_寻找左侧边界的二分搜索();
        int[] nums = {1, 2, 2, 2, 3, 5, 6, 7};
        int target = 8;
        for (int i = 0; i < 10; i++) {
            target = i;
            System.out.println(obj.leftBound(nums, target));
            System.out.println(obj.rightBound(nums, target));
            System.out.println("---");
        }

    }
}
