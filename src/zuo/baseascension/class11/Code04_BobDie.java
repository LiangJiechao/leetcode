package zuo.baseascension.class11;

/**
 * bob在网格(N*M)里，走k步，只能上下左右走，bob如果走出网格，则死亡；求bob活下来的概率 = (活下来的次数)/(4^k)
 * @author xiaoliang
 * @date 2021/09/22 19:56
 **/
public class Code04_BobDie {

    /**
     *
     * @param m 网格边界
     * @param n 网格边界
     * @param x 当前行坐标
     * @param y 当前纵坐标
     * @param rest 剩余步数
     * @return
     */
    public static String getBobChanceOfSurvival1(int m, int n, int x, int y, int rest) {

        double pow = Math.pow(4, rest);
        int live = process1(m,n,x,y,rest);
        return live+"/"+pow;
    }

    /**
     * 递归法
     */
    private static int process1(int m, int n, int x, int y, int rest) {
        if (x<0||x==m||y<0||y==n){
            return 0;
        }
        if (rest ==0){
            return 1;
        }

        return process1(m,n,x-1,y,rest-1)
                +process1(m,n,x+1,y,rest-1)
                +process1(m,n,x,y-1,rest-1)
                +process1(m,n,x,y+1,rest-1);
    }

    /**
     * 动态规划
     * @param m 网格边界
     * @param n 网格边界
     * @param x 当前行坐标
     * @param y 当前纵坐标
     * @param rest 剩余步数
     * @return
     */
    public static String getBobChanceOfSurvival2(int m, int n, int x, int y, int rest) {

        double pow = Math.pow(4, rest);
        int live = process2(m,n,x,y,rest);

        return live+"/"+pow;
    }

    // 动态规划
    private static int process2(int m, int n, int x, int y, int rest) {
        if (x<0||x==m||y<0||y==n){
            return 0;
        }

        int[][][] dp = new int[m+2][n+2][rest+1];
        // 初试化dp数组，m*n 内是1，其余地方为0，设为 n+2 m+2是为了统一处理，不越界
        for (int i = 1; i <=m; i++) {
            for (int j = 1; j <=n; j++) {
                dp[i][j][0] = 1;
            }
        }

        for (int k = 1; k <=rest; k++) {
            for (int i = 1; i <=m; i++) {
                for (int j = 1; j <=n; j++) {
                    dp[i][j][k] += dp[i-1][j][k-1]
                            + dp[i+1][j][k-1]
                            + dp[i][j-1][k-1]
                            + dp[i][j+1][k-1];
                }
            }
        }
        return dp[x+1][y+1][rest];
    }


    // 求两个数的最大公因数
    public static long gcd(long m ,long n){
        return n==0?m:gcd(n,m%n);
    }

    public static void main(String[] args) {
        System.out.println("getBobChanceOfSurvival1(10, 9, 4, 5, 10) = " + getBobChanceOfSurvival1(10, 9, 4, 5, 10));
        System.out.println("getBobChanceOfSurvival2(10, 9, 4, 5, 10) = " + getBobChanceOfSurvival2(10, 9, 4, 5, 10));

    }
}
