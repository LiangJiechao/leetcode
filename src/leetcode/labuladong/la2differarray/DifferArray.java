package leetcode.labuladong.la2differarray;

/**
 * 差分数组工具类
 *
 * @author xiaoliang
 * @date 2022/02/23 20:51
 **/
public class DifferArray {

    // 差分数组
    private int[] diff;

    // nums: 8  5  9  6   1
    // diff: 8 -3  4 -3  -5
    public DifferArray(int[] nums) {
        diff = new int[nums.length];
        // 构造差分数组
        diff[0] = nums[0];
        for (int i = 1; i < diff.length; i++) {
            diff[i] = nums[i] - nums[i - 1] ;
        }
    }

    // 给闭区间[i,j]增加val（可以是负数）
    public void increment(int i, int j, int val) {
        diff[i] += val;
        if (j + 1 < diff.length) {
            diff[j + 1] -= val;
        }
    }

    // 返回结果数组（构造回来）
    public int[] result() {
        int[] res = new int[diff.length];
        // 根据差分数组构造结果数组
        res[0] = diff[0];
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }

}
