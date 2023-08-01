package leetcode.labuladong.la1presum;

/**
 * 给定一个整数数组  nums，处理以下类型的多个查询:
 * 计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right
 * 实现 StudentScore 类：
 * <p>
 * StudentScore(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j)
 * 返回数组 nums 中索引 left 和 right 之间的元素的 总和 ，
 * 包含 left 和 right 两点（也就是 nums[left] + nums[left + 1] + ... + nums[right] )
 *
 * @author xiaoliang
 * @date 2022/02/23 15:10
 **/
public class LC303_E_区域和检索_数组不可变 {

    /**
     * 思路：构造前缀和
     */
    class NumArray {
        // 前缀和
        // presum[2]代表前两个数的和
        private int[] presum;

        public NumArray(int[] nums) {
            presum = new int[nums.length + 1];
            // presum[0] = 0;
            for (int i = 1; i < presum.length; i++) {
                presum[i] = presum[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int left, int right) {
            return presum[right + 1] - presum[left];
        }
    }

}
