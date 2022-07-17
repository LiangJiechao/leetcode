package leetcode;

import java.util.Arrays;

/**
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，
 * 而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * 限制：
 * 数组长度为 5
 * 数组的数取值为 [0, 13]
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: True
 * 输入: [0,0,1,2,5]
 * 输出: True
 *
 * @author xiaoliang
 * @date 2021/12/10 10:25
 **/
public class 剑指Offer61_E_扑克牌中的顺子 {

    /**
     * 如果重复，肯定错误。
     * 如果不存在0，则最大值最小值之差必定为4
     * 其他情况，最大值最小值之差小于4即可
     *
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {
        if (nums == null || nums.length != 5) {
            return false;
        }
        Arrays.sort(nums);
        int zero = 0;
        int max = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == 0) {
                zero++;
                continue;
            }
            if (nums[i] == nums[i - 1]) {
                return false;
            }
        }
        int min = nums[zero];

        return zero == 0 ? max - min == 4 : max - min <= 4;
    }
}
