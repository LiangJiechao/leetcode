package leetcode;

/**
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 *
 * @author xiaoliang
 * @date 2021/11/05 19:32
 **/
public class LC69_E_算术平方根 {


    // 也可用二分法找

    public static int mySqrt(int x) {

        int res = 0;
        int temp = 1;
        while (true) {
            if (x / temp < temp) {
                break;
            }else {
                res = temp;
            }
            temp++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395600));
    }

}
