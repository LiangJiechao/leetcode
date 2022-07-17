package leetcode.labuladong.la6yuandideletearray;

/**
 * 双指针法
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * @author xiaoliang
 * @date 2021/10/20 10:13
 **/
public class La4_LC283_E_移动零 {

    /**
     * 双指针法。 步骤：1、先用双指针将 !=0 的数移到前面； 2、对后面的数进行取0；
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        for (; slow < nums.length; slow++) {
            nums[slow] = 0;
        }

    }

}
