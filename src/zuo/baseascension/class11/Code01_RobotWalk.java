package zuo.baseascension.class11;

import java.util.Arrays;

/**
 * 1~n个位置，机器人从 s 开始到 e ，走k步，有几种走法
 *
 * @author xiaoliang
 * @date 2021/09/22 09:58
 **/
public class Code01_RobotWalk {

    public static int robotWalk1(int n, int s, int k, int e) {
        if (n < 2 || s < 1 || s > n || e < 1 || e > n || k < 0) {
            return 0;
        }
        return walk1(n, s, k, e);
    }

    /**
     * 纯递归法
     *
     * @param n    n个位置
     * @param cur  当前位置
     * @param rest 剩下步数
     * @param aim  目标位置
     * @return
     */
    public static int walk1(int n, int cur, int rest, int aim) {

        if (rest == 0) { // base case
            return cur == aim ? 1 : 0;
        } else if (cur == 1) {
            return walk1(n, cur + 1, rest - 1, aim);
        } else if (cur == n) {
            return walk1(n, cur - 1, rest - 1, aim);
        } else {
            return walk1(n, cur - 1, rest - 1, aim) + walk1(n, cur + 1, rest - 1, aim);
        }
    }

    public static int robotWalk2(int n, int s, int k, int e) {
        if (n < 2 || s < 1 || s > n || e < 1 || e > n || k < 0) {
            return 0;
        }
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],-1);
        }

        return walk2(n, s, k, e, dp);
    }

    /**
     * 记忆化递归法
     *
     * @param n
     * @param cur
     * @param rest
     * @param aim
     * @param dp   dp数组，记录递归中算出的值
     * @return
     */
    public static int walk2(int n, int cur, int rest, int aim, int[][] dp) {

        if (dp[cur][rest] != -1) {
            return dp[cur][rest];
        }
        if (rest == 0) {
            dp[cur][rest] = cur == aim ? 1 : 0;
        } else if (cur == 1) {
            dp[cur][rest] = walk2(n, cur + 1, rest - 1, aim, dp);
        } else if (cur == n) {
            dp[cur][rest] = walk2(n, cur - 1, rest - 1, aim, dp);
        } else {
            dp[cur][rest] = walk2(n, cur - 1, rest - 1, aim, dp) + walk2(n, cur + 1, rest - 1, aim, dp);
        }

        return dp[cur][rest];
    }

    public static int robotWalk3(int n, int s, int k, int e) {
        if (n < 2 || s < 1 || s > n || e < 1 || e > n || k < 0) {
            return 0;
        }
        return walk3(n, s, k, e);
    }

    /**
     * 动态规划法
     *
     * @param n
     * @param cur
     * @param rest
     * @param aim
     * @return
     */
    public static int walk3(int n, int cur, int rest, int aim) {

        int[][] dp = new int[rest + 1][n + 1];

        // 初始化dp数组
        dp[0][aim] = 1;

        for (int i = 1; i <= rest; i++) {
            for (int j = 1; j <= n; j++) {
                if (j == 1) {
                    dp[i][j] = dp[i - 1][j + 1];
                } else if (j == n) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                }
            }
        }
        return dp[rest][cur];
    }

    public static int robotWalk4(int n, int s, int k, int e) {
        if (n < 2 || s < 1 || s > n || e < 1 || e > n || k < 0) {
            return 0;
        }
        return walk4(n, s, k, e);
    }

    /**
     * 动态规划法--优化空间
     */
    public static int walk4(int n, int cur, int rest, int aim) {

        int[] dp = new int[n + 2];

        // 初始化dp数组
        dp[aim] = 1;

        for (int i = 1; i <= rest; i++) {
            int pre =0;
            for (int j = 1; j <= n; j++) {
                // todo 这里注意
                int temp = dp[j];
                dp[j] = pre + dp[j + 1];
                pre= temp;
            }
        }
        return dp[cur];
    }

    public static void main(String[] args) {

        long start = System.nanoTime();
        int times1 = robotWalk1(20, 7, 14, 9);
        System.out.println("times1 = " + times1);
        long end = System.nanoTime();
        System.out.println("end - start = " + (end - start));

        start = System.nanoTime();
        int times2 = robotWalk2(20, 7, 14, 9);
        end = System.nanoTime();
        System.out.println("times2 = " + times2);
        System.out.println("end - start = " + (end - start));

        start = System.nanoTime();
        int times3 = robotWalk3(20, 7, 14, 9);
        end = System.nanoTime();
        System.out.println("times3 = " + times3);
        System.out.println("end - start = " + (end - start));

        start = System.nanoTime();
        int times4 = robotWalk4(20, 7, 14, 9);
        end = System.nanoTime();
        System.out.println("times4 = " + times4);
        System.out.println("end - start = " + (end - start));



    }

}
