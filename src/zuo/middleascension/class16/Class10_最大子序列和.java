package zuo.middleascension.class16;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * @author xiaoliang
 * @date 2021/10/15 11:45
 **/
public class Class10_最大子序列和 {

    public static int maxSubArray(int[] arr) {
        if (arr==null||arr.length==0) {
            throw new RuntimeException("参数错误");
        }

        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            dp[i] = arr[i] + Math.max(0,dp[i-1]);
            max = Math.max(dp[i],max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }

}
