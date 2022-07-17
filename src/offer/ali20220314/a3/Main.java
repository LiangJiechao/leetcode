package offer.ali20220314.a3;

import java.util.Scanner;

/**
 * 0x3f 6
 *
 * @author xiaoliang
 * @date 2022/03/14 19:33
 **/
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String x = in.next();
        String substring = x.substring(2);
//        long l = Long.parseLong(substring, 16);
//        System.out.println(l);
////        Integer value = Integer.valueOf(substring, 16);
//        BigInteger value = getNum(x.toCharArray());

        // 0xeeeeedddddccccc11111
        int count = 0;
        int[] getOneNum = {0,1,1,2,1,2,2,3,1,2,2,3,2,3,3,4};
        for (char c : substring.toCharArray()) {
            if (c>='0'&&c<='9'){
                count+=getOneNum[c-'0'];
            }else {
                count+=getOneNum[c-'a'+10];
            }
        }

//        while (!value.equals(BigInteger.ZERO )) {
//
//            if (value.and(BigInteger.ONE).equals(BigInteger.ONE)) {
//                count++;
//            }
////            if ( (value.mod(BigInteger.valueOf(2))).equals(BigInteger.ONE) ) {
////                count++;
////            }
//            value = value.shiftRight(1);
//        }

        System.out.println(count);
    }
//
//    private static BigInteger getNum(char[] arr) {
//        BigInteger sum = BigInteger.valueOf(0);
//        int level = 1;
//        for (int i = arr.length - 1; i >= 2; i--) {
//            char n = arr[i];
//            int x = 0;
//            if (n >= '0' && n <= '9') {
//                x = n - '0';
//            } else if (n >= 'a' && n <= 'f') {
//                x = 9 + (n - 'a' + 1);
//            }
////            sum += x * Math.pow(16,level-1);
//            sum = sum.add(BigInteger.valueOf((long) (x * Math.pow(16,level-1))) );
//            level++;
//        }
//        return sum;
//    }
}
