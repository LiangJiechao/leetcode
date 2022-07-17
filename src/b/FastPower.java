package b;

import java.math.BigDecimal;

/**
 * @author xiaoliang
 * @version 1.0
 * @description: 快速幂
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 * @date 2021/6/24 17:58
 */
public class FastPower {

    public double fastPower(double base, int n) {
        BigDecimal result = BigDecimal.valueOf(1);
        int power = Math.abs(n);

        while (power != 0) {
            if (power % 2 == 1) {
                result.multiply(BigDecimal.valueOf(base));
            }
            power /= 2;
            base *= base;
        }

        return n < 0 ? BigDecimal.valueOf(1).divide(result).doubleValue() : result.doubleValue();
    }

    public static void main(String[] args) {
        FastPower obj = new FastPower();
        System.out.println(obj.fastPower(2, -21));
    }

}
