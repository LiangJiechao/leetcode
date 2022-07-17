package leetcode.labuladong.la23dp;

/**
 * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 * 输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
 * 输出：3
 * 解释：长度最长的公共子数组是 [3,2,1] 。
 * @author xiaoliang
 * @date 2022/04/01 10:52
 **/
public class LC718_M_最长重复子数组 {

    public int findLength(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        // dp[i][j] 表示以nums[i-1]和nums[j-1]结尾的最大重复子数组的长度
        int[][] dp = new int[len1+1][len2+1];
        int res = 0;
        for(int i =1;i<=len1;i++){
            for(int j = 1;j<=len2;j++){

                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                res = Math.max(dp[i][j],res);
            }
        }
        return res;
    }
}
