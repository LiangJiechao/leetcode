package b;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xiaoliang
 * @version 1.0
 * @description: 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * <p>
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * @date 2021/6/26 16:03
 */
public class FindRepeatNumber {

    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            } else {
                set.add(nums[i]);
            }

        }
        return -1;
    }

    public int findRepeatNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            //If this set already contains the element, the call leaves the set unchanged and returns <tt>false</tt>.
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }

    public int findRepeatNumber3(int[] nums) {
        //这里因为题目特殊，可以使用该方法
        //利用下标交换，保证下标 == 元素值
        for (int i = 0; i < nums.length; i++) {

            while (nums[i] != i && nums[nums[i]] != nums[i]) {
                // 满足条件则交换，不满足，则找到了元素
                swap(nums, i, nums[i]);
            }
            if (nums[i] != i && nums[nums[i]] == nums[i]) {
                return nums[i];
            }
        }
        return -1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
    }

}
