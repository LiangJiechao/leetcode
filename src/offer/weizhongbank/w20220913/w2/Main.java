package offer.weizhongbank.w20220913.w2;

import java.util.Scanner;

/**
 * 一天你正在玩一个游戏，游戏中给定一个数a，你需要通过一些简单的移位操作来将其变成b，在每次操作中，你可以将当前的数x变成以下六个数中的一个：
 * <p>
 * x * 2，x * 4，x * 8，x / 2 (如果x被2整除)，x / 4 (如果x被4整除)，x / 8 (如果x被8整除)
 * <p>
 * 例如，如果当前的数x = 12，你可以将他变成24、48、96、6、3，你不能将其变成x / 8，因为12不能被8整除。
 * <p>
 * 现在请问将给定的初始值a通过上述操作变成目标值b需要的最少的操作次数。
 * 输入描述
 * 第一行包含一个正整数t (1≤ t ≤100) ，表示数据组数。
 * <p>
 * 接下来n行每行包括两个空格隔开的正整数a和b，分别表示初始值和目标值。
 * <p>
 * 输出描述
 * 输出n行，每行一个数表示通过上述操作将初始值a变成目标值b需要的最少的操作次数，如果最终无法得到b，则输出-1 。
 * <p>
 * <p>
 * 样例输入
 * 4
 * 3 6
 * 16 2
 * 12 4
 * 1024 1
 * 样例输出
 * 1
 * 1
 * -1
 * 4
 * <p>
 * 提示
 * 对于100%的数据，1≤ a,b ≤1018
 *
 * @author xiaoliang
 * @date 2022/09/13 20:47
 **/
public class Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[][] arr = new long[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = scanner.nextLong();
            arr[i][1] = scanner.nextLong();
        }
        for (int i = 0; i < n; i++) {
            long a = arr[i][0];
            long b = arr[i][1];
            String s1 = Long.toBinaryString(a);
            String s2 = Long.toBinaryString(b);
            int largeOneFlag = a > b ? 1 : 2;
            if (largeOneFlag == 1) {
                if (s1.startsWith(s2)) {
                    String tmp = s1.substring(s2.length());
                    if (judgeZero(tmp)) {
                        int num = tmp.length();
                        System.out.println(countToZero(num));
                    }else {
                        System.out.println("-1");
                    }
                } else {
                    System.out.println("-1");
                }
            } else {
                // b > a
                if (s2.startsWith(s1)) {
                    String tmp = s2.substring(s1.length());
                    if (judgeZero(tmp)) {
                        int num = tmp.length();
                        System.out.println(countToZero(num));
                    }else {
                        System.out.println("-1");
                    }
                } else {
                    System.out.println("-1");
                }

            }
        }

    }

    private static int countToZero(int num) {
        return num % 3 == 0 ? num / 3 : (num / 3 + 1);
    }

    private static boolean judgeZero(String tmp) {
        for (int i = 0; i < tmp.length(); i++) {
            if (tmp.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }

}
