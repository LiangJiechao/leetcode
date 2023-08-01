package leetcode.labuladong.la3slidingwindow;

/**
 * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：[1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * <p>
 * 示例 2：
 * 输入：nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 *
 * @author xiaoliang
 * @date 2022/09/23 15:58
 **/
public class LC1004_M_最大连续1的个数III {

    public int longestOnes(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = 0;

        int res = 0;
        int change = 0;
        while (right < len) {

            if (nums[right] == 0) {
                k--;
            }
            right++;

            // 缩小窗口
            while (k < 0) {
                if (nums[left] == 0) {
                    k++;
                }
                left++;
            }

            // 记录用完k之后最长
            res = Math.max(res, right - left);
        }
        return res;
    }

    public static void main(String[] args) {
        // 还是那句话：右边无脑滑动，左边看情况收缩
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int k = 0;
        System.out.println(new LC1004_M_最大连续1的个数III().longestOnes(nums, k));
    }
}
