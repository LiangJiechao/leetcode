package leetcode.dp;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * <p>
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 * @author xiaoliang
 * @date 2021/10/25 16:19
 **/
public class LC198_M_打家劫舍 {

    /**
     * 动态规划
     *
     * @param arr
     * @return
     */
    public static int rob3(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new RuntimeException("参数错误");
        }

        if (arr.length == 1) {
            return arr[0];
        } else if (arr.length == 2) {
            return Math.max(arr[0], arr[1]);
        }

        int[] dp = new int[arr.length];
        // init
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);

        }
        return dp[arr.length - 1];
    }

    /**
     * 记忆化递归
     *
     * @param arr
     * @return
     */
    public static int rob2(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new RuntimeException("参数错误");
        }
        int[] dp = new int[arr.length + 1];
        for (int i = 0; i <= arr.length; i++) {
            dp[i] = -1;
        }
        return process2(0, arr, dp);
    }

    private static int process2(int i, int[] arr, int[] dp) {
        // base case
        if (i >= arr.length) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int steal = arr[i] + process2(i + 2, arr, dp);
        int notSteal = process2(i + 1, arr, dp);
        dp[i] = Math.max(steal, notSteal);
        return dp[i];
    }

    /**
     * 暴力递归
     *
     * @param arr
     * @return
     */
    public static int rob1(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new RuntimeException("参数错误");
        }
        return process1(0, arr);
    }

    private static int process1(int i, int[] arr) {

        // base case
        if (i >= arr.length) {
            return 0;
        }
        int steal = arr[i] + process1(i + 2, arr);
        int notSteal = process1(i + 1, arr);
        return Math.max(steal, notSteal);
    }

    public static int check(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1) {
            return arr[0];
        } else if (arr.length == 2) {
            return Math.max(arr[0], arr[1]);
        }

        int[] dp = new int[arr.length];
        // init
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < arr.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
        }
        return dp[arr.length - 1];
    }

    public static void main(String[] args) {
        int[] arr = {114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53, 108, 200, 91, 80, 223, 58, 170, 110, 236, 81, 90, 222, 160, 165, 195, 187, 199, 114, 235, 197, 187, 69, 129, 64, 214, 228, 78, 188, 67, 205, 94, 205, 169, 241, 202, 144, 240};
        System.out.println(check(arr) == rob3(arr));
    }
}
