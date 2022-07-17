package zuo.middleascension.class12;

/**
 * gcd:最大公因数
 * lcm:最小公倍数
 *
 * @author xiaoliang
 * @date 2021/09/24 10:51
 **/
public class GcdAndLcm {

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // lcm(a,b) = a*b/gcd(a,b)
    public static int lcm(int a, int b) {
        return a*(b/gcd(a,b));
    }

    public static void main(String[] args) {
        // 123456 和 7890 的最大公因数是 6
        int a = 123456;
        int b = 7890;
        System.out.println("gcd(123456,7890) = " + gcd(a, b));
        System.out.println("lcm(a,b) = " + lcm(6, 8));
    }
}
