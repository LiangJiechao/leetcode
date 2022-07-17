package zuo.baseascension.class11;

/**
 * 中国象棋中（10行，9列），马，从s(0,0)位置到 e位置，跳 k步，有多少种解
 *
 * @author xiaoliang
 * @date 2021/09/22 15:30
 **/
public class Code03_HorseJump {

    public static int horseJump1(int x, int y, int k) {
        if (x < 0 || x > 10 || y < 0 || y > 9 || k < 0) {
            throw new RuntimeException("输入参数错误！");
        }
        return process1(x, y, k);
    }

    /**
     * 递归法
     * 默认起点位置为(0,0)
     *
     * @param x    目标位置的横坐标
     * @param y    目标位置的纵坐标
     * @param rest 可以跳的步数
     * @return
     */
    private static int process1(int x, int y, int rest) {

        if (x < 0 || x > 10 || y < 0 || y > 9) {
            return 0;
        }
        // base case
        if (rest == 0) {
            return (x == 0 && y == 0) ? 1 : 0;
        }
        return process1(x - 2, y + 1, rest - 1)
                + process1(x - 1, y + 2, rest - 1)
                + process1(x + 1, y + 2, rest - 1)
                + process1(x + 2, y + 1, rest - 1)
                + process1(x + 2, y - 1, rest - 1)
                + process1(x + 1, y - 2, rest - 1)
                + process1(x - 1, y - 2, rest - 1)
                + process1(x - 2, y - 1, rest - 1);
    }

    public static int horseJump2(int x, int y, int step) {
        if (x < 0 || x > 10 || y < 0 || y > 9 || step < 0) {
            throw new RuntimeException("输入参数错误！");
        }
        int[][][] dp = new int[10 + 1][9 + 1][step + 1];
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= step; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return process2(x, y, step, dp);
    }

    /**
     * 记忆版递归法
     *
     * @param x
     * @param y
     * @param rest
     * @param dp
     * @return
     */
    private static int process2(int x, int y, int rest, int[][][] dp) {

        if (x < 0 || x > 10 || y < 0 || y > 9) {
            return 0;
        }
        if (dp[x][y][rest] != -1) {
            return dp[x][y][rest];
        }
        // base case
        if (rest == 0) {
            dp[x][y][rest] = (x == 0 && y == 0) ? 1 : 0;
            return dp[x][y][rest];
        }
        dp[x][y][rest] = process2(x - 2, y + 1, rest - 1, dp)
                + process2(x - 1, y + 2, rest - 1, dp)
                + process2(x + 1, y + 2, rest - 1, dp)
                + process2(x + 2, y + 1, rest - 1, dp)
                + process2(x + 2, y - 1, rest - 1, dp)
                + process2(x + 1, y - 2, rest - 1, dp)
                + process2(x - 1, y - 2, rest - 1, dp)
                + process2(x - 2, y - 1, rest - 1, dp);
        return dp[x][y][rest];
    }

    /**
     * 动态规划法
     * @param x
     * @param y
     * @param step
     * @return
     */
    public static int horseJump3(int x, int y, int step) {
        if (x < 0 || x > 10 || y < 0 || y > 9 || step < 0) {
            throw new RuntimeException("输入参数错误！");
        }
        int[][][] dp = new int[10 + 1][9 + 1][step + 1];
        // 初始化dp数组
        dp[0][0][0] = 1;
        for (int k = 1; k <= step; k++) {
            for (int i = 0; i <= 10; i++) {
                for (int j = 0; j <= 9; j++) {
                    dp[i][j][k] = getValue(i-2,j+1,k-1,dp)
                            +getValue(i-1,j+2,k-1,dp)
                            +getValue(i+1,j+2,k-1,dp)
                            +getValue(i+2,j+1,k-1,dp)
                            +getValue(i+2,j-1,k-1,dp)
                            +getValue(i+1,j-2,k-1,dp)
                            +getValue(i-1,j-2,k-1,dp)
                            +getValue(i-2,j-1,k-1,dp);
                }
            }
        }
        return dp[x][y][step];
    }

    private static int getValue(int x, int y, int h, int[][][] dp) {
        if (x < 0 || x > 10 || y < 0 || y > 9 || h < 0){
            return 0;
        }
        return dp[x][y][h];
    }

    public static void main(String[] args) {

        long start1 = System.nanoTime();
        int ways1 = horseJump1(7, 7, 10);
        System.out.println("ways1 = " + ways1);
        long end = System.nanoTime();
        System.out.println("耗时==>" + (end - start1));

        long start2 = System.nanoTime();
        int ways2 = horseJump2(7, 7, 10);
        System.out.println("ways2 = " + ways2);
        end = System.nanoTime();
        System.out.println("耗时==>" + (end - start2));

        long start3 = System.nanoTime();
        int ways3 = horseJump3(7, 7, 10);
        System.out.println("ways3 = " + ways3);
        end = System.nanoTime();
        System.out.println("耗时==>" + (end - start3));
    }

}
