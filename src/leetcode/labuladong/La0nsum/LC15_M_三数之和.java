package leetcode.labuladong.La0nsum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * <p>
 * 输入：nums = []
 * 输出：[]
 * 输入：nums = [0]
 * 输出：[]
 *
 * @author xiaoliang
 * @date 2021/11/05 20:33
 **/
public class LC15_M_三数之和 {

    /**
     * nums为排序数组
     * 从start位置开始，找两数之和为target的数对1
     *
     * @param nums
     * @param start
     * @param target
     * @return
     */
    public static List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length < 2) {
            return res;
        }
        // nums为排序数组
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            int leftNum = nums[left];
            int rightNum = nums[right];
            int sum = leftNum + rightNum;
            if (sum < target) {
                while (left < right && nums[left] == leftNum) {
                    left++;
                }
            } else if (sum > target) {
                while (left < right && nums[right] == rightNum) {
                    right--;
                }
            } else {
                // sum == target
                List<Integer> list = new LinkedList<>();
                list.add(leftNum);
                list.add(rightNum);
                res.add(list);
                while (left < right && nums[left] == leftNum) {
                    left++;
                }
                while (left < right && nums[right] == rightNum) {
                    right--;
                }
            }
        }
        return res;
    }

    /**
     * 思路：利用twoSum
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        int[] arr = Arrays.stream(nums).sorted().toArray();
        for (int i = 0; i < arr.length; i++) {
            List<List<Integer>> twoSumList = twoSum(arr, i + 1, target - arr[i]);
            for (List<Integer> twoSum : twoSumList) {
                twoSum.add(0, arr[i]);
                res.add(twoSum);
            }

            // 跳过第一个数字重复的情况，否则会出现重复结果
            while (i < arr.length - 1 && arr[i] == arr[i + 1]) {
                i++;
            }
        }
        return res;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        return threeSum(nums, 0);
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1};
        System.out.println(threeSum(arr));
    }

}
