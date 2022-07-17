package leetcode;

import java.util.Arrays;

/**
 * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * 注意：不允许旋转信封。
 * <p>
 * 输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出：3
 * 解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 *
 * @author xiaoliang
 * @date 2022/01/11 19:46
 **/
public class LC354_H_俄罗斯套娃信封问题 {

    /**
     * 思路：先按宽度从小到大排列，宽度相同按高度的降序排序
     * 然后求高度的最长递增子序列
     * 即为所求
     *
     * @param envelopes
     * @return
     */
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (item1, item2) -> {
            if (item1[0] - item2[0] == 0) {
                return item2[1] - item1[1];
            } else {
                return item1[0] - item2[0];
            }
        });

        int[] help = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            help[i] = envelopes[i][1];
        }
        int res = getLongestSubsequence(help);
        return res;
    }

    public int getLongestSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 记录以nums[i]为结尾的最大子序列长度
        int[] dp = new int[nums.length];
        dp[0] = 1;

        // 使用end数组，如果end[i]有效，则表示所有长度为i+1的递增子序列中最小的结尾
        int[] end = new int[nums.length];
        // end数组的最大下标，有效的下标
        int count = 0;
        end[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > end[count]) {
                end[++count] = nums[i];
                dp[i] = count + 1;
            } else {
                int left = 0;
                int endRight = count;
                while (left < endRight) {
                    int mid = left + ((endRight - left) >> 1);
                    if (end[mid] < nums[i]) {
                        left = mid + 1;
                    } else {
                        // 注意，因为这个主要是确定left的位置
                        endRight = mid;
                    }
                }
                end[left] = nums[i];
                dp[i] = left + 1;
            }
        }
        return count + 1;
    }

}
