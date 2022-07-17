package offer.tengxun.t1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目：从上往下读数并 排序
 * 3
 * 0123
 * 1234
 * 2345
 *
 * @author xiaoliang
 * @date 2022/04/24 19:56
 **/
public class Main {

    /**
     * 3
     * 0103
     * 1234
     * 2345
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = scanner.next();
        }
        int len = s[0].length();

        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            int num = 0;
            for (int j = 0; j < n; j++) {
                num = num * 10 + (s[j].charAt(i) - '0');
            }
            res[i] = num;
        }

        Arrays.sort(res);
        for (int item : res) {
            System.out.print(item+" ");
        }

    }
}
