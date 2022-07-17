package offer.meituan2022;

import java.util.Scanner;

/**
 * 输入n个数字，判断每个数字满足以下两个条件之一：
 * 是11的倍数
 * 数位里面1的个数大于等于2
 * 如果满足输入yes，否则输出no
 * 思路很简单，直接模拟判断即可。
 *
 * @author xiaoliang
 * @date 2022/03/13 11:31
 **/
public class Solution1 {

    static boolean judge(int x) {

//        是11的倍数
//        数位里面1的个数大于等于2
        if (x % 11 == 0) {
            return true;
        }
        int count = 0;
        while (x != 0) {

            if (x % 10 == 1) {
                count++;
            }
            if (count == 2) {
                return true;
            }
            x /= 10;
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {

            int num = scanner.nextInt();
            if (judge(num)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }

        }

    }

}
