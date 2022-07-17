package recur;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * @author xiaoliang
 * @date 2021/09/23 14:49
 **/
public class 打家劫舍 {

    public static int steal1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        return process1(arr, 0);
    }

    /**
     * @param arr   房屋数组
     * @param index 目前是第几家房子
     * @return
     */
    private static int process1(int[] arr, int index) {
        if (index >= arr.length) {
            return 0;
        }
        int steal = arr[index] + process1(arr, index + 2);
        int notSteal = process1(arr, index + 1);
        return Math.max(steal, notSteal);
    }

    public static int steal2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int[] dp = new int[arr.length + 1];
        for (int i = 0; i <= arr.length; i++) {
            dp[i] = -1;
        }
        return process2(arr, 0, dp);
    }

    private static int process2(int[] arr, int index, int[] dp) {
        if (index >= arr.length) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int steal = arr[index] + process2(arr, index + 2, dp);
        int notSteal = process2(arr, index + 1, dp);
        dp[index] = Math.max(steal, notSteal);
        return dp[index];
    }

    public static int steal3(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1) {
            return arr[0];
        }

        int[] dp = new int[arr.length];
        // init
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < arr.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 9, 3, 1};
        int[] arr1 = {1, 2, 3, 1};
        System.out.println("steal1(arr) = " + steal1(arr1));
        System.out.println("steal2(arr) = " + steal2(arr));
        System.out.println("steal3(arr) = " + steal3(arr));
    }
}
