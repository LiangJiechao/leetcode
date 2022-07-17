package leetcode.labuladong.la6yuandideletearray;

/**
 * 原地删除数组元素
 * 将最终结果插入 nums 的前 k 个位置后返回 k 。
 *
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
 * 输出：5, nums = [0,1,2,3,4]
 *
 * @author xiaoliang
 * @date 2022/02/24 22:25
 **/
public class La1_LC26_E_删除有序数组中的重复项 {

    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                // 维护 0..slow间的元素有序
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}
