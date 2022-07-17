package leetcode.labuladong.la23dp;

/**
 * @author xiaoliang
 * @date 2022/03/10 11:40
 **/
public class La1_LC509_E_斐波那契数 {

    // 严格上不算动态规划，打表法
    public int fib(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 2 || n == 1) {
            return 1;
        }

        int pre = 1, cur = 1;
        for (int i = 3; i <= n; i++) {
            int sum = pre + cur;
            pre = cur;
            cur = sum;
        }
        return cur;
    }

}
