package zuo.middleascension.class13;

/**
 * 给定一个节点数n，问能组成几种二叉树结构
 *
 * @author xiaoliang
 * @date 2021/09/25 09:25
 **/
public class Class07_生成二叉树的种类数 {

    public static int kindOfTree1(int n) {

        if (n < 0) {
            throw new RuntimeException("参数错误！");
        }
        return process1(n);
    }

    private static int process1(int n) {
        // base case
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            // 这里注意
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int res = 0;
        for (int left = 0; left <= n - 1; left++) {
            int leftWay = process1(left);
            // n-1-left 是右子树的节点数
            int rightWay = process1(n - 1 - left);
            res += leftWay * rightWay;
        }
        return res;
    }

    public static int kindOfTree2(int n) {

        if (n < 0) {
            throw new RuntimeException("参数错误！");
        }
        return process2(n);
    }

    // todo 给定一个节点数n，问能组成几种二叉树结构
    private static int process2(int n) {

        int[] dp = new int[n + 1];
        // init dp[]
        dp[0] = 1;

        // 从1个节点开始计算，即默认有了头节点
        for (int i = 1; i <= n; i++) {
            for (int left = 0; left < i; left++) {
                dp[i] += dp[left] * dp[i - 1 - left];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(kindOfTree1(4));
        System.out.println(kindOfTree2(4));

        for (int i = 0; i < 15; i++) {
            System.out.println(kindOfTree1(i)==kindOfTree2(i));
        }
    }
}
