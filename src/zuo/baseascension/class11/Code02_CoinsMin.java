package zuo.baseascension.class11;

/**
 * 给定一个硬币数组[2,7,3,5,3,1,..]；给找零 aim=10，怎么是硬币数最少
 *
 * @author xiaoliang
 * @date 2021/09/22 14:29
 **/
public class Code02_CoinsMin {

    public static int minCoins1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        return process1(arr, 0, aim);
    }

    private static int process1(int[] arr, int i, int aim) {

        if (aim < 0) {
            return -1;
        }

        if (aim == 0) {
            return 0;
        }
        // aim > 0
        if (i == arr.length) {
            return -1;
        }

        int take = process1(arr, i + 1, aim - arr[i]);
        int noTake = process1(arr, i + 1, aim);

        if (take == -1 && noTake == -1) {
            return -1;
        } else {
            if (take == -1) {
                return noTake;
            } else if (noTake == -1) {
                return take + 1;
            }
            return Math.min(noTake, take + 1);
        }
    }

    public static int minCoins2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        int[][] dp = new int[arr.length+1][aim + 1];
        // 初始化dp数组
        for (int i = 0; i <= arr.length; i++) {
            for (int j = 0; j <= aim; j++) {
                dp[i][j] = -2;
            }
        }

        return process2(arr, 0, aim, dp);
    }

    private static int process2(int[] arr, int i, int aim, int[][] dp) {
        if (aim < 0) {
            return -1;
        }
        if (dp[i][aim] != -2) {
            return dp[i][aim];
        }

        if (aim == 0) {
            dp[i][aim] = 0;
        }else if (i == arr.length) {
            // aim > 0
            return -1;
        }else {
            int take = process2(arr, i + 1, aim - arr[i], dp);
            int noTake = process2(arr, i + 1, aim, dp);
            if (take == -1 && noTake == -1) {
                dp[i][aim] = -1;
            } else {
                if (take == -1) {
                    dp[i][aim] = noTake;
                } else if (noTake == -1) {
                    dp[i][aim] = take + 1;
                } else {
                    dp[i][aim] = Math.min(take + 1, noTake);
                }
            }
        }
        return dp[i][aim];
    }

    public static void main(String[] args) {

        int[] arr = {2, 3, 1, 3, 4, 5, 6, 2, 23};
        long start = System.nanoTime();
        int minCoins1 = minCoins1(arr, 8);
        System.out.println("minCoins1 = " + minCoins1);
        long end1 = System.nanoTime();
        System.out.println("start1 - end1 = " + (end1 - start));

        int minCoins2 = minCoins1(arr, 8);
        System.out.println("minCoins2 = " + minCoins2);
        long end2 = System.nanoTime();
        System.out.println("end2 - end1 = " + (end2 - end1));

    }
}
