package leetcode;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * a, b 均可能是负数或 0
 * 结果不会溢出 32 位整数
 *
 * @author xiaoliang
 * @date 2021/12/19 11:19
 **/
public class 剑指Offer65_E_不用加减乘除做加法 {

    /**
     * 思路：异或 ^ == 无进位相加
     * 进位信息 == a&b<<1
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {
        while (b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位,进位信息 == a&b<<1
            a ^= b; // a = 非进位和,异或 ^ == 无进位相加
            b = c; // b = 进位
        }
        return a;
    }
}
