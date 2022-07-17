package leetcode.labuladong.binarytree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xiaoliang
 * @date 2022/02/15 17:14
 **/
public class nSum问题 {

    /**
     * nSum问题
     *
     * @param nums   排序数组
     * @param n      nSum中的 n
     * @param start
     * @param target
     * @return
     */
    public List<List<Integer>> nSum(int[] nums, int n, int start, int target) {

        List<List<Integer>> res = new LinkedList<>();

        if (n < 2 || nums.length < n) {
            return res;
        }
        if (n == 2) {
            // 设置开始下标
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

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSum(nums, 4, 0, target);
    }

    public static void main(String[] args) {
        nSum问题 obj = new nSum问题();
        int[] nums = {1, 0, -1, 0, -2, 2};

        System.out.println(obj.fourSum(nums, 0));
    }

}
