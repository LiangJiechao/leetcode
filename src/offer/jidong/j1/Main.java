package offer.jidong.j1;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 
 * @author xiaoliang
 * @date 2022/04/02 18:57
 **/
public class Main {

    public static void main(String[] args) {

        /**
         * 3 2 URL
         */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
//        long x = scanner.nextLong();
        BigInteger x = scanner.nextBigInteger();

        String s = scanner.next();
        char[] arr = s.toCharArray();

        for (char c : arr) {
            if (c == 'U') {
                x= x.shiftRight(1);
//                x >>= 1;
            } else if (c == 'R') {
//                x = (x << 1) + 1;
                x = x.shiftLeft(1).add(BigInteger.ONE);
            } else if (c == 'L') {
//                x <<= 1;
                x= x.shiftLeft(1);
            }
        }
        System.out.println(x.toString());
    }
}
