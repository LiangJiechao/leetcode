package offer.baidu.b20220913;

import java.util.Arrays;

/**
 * 假设一整型数组存在若干正数和负数，现在通过某种算法使得该数组的所有负数在正数的左边，
 * 且保证负数和正数间元素相对位置不变。时空复杂度要求分别为：o(n)和o(1)。
 * <p>
 * -3,1,2，-1，-3,4
 * ==> -3 -1 -3 1 2 4
 *
 * @author xiaoliang
 * @date 2022/09/27 15:40
 **/
public class Main1 {

    public int[] zfSort(int[] nums) {

        int zheng = -1;
        int fu = -1;
        for (int i = 0; i < nums.length; i++) {

            // 记录第一个要移动的负数的位置(前提是先找到了第一个正数的位置)
            if (nums[i] < 0 && zheng >= 0) {
                fu = i;
            }
            // 记录第一个正数的位置
            if (nums[i] > 0 && zheng < 0) {
                zheng = i;
            }

            // 移动位置
            if (fu >= 0 && zheng >=0) {
                int tmp = nums[fu];

                for (int j = fu; j > zheng ; j--) {
                    nums[j] = nums[j-1];
                }
                nums[zheng] = tmp;

                // 正数位置移动一个
                zheng++;
                // 需要重新找负数的位置
                fu = -1;
            }

        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1,-3, 1, 2, -1, -3, 4,-2};
        System.out.println(Arrays.toString(new Main1().zfSort(nums)));
    }
}
