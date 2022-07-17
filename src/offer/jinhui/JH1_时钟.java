package offer.jinhui;

/**
 * @author xiaoliang
 * @date 2022/04/12 10:34
 **/
public class JH1_时钟 {

    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {

            System.out.println(shizhong(i) == jinhui(i));
        }

    }

    // 时钟：从0点开始走（左右都可以），走n步，能回到原地的走法
    public static int shizhong(int n) {

        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int[][] dp = new int[12][n + 1];
        dp[0][0] = 1;

        for (int j = 1; j <= n; j++) {
            for (int i = 0; i < 12; i++) {
                dp[i][j] = dp[(i + 12 - 1) % 12][j - 1] + dp[(i + 12 + 1) % 12][j - 1];
            }
        }
        return dp[0][n];
    }

    public static int jinhui(int n) {
        int[][] dp = new int[12][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 12; j++) {
                dp[j][i] = dp[(j - 1 + 12) % 12][i - 1] + dp[(j + 1 + 12) % 12][i - 1];
            }
        }
        return dp[0][n];
    }
}
