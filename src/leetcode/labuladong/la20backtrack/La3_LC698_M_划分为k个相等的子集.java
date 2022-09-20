package leetcode.labuladong.la20backtrack;

import java.util.Arrays;

/**
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 * <p>
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 *
 * @author xiaoliang
 * @date 2022/03/09 09:44
 **/
public class La3_LC698_M_划分为k个相等的子集 {

    /** 超时
     * 从数字的角度
     * 每个数字要 选择一个桶 进入
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {

        if (k > nums.length) {
            return false;
        }
//        int sum = Arrays.stream(nums).sum();
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
//        nums = Arrays.stream(nums).boxed().sorted((i1, i2) -> i2 - i1).mapToInt(Integer::valueOf).toArray();
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }

        int[] bucket = new int[k];
        int target = sum / k;
        return backtrack(nums, bucket, target, 0);

//        boolean[] used = new boolean[nums.length];
//        return backtreace(nums,0, k,target, used);
    }

    private boolean backtrack(int[] nums, int[] bucket, int target, int index) {

        if (index == nums.length) {
            boolean b = Arrays.stream(bucket).allMatch(item -> item == target);
            return b;
        }

        // 1 2 2 3 3 4 5
        for (int i = 0; i < bucket.length; i++) {
            // 剪枝，桶装装满了
            if (bucket[i] + nums[index] > target) {
                continue;
            }
            // 将 nums[index] 装⼊ bucket[i]
            bucket[i] += nums[index];
            if (backtrack(nums, bucket, target, index + 1)) {
                return true;
            }
            // 撤销选择
            bucket[i] -= nums[index];
        }
        // nums[index] 装⼊哪个桶都不⾏
        return false;
    }

    public static void main(String[] args) {

        int[] nums = {8, 2, 10, 2, 5, 6, 8, 6, 4, 2, 8, 5, 8, 4, 2, 5};
        int k = 5;
        System.out.println(new La3_LC698_M_划分为k个相等的子集().canPartitionKSubsets(nums, k));
//        System.out.println(new La3_LC698_M_划分为k个相等的子集().canPartitionKSubsets(nums, k));
    }


    private static boolean backtreace(int[] nums, int cur, int k, int target, boolean[] used) {
        if (k == 0) {
            return true;
        }
        if (cur == target) {
            return backtreace(nums, 0, k-1, target,used);
        }
        for (int j = 0; j < nums.length; j++) {
            if(used[j]){
                continue;
            }
            if (nums[j] > target - cur) {
                break;
            }
            used[j] = true;
            cur += nums[j];
            boolean backtreace = backtreace(nums, cur, k, target, used);
            if (backtreace) {
                return true;
            }
            used[j] = false;
            cur -= nums[j];
        }
        return false;
    }

}
