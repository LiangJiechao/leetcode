package test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 有 m 道菜，每道菜只有 1 份。有 n 个顾客，每个顾客都有想两份要点的菜。
 * 只有当顾客吃到全部自己想要的菜的时候，顾客才会满意。
 * 你的任务是，合理地接取顾客的订单要求，尽可能让更多的顾客满意，
 * 输出最多有多少顾客可以满意。
 * n <= 20, m <= 40。
 * 输入
 * 20
 * 3
 * 1 2
 * 3 4
 * 2 3
 *
 * @author xiaoliang
 * @date 2022/03/13 15:46
 **/
public class A {

    //    public static void main(String[] args) {
//        int[] nums = {4,5,6,7,8,0,1,2};
//        int target = 8;
//        System.out.println(search(nums, target));
//    }
    public static int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1, mid = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 先根据 nums[mid] 与 nums[lo] 的关系判断 mid 是在左段还是右段
            if (nums[mid] >= nums[lo]) {
                // 再判断 target 是在 mid 的左边还是右边，从而调整左右边界 lo 和 hi
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int maxProduct(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;

        int res = Integer.MIN_VALUE;
        // dp[i][j][0] 代表以第i,j格子为结尾的最大乘积
        // dp[i][j][1] 代表以第i,j格子为结尾的最小乘积
        int[][][] dp = new int[m][n][2];
        // init 初始化dp数组
        dp[0][0][0] = nums[0][0];
        dp[0][0][1] = nums[0][0];
        for (int i = 1; i < m; i++) {
            int a = dp[i - 1][0][0] * nums[i][0];
            int b = dp[i - 1][0][1] * nums[i][0];
            dp[i][0][0] = max(a, b, nums[i][0]);
            dp[i][0][1] = min(a, b, nums[i][0]);
            res = Math.max(res, dp[i][0][0]);
        }
        for (int i = 1; i < n; i++) {
            int a = dp[0][i - 1][0] * nums[0][i];
            int b = dp[0][i - 1][1] * nums[0][i];
            dp[0][i][0] = max(a, b, nums[0][i]);
            dp[0][i][1] = min(a, b, nums[0][i]);
            res = Math.max(res, dp[0][i][0]);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int a = dp[i - 1][j][0] * nums[i][j];
                int b = dp[i][j - 1][0] * nums[i][j];

                int c = dp[i - 1][j][1] * nums[i][j];
                int d = dp[i][j - 1][1] * nums[i][j];

                dp[i][j][0] = max(nums[i][j], a, b, c, d);
                dp[i][j][1] = max(nums[i][j], a, b, c, d);

                res = Math.max(res, dp[i][j][0]);
            }
        }

        return res;
    }

    // 压缩空间
    public static int maxProduct2(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;

        int res = Integer.MIN_VALUE;
        // dp[i][j][0] 代表以第i,j格子为结尾的最大乘积
        // dp[i][j][1] 代表以第i,j格子为结尾的最小乘积
        int[][] dp = new int[n][2];
        // init
        dp[0][0] = 1;
        dp[0][1] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    int a = dp[j][0] * nums[i][j];
                    int b = dp[j][1] * nums[i][j];

                    dp[j][0] = max(nums[i][j], a, b);
                    dp[j][1] = min(nums[i][j], a, b);
                } else {
                    // 这里 dp[j][0]是代表上一行的
                    int a = dp[j][0] * nums[i][j];
                    int b = dp[j][1] * nums[i][j];
                    int c = dp[j - 1][0] * nums[i][j];
                    int d = dp[j - 1][1] * nums[i][j];

                    dp[j][0] = max(nums[i][j], a, b, c, d);
                    dp[j][1] = min(nums[i][j], a, b, c, d);
                }

                res = Math.max(res, dp[j][0]);
            }
        }

        return res;
    }

    public static int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    public static int max(int a, int b, int c, int d, int e) {
        return Math.max(Math.max(Math.max(a, b), Math.max(c, d)), e);
    }

    public static int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    public static int min(int a, int b, int c, int d, int e) {
        return Math.min(Math.min(Math.min(a, b), Math.min(c, d)), e);
    }

    public static void main(String[] args) {
//        int[][] nums = {{-2 - 3 - 6}, {10, 2, -2}};
        int[][] nums = {{1, 2, -3, 4}, {0, 1, 3, -4}, {6, -5, 1, 2}};
//        int[][] nums = {{2, 2, 2, 2}, {2, 2, 2, 2}};
//        System.out.println(jinhui(nums));
//        System.out.println(maxProduct(nums));
//        System.out.println(maxProduct2(nums));

//        Integer a = 1;
//        Integer b = 2;
//        Integer c = 3;
//        Integer d = 3;
//        Integer e = 321;
//        Integer f = 321;
//        Long g = 3L;
//        System.out.println(c == d); // true
//        System.out.println(e == f);// false
//        System.out.println(c == (a+b));// true
//        System.out.println(c.equals(a+b));// true
//        System.out.println(g == (a+b));// true
//        System.out.println(g.equals(a+b)); //false

        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Long g = 3L;
        int int1 = 12;
        int int2 = 12;
        Integer integer1 = new Integer(12);
        Integer integer2 = new Integer(12);
        Integer integer3 = new Integer(1);
        System.out.println("c==(a+b) ->" + (c == (a + b)));
        System.out.println("g==(a+b) ->" + (g == (a + b)));
        System.out.println("c.equals(a+b) ->" + (c.equals(a + b)));
        System.out.println("g.equals(a+b) ->" + (g.equals(a + b)));
        System.out.println("int1 == int2 -> " + (int1 == int2));
        System.out.println("int1 == integer1 -> " + (int1 == integer1));
        System.out.println("integer1 == integer2 -> " + (integer1 == integer2));
        System.out.println("integer3 == a1 -> " + (integer3 == a));

        Deque<Integer> stack = new LinkedList<>();

    }

    /*
*
*
    -2 -3 -6
    10  2 -2
* */
    public static int jinhui(int[][] nums) {
        int row = nums.length;
        int col = nums[0].length;
        int[][] dp = new int[col][2];
        dp[0][0] = 1;//nums[0][0];//  1;
        dp[0][1] = 1;//nums[0][0];// 1;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int cur = nums[i][j];
                if (j == 0) {
                    int a = dp[j][0] * cur;
                    int b = dp[j][1] * cur;
                    dp[j][0] = Math.min(Math.min(a, b), cur);
                    dp[j][1] = Math.max(Math.max(a, b), cur);
                } else {
                    int a = dp[j - 1][0] * cur;
                    int b = dp[j - 1][1] * cur;
                    int c = dp[j][0] * cur;
                    int d = dp[j][1] * cur;
                    dp[j][0] = Math.min(Math.min(Math.min(a, b), Math.min(c, d)), cur);
                    dp[j][1] = Math.max(Math.max(Math.max(a, b), Math.max(c, d)), cur);
                }
                ans = Math.max(ans, dp[j][1]);
            }
        }
        return ans;
    }
}
