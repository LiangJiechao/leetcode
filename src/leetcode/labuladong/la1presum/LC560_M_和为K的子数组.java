package leetcode.labuladong.la1presum;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 *
 * @author xiaoliang
 * @date 2022/02/23 16:29
 **/
public class LC560_M_和为K的子数组 {

    public int subarraySum3(int[] nums, int k) {

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = i; j < nums.length; j++) {
                temp+=nums[j];
                if (temp==k){
                    count++;
                }
            }
        }
        return count;

    }

    /**
     * 思路：前缀和记录
     * 时间复杂度 O(N^2) 空间复杂度 O(N)
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {

        int[] presum = new int[nums.length + 1];
        for (int i = 1; i < presum.length; i++) {
            presum[i] = presum[i - 1] + nums[i - 1];
        }

        int res = 0;
        for (int i = 1; i < presum.length; i++) {
            for (int j = 0; j < i; j++) {
                if (presum[i] - presum[j] == k) {
                    res++;
                }
            }
        }
        return res;
    }

    public int subarraySum2(int[] nums, int k) {
        // key：前缀和，value：key 对应的前缀和的个数
        Map<Integer, Integer> preSumFreq = new HashMap<>();
        // 对于下标为 0 的元素，前缀和为 0，个数为 1
        preSumFreq.put(0, 1);

        int preSum = 0;
        int count = 0;
        for (int num : nums) {
            preSum += num;

            // 先获得前缀和为 preSum - k 的个数，加到计数变量里
            if (preSumFreq.containsKey(preSum - k)) {
                count += preSumFreq.get(preSum - k);
            }

            // 然后维护 preSumFreq 的定义
            preSumFreq.put(preSum, preSumFreq.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }




    public static void main(String[] args) {
        LC560_M_和为K的子数组 obj = new LC560_M_和为K的子数组();
        int[] nums = {1,2,3,1,2,3,23,2,31,23,123,1,1,2,1,1};
        System.out.println(obj.subarraySum(nums, 3));
        System.out.println(obj.subarraySum2(nums, 3));
        System.out.println(obj.subarraySum3(nums, 3));
    }

}
