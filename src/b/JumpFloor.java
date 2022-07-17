package b;

/**
 * @author xiaoliang
 * @version 1.0
 * @description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @date 2021/6/24 17:21
 */
public class JumpFloor {

    public int numWays(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 1 || n ==0) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int first = 1;
        int second = 2;
        int third = 0;
        for (int i = 3; i <= n; i++) {
            third = (first + second) % 1000000007;
            first = second;
            second = third;
        }

        return third;
    }

    public static void main(String[] args) {
        JumpFloor jumpFloor = new JumpFloor();
        System.out.println(jumpFloor.numWays(7));
    }
}
