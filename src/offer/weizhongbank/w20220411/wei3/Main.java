package offer.weizhongbank.w20220411.wei3;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 输入一个串num, 和一个数key
 * 求所有能被key整除的子串个数
 * @author xiaoliang
 * @date 2022/04/11 19:23
 **/
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String s = scanner.next();
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String sub = s.substring(i, j);
                BigInteger bigInteger = new BigInteger(sub);
                if (bigInteger.mod(BigInteger.valueOf(k)).equals(BigInteger.ZERO)) {
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}
