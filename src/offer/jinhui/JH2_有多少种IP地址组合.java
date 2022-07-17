package offer.jinhui;

/**
 * @author xiaoliang
 * @date 2022/04/12 10:55
 **/
public class JH2_有多少种IP地址组合 {

    /**
     * 题目：给定一个字符串，里面是无重复的数字，
     * 求用这些数字组合，可重复，看能组成ip地址的数量
     *
     * @param s
     * @return
     */
    static int res = 0;

    public static int ipCount(String s) {
        char[] arr = s.toCharArray();
        int[] nums = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i] - '0';
        }

        dfs(nums, -1);
        return (int) Math.pow(res, 4);
    }

    private static void dfs(int[] nums, int sum) {

        if (sum >= 0 && sum <= 255) {
            res++;
        } else if (sum > 255) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (sum == -1) {
                sum = 0;
            }
            sum = sum * 10 + nums[i];
            dfs(nums, sum);
            sum = (sum - nums[i]) / 10;
        }
    }

}
