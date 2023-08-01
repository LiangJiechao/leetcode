package leetcode.labuladong2.la01_presum;

/**
 * https://leetcode.cn/problems/range-sum-query-immutable/
 * @author liangjiechao
 * @date 2023/05/14 16:58
 **/
public class La01_LC303_E_区域和检索 {

    class NumArray {

        int[] presum;

        public NumArray(int[] nums) {
            int len = nums.length;
            presum = new int[len+1];

            // 构造差分数组
            for (int i = 1; i <= len; i++) {
                presum[i] = presum[i-1] + nums[i-1];
            }
        }

        public int sumRange(int left, int right) {
            return presum[right+1] - presum[left];
        }
    }


}
