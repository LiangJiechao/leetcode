package leetcode;

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
public class LC283_E_移动零 {

    /**
     * 双指针法。 步骤：1、先用双指针将 !=0 的数移到前面； 2、对后面的数进行取0；
     *
     * @param nums
     */
    public static void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int start = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[start++] = nums[i];
            }
        }
        for (int i = start; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 思路：两个指针，i指针先找出先遇到0的位置，然后j指针在i后面找非0位置，交换
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int j;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                j = i + 1;
                for (; j < nums.length; j++) {
                    if (j == nums.length) {
                        return;
                    }
                    if (nums[j] != 0) {
                        swap(nums, i, j);
                        break;
                    }
                }
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        moveZeroes2(arr);
        System.out.println(arr);
    }
}
