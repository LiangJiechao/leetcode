package leetcode.dp;

/**
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * <p>
 * 输入：4
 * 输出：3
 *
 * @author xiaoliang
 * @date 2021/10/22 17:27
 **/
public class LC509_E_斐波那契数 {

    public static int fib(int n) {
        if (n < 0) {
            throw new RuntimeException("参数错误");
        } else if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }
        int pre = 1, post = 1;
        int temp;
        for (int i = 3; i <= n; i++) {
            temp = post;
            post = pre + post;
            pre = temp;
        }
        return post;
    }

    public static void main(String[] args) {
        System.out.println(fib(4));
    }
}
