package zuo.middleascension.class16;

/**
 * 子序列：不需要连续也可以
 * 给定一数组，求最长递增子序列的长度
 * 如[3,1,2,6,3,4] ==> 4
 * <p>
 * 思路：看到子序列、子数组或子串问题，就想以i为结尾的情况下会怎么怎么样
 * 使用end数组，如果end[i]有效，则表示所有长度为i+1的递增子序列中最小的结尾是几
 * end数组分为有效区和无效区
 *
 * @author xiaoliang
 * @date 2021/10/09 21:11
 **/
public class Class08_最长递增子序列_使用end数组 {

    public static int getLongestSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 记录以nums[i]为结尾的最大子序列长度，可以不用
//        int[] dp = new int[nums.length];
//        dp[0] = 1;

        // 使用end数组，如果end[i]有效，则表示所有长度为i+1的递增子序列中最小的结尾
        int[] end = new int[nums.length];
        // end数组的最大下标，有效的下标
        int index = 0;
        end[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > end[index]) {
                end[++index] = nums[i];
//                dp[i] = index + 1;
            } else {
                int left = 0;
                int endRight = index;
                // 二分法找到合适插入的位置（第一个大于nums[i]的位置）
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
//                dp[i] = left + 1;
            }
        }
        return index + 1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12};
        System.out.println(getLongestSubsequence(arr));
    }
}
