package offer.weizhongbank.wei1;

import java.util.Scanner;

/**
 * 输入一个十进制数
 * 输出十六进制的字母个数
 * @author xiaoliang
 * @date 2022/04/11 18:50
 **/
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
//        String ss = to16String(n);
//        System.out.println(ss);
        String s = Integer.toHexString(n);
        int res = 0;
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'f') {
                res++;
            }
        }
        System.out.println(res);
    }

    private static String to16String(int n) {
        // 正负号
        boolean flag = n >= 0;
        StringBuilder sb = new StringBuilder();
        n = Math.abs(n);
        while (n > 0) {
            int mod = n % 16;
            if (mod > 9) {
                sb.append((char)('a' + (mod - 10)));
            } else {
                sb.append(mod);
            }
            n /= 16;
        }

        return sb.reverse().toString();
    }
}
