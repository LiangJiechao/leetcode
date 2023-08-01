package b;

import java.math.BigInteger;

public class FibArray {

    public int fib(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        BigInteger first = BigInteger.valueOf(1);
        BigInteger second = BigInteger.valueOf(1);
        BigInteger third = BigInteger.valueOf(0);
        for (int i = 3; i <= n; i++) {
            third = first.add(second);
            first = second;
            second = third;

        }
        return third.mod(BigInteger.valueOf(1000000007)).intValue();
    }

    public static void main(String[] args) {
        FibArray fibArray = new FibArray();
        System.out.println(fibArray.fib(48));
    }
}
