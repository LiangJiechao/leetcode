package leetcode;

/**
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为 汉明重量）。
 * <p>
 * 输入：n = 11 (控制台输入 00000000000000000000000000001011)
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 *
 * @author xiaoliang
 * @date 2021/12/19 10:55
 **/
public class 剑指Offer15_E_二进制中1的个数 {

    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        if (n == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(128));

      }

}
