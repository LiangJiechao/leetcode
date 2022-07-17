package offer.huawei.class2;

import java.util.Arrays;

/**
 * 数组中有正 负 0
 * 让两个数加起来的绝对值尽量小
 * 返回最小的数
 *
 * @author xiaoliang
 * @date 2022/03/28 22:04
 **/
public class Solution {

    public int getSmallSum(int[] nums) {
        int[] sortedNums = Arrays.stream(nums).boxed().sorted((i1, i2) -> {
            return Math.abs(i1) - Math.abs(i2);
        }).mapToInt(Integer::valueOf).toArray();

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < sortedNums.length; i++) {
            int temp = Math.abs(sortedNums[i - 1] + sortedNums[i]);
            if (temp < min) {
                min = temp;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = {-7, -5, -5, -3, 2, 1, 0, 9, 8, 6, 4, 5};
        System.out.println(new Solution().getSmallSum(nums));
    }
}
