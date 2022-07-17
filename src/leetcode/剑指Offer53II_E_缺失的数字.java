package leetcode;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，
 * 请找出这个数字。
 * <p>
 * 输入: [0,1,3]
 * 输出: 2
 *
 * @author xiaoliang
 * @date 2021/11/23 22:03
 **/
public class 剑指Offer53II_E_缺失的数字 {

    /**
     * 因为数组有序，可以用二分法
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int L = 0;
        int R = nums.length - 1;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (nums[mid] == mid) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return L;
    }

    /**
     * 鹊巢原理
     *
     * @param nums
     * @return
     */
    public int missingNumber2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

}
