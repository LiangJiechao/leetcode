package recur;

/**
 * 一个机器人位于一个 m x n 网格的左上角 ,机器人每次只能向下或者向右移动一步。机器人(1,1)试图达到网格的右下角
 * 问总共有多少条不同的路径？
 *
 * @author xiaoliang
 * @date 2021/09/23 17:08
 **/
public class 机器人不同路径 {

    public static int uniquePaths1(int m, int n) {
        if (m == 0 || n == 0) {
            return -1;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        return process1(m, n, 1, 1);
    }

    private static int process1(int m, int n, int x, int y) {
        if (x > m || y > n) {
            return 0;
        }
        if (x == m && y == n) {
            return 1;
        }
        return process1(m, n, x + 1, y) + process1(m, n, x, y + 1);
    }

    // 相当于从(m,n)回到原点(1,1)
    public static int uniquePaths2(int m, int n) {
        if (m == 0 || n == 0) {
            return -1;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        return process2(m, n);
    }

    // 相当于从(m,n)回到原点(1,1)
    private static int process2(int m, int n) {
        if (m < 1 || n < 1) {
            return 0;
        }
        if (m == 1 && n == 1) {
            return 1;
        }
        return process2(m - 1, n) + process2(m, n - 1);
    }

    // 相当于从(m,n)回到原点(1,1)
    public static int uniquePaths3(int m, int n) {
        if (m == 0 || n == 0) {
            return -1;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        return process3(m, n);
    }

    // 动态规划
    private static int process3(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        // init
        for (int i = 1; i <=m ; i++) {
            dp[i][1] =1;
        }
        for (int i = 1; i <=n ; i++) {
            dp[1][i] =1;
        }

        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <=n; j++) {
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m][n];
    }

    // 相当于从(m,n)回到原点(1,1)
    public static int uniquePaths4(int m, int n) {
        if (m == 0 || n == 0) {
            return -1;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        return process4(m, n);
    }

    // 动态规划--优化空间
    private static int process4(int m, int n) {
        int[] dp = new int[n+1];
        // init
        for (int i = 1; i <=n ; i++) {
            dp[i] =1;
        }

        for (int i = 2; i <= m; i++) {
            for (int j = 1; j <=n; j++) {
                dp[j] = dp[j-1] + dp[j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        // 3 2 = 3
        // 7 3 = 28
        System.out.println("uniquePaths1(7,3) = " + uniquePaths1(7, 3));
        System.out.println("uniquePaths2(7,3) = " + uniquePaths2(7, 3));
        System.out.println("uniquePaths3(7,3) = " + uniquePaths3(7, 3));
        System.out.println("uniquePaths4(7,3) = " + uniquePaths4(7, 3));
    }
}
