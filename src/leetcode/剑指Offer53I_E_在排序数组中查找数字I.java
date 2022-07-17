package leetcode;

/**
 * 统计一个数字在排序数组中出现的次数。
 *
 * @author xiaoliang
 * @date 2021/11/24 09:35
 **/
public class 剑指Offer53I_E_在排序数组中查找数字I {

    /**
     * 思路：因为数组有序，所以可以用二分法找到最左边或最右边相等的数，然后再判断个数
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int L = 0;
        int R = nums.length - 1;

        int mid;

        while (L < R) {
            mid = L + ((R - L) >> 1);
            if (nums[mid] >= target) {
                R = mid;

            } else {
                L = mid + 1;
            }
        }

        // 判断及统计个数
        int mostLeft = R;
        int count = 0;
        while (mostLeft < nums.length && nums[mostLeft++] == target) {
            count++;
        }
        return count;

    }

    public static void main(String[] args) {
        int[] arr = {1};
        System.out.println(search(arr, 1));
    }
}
