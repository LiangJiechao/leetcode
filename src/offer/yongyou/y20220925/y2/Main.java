package offer.yongyou.y20220925.y2;

/**
 * @author xiaoliang
 * @date 2022/09/25 15:55
 **/
public class Main {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 在一个三维直角坐标系中，有一只蚂蚁从原点 (0, 0, 0) 开始，向目标点 (l, m, n) 前进，蚂蚁的前进规则如下：
     * 1、l, m, n >= 0，且 l + m + n > 0；
     * 2、蚂蚁每次只能沿X/Y/Z轴的方向前进一个单位，比如，当前蚂蚁在点(x0, y0, z0)，下一步只能前进到下面三个点中的任意一个：(x0 + 1, y0, z0)，或(x0, y0 + 1, z0)​，或(x0, y0, z0 + 1)​。
     * <p>
     * 返回所有可以从​原点 (0, 0, 0) 到目标点 (l, m, n) 的​可行路径数量。
     *
     * @param x int整型 目标点的X坐标
     * @param y int整型 目标点的Y坐标
     * @param z int整型 目标点的Z坐标
     * @return long长整型
     */
    public long countPaths(int x, int y, int z) {
        // write code here
        long[][][] dp = new long[x + 1][y + 1][z + 1];

        // init
        for (int i = 0; i <= x; i++) {
            dp[i][0][0] = 1;
        }
        for (int i = 0; i <= y; i++) {
            dp[0][i][0] = 1;
        }
        for (int i = 0; i <= z; i++) {
            dp[0][0][i] = 1;
        }

        for (int i = 1; i <=x; i++) {
            for (int j = 1; j <=y; j++) {
                dp[i][j][0] = dp[i-1][j][0] + dp[i][j-1][0];
            }
        }
        for (int i = 1; i <=x; i++) {
            for (int j = 1; j <=z; j++) {
                dp[i][0][j] = dp[i-1][0][j] + dp[i][0][j-1];
            }
        }
        for (int i = 1; i <=y; i++) {
            for (int j = 1; j <=z; j++) {
                dp[0][i][j] = dp[0][i-1][j] + dp[0][i][j-1];
            }
        }

        for (int i = 1; i <=x; i++) {
            for (int j = 1; j <= y; j++) {
                for (int k = 1; k <=z; k++) {
                    dp[i][j][k] = (dp[i-1][j][k] +dp[i][j-1][k]+ dp[i][j][k-1]) ;
                }
            }
        }
        return dp[x][y][z];
    }

    public static void main(String[] args) {
        System.out.println(new Main().countPaths(1, 1, 1));
    }

}
