package offer.weizhongbank.w20220913.w3;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 有多少个长度为 n 的整数序列，每个整数都在 [1, m] 之内，
 * 且这个序列的最长上升子序列的长度恰好等于3
 * 由于答案可能会很大，求得的结果对998244353 取模即可。
 * 输入描述
 * 输入仅一行两个正整数 n, m。
 * <p>
 * 3 ≤ n ≤ 500, 1 ≤ m ≤ 10。
 * <p>
 * 输出描述
 * 输出一个整数，表示答案对 998244353 取模后的结果。
 * <p>
 * <p>
 * 样例输入
 * 4 3
 * 样例输出
 * 9
 *
 * @author xiaoliang
 * @date 2022/09/13 20:43
 **/
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        if (m <= 2) {
            System.out.println(0);
            return;
        }

        LinkedList<Integer> path = new LinkedList<>();
        backtrack(n, m, path);
        System.out.println(res);

//        long mod = 998244353;
//        long[][][][] dp = new long[n + 1][m + 2][m + 2][m + 2];
//        dp[0][m + 1][m + 1][m + 1] = 1;
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= m + 1; j++) {
//                for (int k = j; k <= m + 1; k++) {
//                    for (int l = k; l <= m + 1; l++) {
//                        long now = dp[i - 1][j][k][l];
//                        if (now > 0) {
//                            for (int x = 1; x <= m; x++) {
//                                if (x <= j) {
//                                    dp[i][x][k][l] += now;
//                                    dp[i][x][k][l] %= mod;
//                                } else if (x <= k) {
//                                    dp[i][j][x][l] += now;
//                                    dp[i][j][x][l] %= mod;
//                                } else if (x <= l) {
//                                    dp[i][j][k][x] += now;
//                                    dp[i][j][k][x] %= mod;
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//        long ans = 0;
//        for (int i = 1; i <= m; i++) {
//            for (int j = i; j <= m; j++) {
//                for (int k = j; k <= m; k++) {
//                    ans += dp[n][i][j][k];
//                    ans %= mod;
//                }
//            }
//        }
//        System.out.println(ans);
    }

    private static void backtrack(int n, int m, LinkedList<Integer> path) {

        if (path.size() == n) {
            if (LIS(path) == 3) {
                res++;
                res %= 998244353;
            }
            return;
        }

        for (int i = 1; i <= m; i++) {
            path.add(i);
            backtrack(n, m, path);
            path.removeLast();
        }

    }

    // 最长递增子序列的长度
    private static int LIS(LinkedList<Integer> path) {

        Integer[] arr = path.toArray(new Integer[0]);
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > dp[index]) {
                index++;
                dp[index] = arr[i];
            } else {
                int left = 0;
                int right = index;
                int first = 0;
                while (left <= right) {
                    int mid = left + ((right - left) >> 1);
                    if (dp[mid] >= arr[i]) {
                        first = mid;
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                dp[first] = arr[i];
            }
        }
        return index + 1;
    }

    static int res = 0;
}
