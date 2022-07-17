package zuo.baseascension.class11;

/**
 * 给定数组 arr，arr 中所有的值都为正数且不重复。
 * 每个值代表一种面值的货币，每种面值 的货币可以使用 任意张 ，再给定一个整数 aim，
 * 代表要找的钱数，问有多少种方法
 *
 * @author xiaoliang
 * @date 2021/09/22 21:34
 **/
public class Code05_CoinWays {

    public static int coinWays1(int[] coin, int aim) {
        if (coin == null || coin.length == 0 || aim < 0) {
            return -1;
        }
        return process1(coin, 0, aim);
    }

    private static int process1(int[] coin, int index, int aim) {
        if (index == coin.length) {
            return aim == 0 ? 1 : 0;
        }
        int way = 0;
        for (int zhang = 0; aim - coin[index] * zhang >= 0; zhang++) {

            way += process1(coin, index + 1, aim - coin[index] * zhang);
        }
        return way;
    }

    public static int coinWays2(int[] coin, int aim) {

        if (coin == null || coin.length == 0 || aim < 0) {
            return -1;
        }

        // 初始化dp数组
        int N = coin.length;
        int[][] dp = new int[N + 1][aim + 1];
        dp[N][0] = 1;

        for (int index = N - 1; index >= 0; index--) {
            for (int col = 0; col <= aim; col++) {
                int way = 0;
                for (int zhang = 0; col - coin[index] * zhang >= 0; zhang++) {
                    way += dp[index + 1][col - coin[index] * zhang];
                }
                dp[index][col] = way;
            }
        }
        return dp[0][aim];
    }

    public static int coinWays3(int[] coin, int aim) {

        if (coin == null || coin.length == 0 || aim < 0) {
            return -1;
        }

        // 初始化dp数组
        int N = coin.length;
        int[][] dp = new int[N + 1][aim + 1];
        dp[N][0] = 1;

        for (int index = N - 1; index >= 0; index--) {
            for (int col = 0; col <= aim; col++) {
                if (col - coin[index] >= 0) {
                    dp[index][col] = dp[index][col - coin[index]];
                }
                dp[index][col] += dp[index + 1][col];
            }
        }
        return dp[0][aim];
    }

    public static void main(String[] args) {
        long start1 = System.nanoTime();
        int way1 = coinWays1(new int[]{3, 5, 10, 2, 7}, 100);
        long end = System.nanoTime();
        System.out.println("way1 = " + way1);
        System.out.println("end- start1 = " + (end - start1));

        long start2 = System.nanoTime();
        int way2 = coinWays2(new int[]{3, 2, 5}, 10);
        end = System.nanoTime();
        System.out.println("way2 = " + way2);
        System.out.println("end- start2 = " + (end - start2));

        long start3 = System.nanoTime();
        int way3 = coinWays3(new int[]{3, 5, 10, 2, 7}, 100);
        end = System.nanoTime();
        System.out.println("way3 = " + way3);
        System.out.println("end- start3 = " + (end - start3));

    }

}
