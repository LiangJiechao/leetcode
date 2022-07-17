package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *
 * @author xiaoliang
 * @date 2021/12/19 17:50
 **/
public class 剑指Offer39_E_数组中出现次数超过一半的数字 {

    /**
     * 解法：摩尔投票法
     * 也可以理解成混战极限一换一，不同的两者一旦遇见就同归于尽，最后活下来的值都是相同的，即要求的结果
     * 时间O(n)，空间O(1)
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {

        int res = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                res = num;
                count++;
            } else {
                count += res == num ? 1 : -1;
            }
        }

        return res;
    }

    /**
     * 解法：用map
     *
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        int half = nums.length >> 1;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > half) {
                return num;
            }
        }
        return -1;
    }

}
