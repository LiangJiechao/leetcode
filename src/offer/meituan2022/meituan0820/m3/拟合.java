package offer.meituan2022.meituan0820.m3;

/**
 * 链接：https://www.nowcoder.com/discuss/1021868
 * 来源：牛客网
 * <p>
 * 小团生日收到妈妈送的两个一模一样的数列作为礼物！他很开心的把玩，不过不小心没拿稳将数列摔坏了！现在他手上的两个数列分别为A和B，
 * 长度分别为n和m。小团很想再次让这两个数列变得一样。他现在能做两种操作，操作一是将一个选定数列中的某一个数a改成数b，
 * 这会花费|b-a|的时间，操作二是选择一个数列中某个数a，将它从数列中丢掉，花费|a|的时间。小团想知道，他最少能以多少时间将这两个数列变得再次相同！
 * <p>
 * 输入描述
 * 第一行两个空格隔开的正整数n和m，分别表示数列A和B的长度。
 * <p>
 * 接下来一行n个整数，分别为A1 A2...An
 * <p>
 * 接下来一行m个整数，分别为B1 B2...Bm
 * <p>
 * 对于所有数据，1≤n,m≤2000， |Ai|,|Bi|≤10000
 * <p>
 * 输出描述
 * 输出一行一个整数，表示最少花费时间，来使得两个数列相同。
 */

import java.util.Scanner;

/**
 * input:
 * 1 1
 * -9821
 * 7742
 *
 * output:
 * 17563
 *
 * 作者：Fga
 * 链接：https://www.nowcoder.com/discuss/1021865?type=post&order=create&pos=&page=1&ncTraceId=&channel=-1&source_id=search_post_nctrack&gio_id=24B388B3E038C6EC048F97CF747D6AA7-1661002555029
 * 来源：牛客网
 *
 * @author xiaoliang
 * @date 2022/08/20 23:12
 **/
public class 拟合 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] arr1 = new int[n];
        int[] arr2 = new int[m];

        for (int i = 0; i < n; i++) {
            arr1[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            arr2[i] = scanner.nextInt();
        }

        int[][] dp = new int[n + 1][m + 1];

        // init
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] + Math.abs(arr1[i - 1]);
        }
        for (int i = 1; i <= m; i++) {
            dp[0][i] = dp[0][i - 1] + Math.abs(arr2[i - 1]);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Math.min(
                        dp[i - 1][j - 1] + Math.abs(arr1[i - 1] - arr2[j - 1]),
                        Math.min(dp[i - 1][j] + Math.abs(arr1[i - 1]),
                                dp[i][j - 1] + Math.abs(arr2[j - 1])
                        )
                );
            }
        }
        System.out.println(dp[n][m]);
    }
}
