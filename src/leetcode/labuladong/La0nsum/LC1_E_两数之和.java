package leetcode.labuladong.La0nsum;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，
 * 并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * @author xiaoliang
 * @date 2022/02/15 16:41
 **/
public class LC1_E_两数之和 {

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            Integer temp = map.get(sub);
            if (temp != null && temp != i) {
                res[0] = i;
                res[1] = temp;
                return res;
            }
        }
        return res;
    }

    /**
     * nSum问题
     *
     * @param nums   排序数组
     * @param n      nSum中的n
     * @param start  开始下标
     * @param target 目标
     * @return
     */
    public static List<List<Integer>> nSum(int[] nums, int n, int start, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if (n < 2 || nums.length < n) {
            return res;
        }
        if (n == 2) {
            int left = 0;
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
        } else {
            // n>2
            for (int i = start; i < nums.length; i++) {
                List<List<Integer>> nSumList = nSum(nums, n - 1, i + 1, target - nums[i]);
                for (List<Integer> list : nSumList) {
                    list.add(0, nums[i]);
                    res.add(list);
                }
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }

        }
        return res;
    }

}
