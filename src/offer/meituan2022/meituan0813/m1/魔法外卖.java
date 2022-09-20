package offer.meituan2022.meituan0813.m1;

/**
 * 作者：芋圆啵啵-不要芋圆
 * 链接：https://www.nowcoder.com/discuss/1013945?type=post&order=create&pos=&page=1&ncTraceId=&channel=-1&source_id=search_post_nctrack&gio_id=24B388B3E038C6EC048F97CF747D6AA7-1661086540452
 * 来源：牛客网
 * <p>
 * 炸鸡店拥有一名会传送魔法的外卖派送员。
 * 该外卖派送员派送单子时，可以消耗时间t来正常派送单子（一次只能派送一个单子，不能多个同时派送），也可以使用魔法不耗费时间地隔空瞬间投送。
 * 现在炸鸡店在时刻0接收到了若干炸鸡订单，每个单子都有它的截止送达时间。外卖派送员需要保证送达时间小于等于这个截止时间。
 * 现在询问外卖员最少要使用几次魔法来保证没有外卖超时。
 * <p>
 * <p>
 * 输入描述
 * 第一行两个正整数n, t 以空格分开，表示当前接到了n个订单，外卖员在不使用魔法的情况下正常派送所需要消耗的时间t。
 * 第二行n个正整数，每个正整数表示一个订单的截止送达时间。
 * 1 <= n <= 1e5, 1 <= t <= 100, 订单的送达时间介于[1, 1e7]之间
 * 输出描述
 * 一行一个非负整数，表示外卖员最少需要使用的魔法次数。
 * <p>
 * 样例输入
 * 6 5
 * 5 6 7 8 9 10
 * 样例输出
 * 4（感觉和样例2一样啊。？？答案为啥变成4了？？？？？）
 * <p>
 * 提示
 * 样例解释1
 * 这个例子中，最少要使用魔法送达四个，比如送达时间为6，7，8，9这四个订单，然后正常送达5和10的两个订单。
 * 当然也存在其他的送达方法，但可以证明不存在小于需要用四次魔法的方法。
 * <p>
 * 输入样例2
 * 6 5
 * 100 101 102 103 104 105
 * 输出样例2
 * 0
 * 样例解释2
 * 这个例子中，正常一个一个按顺序送就可以。不会超时。所以最少需要使用的魔法次数为零
 * 时刻100，就代表前面100时刻都没有到外卖配送时间，每配送一个只需要5，5个全配送完也就到时刻25，所以是0
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xiaoliang
 * @date 2022/08/21 20:59
 **/
public class 魔法外卖 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int t = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);

        // 正常送就可以完成
        if (n * t <= arr[0]) {
            System.out.println(0);
            return;
        }

        if (t > arr[n - 1]) {
            System.out.println(n);
            return;
        }

        int count = arr[n - 1] % t == 0 ? arr[n - 1] / t : arr[n - 1] / t + 1;
        System.out.println(n - count);
    }
}
