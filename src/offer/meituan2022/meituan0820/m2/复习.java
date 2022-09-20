package offer.meituan2022.meituan0820.m2;

/**
 * 作者：哈利波特/别大
 * 链接：https://www.nowcoder.com/discuss/1021868
 * 来源：牛客网
 *
 * 小美即将进行期末考试！小美现在盘算了一下，一共有n道试题，对于第 i 道试题，小美有着pi的概率做对，获得ai的分值，
 * 另外(1-pi)的概率做错，获得0分。小美的总分即是每道题获得的分数之和。小美不甘于此！她决定突击复习，因为时间有限，
 * 她最多复习m道试题，使得复习后的试题正确率提升到100%。小美想知道，如果她以最佳方式进行复习，能获得的期望总分最大是多少。
 * 输入描述
 * 第一行两个正整数n和m，表示总试题数和最多复习试题数。
 *
 * 接下来一行n个整数，分别为p1 p2...pn，表示小美有pi%的概率，即pi=pi/100的概率做对第i个题。（注意，这里为了简单起见，将概率pi扩张100倍成为整数pi方便输入）
 *
 * 接下来一行n个整数，分别表示a1 a2...an，分别表示第 i 个题做对的分值。
 *
 * 数字间两两有空格隔开，对于所有数据，1≤m≤n≤50000,0≤pi≤100,1≤ai≤1000
 *
 * 输出描述
 * 输出一行一个恰好两位的小数，表示能获得的最大期望总分。（如果答案为10应输出10.00，2.5应输出2.50）
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * input:
 * 2 1
 * 89 38
 * 445 754
 *
 * output:
 * 1150.05
 * @author xiaoliang
 * @date 2022/08/20 22:07
 **/
public class 复习 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] p = new int[n];
        int[] a = new  int[n];

        for (int i = 0; i < n; i++) {
            p[i] = scanner.nextInt();
        }
        double res = 0.0;

        // 丢失的分数
        double[] rest = new double[n];
        for (int i = 0; i  < n; i++) {
            a[i] = scanner.nextInt();
            res+=a[i]*p[i]/100.0;
            rest[i] = a[i]*(100-p[i])/100.0;
        }

        Arrays.sort(rest);
        for (int i = 0; i < m; i++) {
            res += rest[n-i-1];
        }
        System.out.println(String.format("%.2f", res));
    }
}
